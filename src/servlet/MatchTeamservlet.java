package servlet;

import bean.Team;
import com.sun.javafx.image.IntPixelGetter;
import dao.MatchDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MatchTeamservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        int id=Integer.parseInt(request.getParameter("id"));
        ArrayList<Team> teams=new MatchDao().match_team(id);
        request.setAttribute("teams",teams);
        request.getRequestDispatcher("match_team.jsp").forward(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}

