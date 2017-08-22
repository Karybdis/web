package servlet;

import bean.Match;
import dao.MatchDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MatchEditservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id=Integer.parseInt(request.getParameter("id"));
        Match match=new MatchDao().editmatch(id);
        request.setAttribute("match",match);
        request.getRequestDispatcher("match_edit.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
