package servlet;


import dao.MatchDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MatchAddservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String match_name=request.getParameter("match_name");
        String start_time=request.getParameter("start_time");
        String stop_time=request.getParameter("stop_time");
        int teammate_num=Integer.parseInt(request.getParameter("teammate_num"));
        new MatchDao().addmatch(match_name,start_time,stop_time,teammate_num);
        request.getRequestDispatcher("matchretrieveservlet").forward(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
