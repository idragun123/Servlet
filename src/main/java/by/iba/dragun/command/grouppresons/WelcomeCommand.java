package by.iba.dragun.command.grouppresons;

import by.iba.dragun.command.Command;
import by.iba.dragun.command.CommandResult;
import by.iba.dragun.exception.IncorrectDataException;
import by.iba.dragun.exception.ServiceException;
import by.iba.dragun.model.Person;
import by.iba.dragun.service.PersonService;
import by.iba.dragun.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.iba.dragun.command.grouppresons.constant.GroupConstant.LISTGROUP;

public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}

