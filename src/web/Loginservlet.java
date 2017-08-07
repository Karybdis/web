package web;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;

public class Loginservlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String who=request.getParameter("who");
        mysql my=new mysql();
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
            System.out.println("密码错误");
        }
        else if (result.equals("UsernameIsWrong"))
        {
            System.out.println("没有该用户");
        }
    //
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
