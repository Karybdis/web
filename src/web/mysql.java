package web;

import java.sql.*;

public class mysql
{
    static final String  db_drive="com.mysql.jdbc.Driver";
    static final String db_url="jdbc:mysql://192.168.99.100:3306/mysql";
    static final String user="root";
    static final String password="zjcx1997";
    public static void main(String[] args)
    {
        Connection conn=null;
        Statement stmt=null;
        try{
            Class.forName(db_drive);   //加载数据库驱动

            System.out.println("连接数据库");
            conn=DriverManager.getConnection(db_url,user,password);  //建立数据库连接

            stmt=conn.createStatement();  //实例化Statement对像,由当前数据库连接生成一个数据操作对象
            String sql;
            sql="SELECT id,name FROM test";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){

                int id  = rs.getInt("id");
                String name = rs.getString("name");

                System.out.print("ID: " + id);
                System.out.print(", 学生名字: " + name);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(stmt!=null) stmt.close();
            }
            catch(SQLException se2)
            {
            }
            try{
                if(conn!=null) conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

