package web;

import com.sun.javaws.exceptions.ExitException;

import javax.xml.stream.events.Comment;
import java.sql.*;

public class mysql
{
    static final String  db_drive="com.mysql.jdbc.Driver";
    static final String db_url="jdbc:mysql://192.168.99.100:3306/mysql";
    static final String user="root";
    static final String password="zjcx1997";
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    public mysql()
    {
        try
        {
            Class.forName(db_drive);   //加载数据库驱动
            conn=DriverManager.getConnection(db_url,user,password);  //建立数据库连接
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void close()
    {
        try
        {
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
    }

    public String checkuser(String username,String password)
    {

        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT username,password FROM  sun_login");
            while (rs.next())
            {
                String exist_username = rs.getString("username");
                String exist_password = rs.getString("password");
                if (username.equals(exist_username))
                {
                    if (password.equals(exist_password))
                    {
                        close();
                        return "AllCorrect";
                    }
                    close();
                    return "PasswordIsWrong";
                }
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
        return "UsernameIsWrong";
    }

    /*private void closeconn()
    {
        try
        {
            if(conn!=null) conn.close();
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
    }*/

}

