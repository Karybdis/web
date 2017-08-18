package servlet;

import bean.Match;
import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserEnterservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String[] usernames=request.getParameterValues("username");
        int id=Integer.parseInt(request.getParameter("id"));
        if (new UserDao().enteruser(usernames,id)==0) response.sendRedirect("index.jsp");
        else response.sendRedirect("home.jsp");
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
