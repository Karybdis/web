package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        int sex=Integer.parseInt(request.getParameter("sex"));
        String email=request.getParameter("email");
        UserDao my=new UserDao();
        my.adduser(username,password,name,sex,email);
        response.sendRedirect("login.jsp");
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
