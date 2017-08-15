package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyPasswordservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String ex_password=request.getParameter("ex_password");
        String password=request.getParameter("password");
        String username=request.getParameter("username");
        new UserDao().modify_password(ex_password,password,username);
        response.sendRedirect("home.jsp");
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
