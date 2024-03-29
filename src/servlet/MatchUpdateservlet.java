package servlet;

import dao.MatchDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MatchUpdateservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String match_name=request.getParameter("match_name");
        String start_time=request.getParameter("start_time");
        String stop_time=request.getParameter("stop_time");
        int teammate_num=Integer.parseInt(request.getParameter("teammate_num"));
        String information=request.getParameter("information");
        int id=Integer.parseInt(request.getParameter("id"));
        new MatchDao().updatematch(match_name,start_time,stop_time,teammate_num,information,id);
        request.getRequestDispatcher("matchretrieveservlet").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
