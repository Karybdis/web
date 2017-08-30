package servlet;

import bean.Match;
import dao.UserDao;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MyMatchservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String username=request.getParameter("username");
        ArrayList<Match> matchs=new UserDao().my_match(username);
        request.setAttribute("matchs",matchs);
        request.getRequestDispatcher("my_match.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
