package by.iba.dragun.command;

import by.iba.dragun.exception.IncorrectDataException;
import by.iba.dragun.exception.ServiceException;
import by.iba.dragun.util.pages.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class RegisterPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException, ServiceException,
            IOException {
        System.out.println("REGISTER_PAGE");
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
}

