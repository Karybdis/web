package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Loginservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String who=request.getParameter("who");

        UserDao my=new UserDao();
        String result=my.checkuser(username,password,who);
        if (result.equals("AllCorrect"))
        {
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("who",who);
            System.out.println("登录成功");
            response.sendRedirect("home.jsp");
            // request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if (result.equals("PasswordIsWrong"))
        {
            response.sendRedirect("login.jsp");
            System.out.println("密码错误");
        }
        else if (result.equals("UsernameIsWrong"))
        {
            response.sendRedirect("login.jsp");
            System.out.println("没有该用户");
        }
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
