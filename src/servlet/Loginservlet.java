package servlet;

import dao.UserDao;
import javafx.scene.control.TableView;

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
            String name=new UserDao().username_name(username,who);
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("name",name);
            request.getSession().setAttribute("who",who);
            response.sendRedirect("home.jsp");
            // request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if (result.equals("PasswordIsWrong"))
        {
            request.setAttribute("answer","PasswordIsWrong");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else if (result.equals("UsernameIsWrong"))
        {
            request.setAttribute("answer","UsernameIsWrong");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
