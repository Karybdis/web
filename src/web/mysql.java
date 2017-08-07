package web;

import com.sun.javaws.exceptions.ExitException;

import javax.xml.stream.events.Comment;
import java.sql.*;

public class mysql
{
    static final String  db_drive="com.mysql.jdbc.Driver";
   static final String db_url="jdbc:mysql://106.14.223.207:3306/mysql";
   //static final String db_url="jdbc:mysql://192.168.99.100:3306/mysql";
    static final String user="root";

   // static final String password="zjcx1997";
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement pstmt=null;
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

    public String checkuser(String username,String password,String who)
    {

        try{
            stmt=conn.createStatement();
           if (who.equals("0")) rs=stmt.executeQuery("SELECT username,password FROM  sun_login");
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

    public void adduser(String username,String password)
    {
        String sql;
        sql="INSERT INTO sun_login VALUE (?,?)";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
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




    /******************测试用**************/
   /* public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(db_url,user,password);

            // 执行查询
            System.out.println(" 实例化Statement对...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT username, password FROM sun_login";
            ResultSet rs = stmt.executeQuery(sql);
            String a="sun";
            String b="zjcx1997";
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String user = rs.getString("username");
                String pass = rs.getString("password");

                // 输出数据
               if  (a.equals(user))
               {
                   if (b.equals(pass))
                       System.out.println("登陆成功");
                   else System.out.println("登录失败");

               }
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }*/

}

