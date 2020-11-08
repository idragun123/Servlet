package by.iba.dragun.command.grouppresons;

import by.iba.dragun.command.Command;
import by.iba.dragun.command.CommandResult;
import by.iba.dragun.exception.IncorrectDataException;
import by.iba.dragun.exception.ServiceException;
import by.iba.dragun.model.Person;
import by.iba.dragun.service.PersonService;
import by.iba.dragun.util.pages.Page;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import static by.iba.dragun.command.grouppresons.constant.GroupConstant.*;
import static java.util.Optional.of;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class AddNewPersonCommand implements Command {
    private static final Logger LOGGER =
            Logger.getLogger(AddNewPersonCommand.class.getName());
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException, ServletException {
        PersonService personService = new PersonService();
        Optional<String> newName = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NEWNAME));
        Optional<String> newPhone = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NEWPHONE));
        Optional<String> newEmail = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NEWEMAIL));
        if (isEmpty(newName.get()) || isEmpty(newPhone.get()) || isEmpty(newEmail.get())) {
            LOGGER.info("missing parameter for new person in addition mode");
            request.setAttribute(ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        } else {
            Person newperson = new Person(newName.get(), newPhone.get(),
                    newEmail.get());
            personService.save(newperson);
        }
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}
