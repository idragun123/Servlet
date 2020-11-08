package by.iba.dragun.command.authorithation;

import by.iba.dragun.command.Command;
import by.iba.dragun.command.CommandResult;
import by.iba.dragun.command.session.SessionAttribute;
import by.iba.dragun.exception.IncorrectDataException;
import by.iba.dragun.exception.ServiceException;
import by.iba.dragun.util.pages.Page;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SingOutCommand implements Command {
    private static final Logger LOGGER =
            Logger.getLogger(SingOutCommand.class.getName());
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException {
        HttpSession session = request.getSession();
        String username =
                (String)session.getAttribute(SessionAttribute.NAME);
        LOGGER.info("user was above: name:" + username);
        session.removeAttribute(SessionAttribute.NAME);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
}

