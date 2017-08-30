package servlet;

import dao.MatchDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;


public class TeamPrintservlet  extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        int id=Integer.parseInt(request.getParameter("id"));
        int teammate_num=Integer.parseInt(request.getParameter("teammate_num"));
        OutputStream out = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=match"+id+".xlsx");
        response.setContentType("application/msexcel;charset=UTF-8");
        new MatchDao().team_print(id,teammate_num,out);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        doGet(request,response);
    }
}
