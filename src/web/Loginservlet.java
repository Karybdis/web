package web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

public class Loginservlet extends HttpServlet
{
    public void doget(HttpServletRequest request, HttpServletResponse response) throws SerialException,IOException
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        mysql my=new mysql();
        String result=my.checkuser(username,password);
        if (result.equals("AllCorrect"))
        {
            System.out.println("登录成功");
        }
        else if (result.equals("PasswordIsWrong"))
        {
            System.out.println("密码错误");
        }
        else if (result.equals("UsernameIsWrong"))
        {
            System.out.println("没有该用户");
        }
    }
}
