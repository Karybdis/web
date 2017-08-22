package servlet;

import dao.MatchDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TeamPrintservlet  extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        int id=Integer.parseInt(request.getParameter("id"));
        int teammate_num=Integer.parseInt(request.getParameter("teammate_num"));
        new MatchDao().team_print(id,teammate_num);
        response.sendRedirect("matchteamservlet?id="+id);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
