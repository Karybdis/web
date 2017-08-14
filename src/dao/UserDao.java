package dao;

import bean.User;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Response;
import java.net.ResponseCache;
import java.sql.*;
import java.util.ArrayList;

public class UserDao
{
    static final String  db_drive="com.mysql.jdbc.Driver";
    static final String db_url="jdbc:mysql://106.14.223.207:3306/mysql";
    //static final String db_url="jdbc:mysql://192.168.99.100:3306/mysql";
    static final String user="root";
    static final String password="zjcx1997@ssc.COM";
    // static final String password="zjcx1997";
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    public UserDao()
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

    public String checkuser(String username,String password,String who)
    {

        try{
            stmt=conn.createStatement();
            if (who.equals("0")) rs=stmt.executeQuery("SELECT username,password FROM  user_login");
            else rs=stmt.executeQuery("SELECT username,password FROM  admin_login");
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

    public void adduser(String username,String password,String name ,int sex,String email)
    {
        String sql;
        sql="INSERT INTO user_login VALUE (?,?,?,?,?)";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,name);
            pstmt.setInt(4,sex);
            pstmt.setString(5,email);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
    }

    public void user_match(String username,String name,int sex,int id)
    {
        String sql="INSERT INTO user_match VALUE (?,?,?,?)";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,name);
            pstmt.setInt(3,sex);
            pstmt.setInt(4,id);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
    }

    public void enteruser(String[] usernames,int id)
    {
        String sql="SELECT * FROM user_login WHERE username=?";
        try
        {
            for (int i=0;i<usernames.length;i++)
            {
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1, usernames[i]);
                rs=pstmt.executeQuery();
                while (rs.next())
                {
                   user_match(rs.getString("username"),rs.getString("name"),rs.getInt("sex"),id);
                }
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
    }
}

