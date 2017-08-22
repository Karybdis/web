package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelMyMatchservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String username=request.getParameter("username");
        int id=Integer.parseInt(request.getParameter("id"));
        String who=request.getParameter("who");
        new UserDao().deluser_match(username,id);
        if ("0".equals(who))
        request.getRequestDispatcher("mymatchservlet?username="+username).forward(request,response);
        else if ("1".equals(who))
            request.getRequestDispatcher("matchteamservlet?id="+id).forward(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
