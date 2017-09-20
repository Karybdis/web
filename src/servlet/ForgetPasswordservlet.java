package servlet;

import bean.User;
import dao.UserDao;
import other.Mail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForgetPasswordservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String username=request.getParameter("username");
        User user= new UserDao().forget_password(username);
        new Mail().sendpassword(user.getEmail(),user.getPassword());
        response.sendRedirect("matchretrieveservlet");
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
