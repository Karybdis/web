package dao;

import bean.Match;
import bean.User;
import sun.print.PSStreamPrintService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.xml.ws.Response;
import java.net.ResponseCache;
import java.security.cert.CertPathParameters;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

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
            if (rs!=null) rs.close();
            conn.close();
            if (stmt!=null) stmt.close();
            if (pstmt!=null) pstmt.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
    }

    public String checkuser(String username,String password,String who)  //登录检测
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

    public String username_name(String username,String who)  //找到学号对应的名字
    {
        String sql;
        if (who.equals("0")) sql="SELECT name FROM user_login WHERE username=?";
        else sql="SELECT name FROM admin_login WHERE username=?";
        String name=null;
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                name=rs.getString("name");
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        return name;
    }

    public void adduser(String username,String password,String name ,int sex,String email)  //添加用户
    {
        String sql="INSERT INTO user_login VALUE (?,?,?,?,?)";
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
        close();
    }

    public void deluser_match(String username,int id)   ///删除用户与报名的比赛
    {
        String sql="DELETE FROM user_match WHERE leader_name=? AND id=?";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
    }

    public void adduser_match(String username,String name,int sex,int id,String leader_name)  //添加用户与报名的比赛
    {
        String sql="INSERT INTO user_match VALUE (?,?,?,?,?,?)";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,leader_name);
            pstmt.setString(2,username);
            pstmt.setString(3,name);
            pstmt.setInt(4,sex);
            pstmt.setInt(5,id);
            if (username.equals(leader_name)) pstmt.setInt(6,1);
            else pstmt.setInt(6,0);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
    }

    public int enteruser(String[] usernames,int id)  //报名比赛
    {
        String sql="SELECT username FROM  user_match WHERE id=?";
        String leader_name=usernames[0];
        int i;
        try
        {
            pstmt=conn.prepareStatement(sql);    //是否重复报名判断
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                for (i = 0; i < usernames.length; i++)
                {
                    if (usernames[i].equals(rs.getString("username"))) return 0;
                }
            }
            sql="SELECT * FROM user_login WHERE username=?";   //报名
            for (i=0;i<usernames.length;i++)
            {
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1, usernames[i]);
                rs=pstmt.executeQuery();
                while (rs.next())
                {
                    adduser_match(rs.getString("username"), rs.getString("name"), rs.getInt("sex"), id, leader_name);
                }
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
        return 1;
    }

    public  ArrayList<Match> my_match(String username)  //查找我所报名的比赛
    {
        ArrayList<Match> matchs=new ArrayList<Match>();
        String sql="SELECT * FROM user_match WHERE username=?";
        int[] id=new int[10];
        int[] leader=new int[10];
        int i=0;
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                id[i]=rs.getInt("id");
                leader[i]=rs.getInt("leader");
                i++;
            }
            sql="SELECT  * FROM  match_info WHERE id=?";
            for (i=0;i<id.length;i++)
            {
                pstmt= conn.prepareStatement(sql);
                pstmt.setInt(1,id[i]);
                rs=pstmt.executeQuery();
                while(rs.next())
                {
                    Match match=new Match();
                    match.setId(rs.getInt("id"));
                    match.setMatch_name(rs.getString("match_name"));
                    match.setStart_time(rs.getString("start_time"));
                    match.setStop_time(rs.getString("stop_time"));
                    match.setInformation(rs.getString("information"));
                    if (leader[i]==1) match.setLeader(1);
                    else match.setLeader(0);
                    matchs.add(match);
                }
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
        return matchs;
    }

    public void modify_password(String ex_password,String password,String username)  //修改密码
    {
        String sql="SELECT * FROM user_login WHERE username=?";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                if (ex_password.equals(rs.getString("password")))
                {
                    sql="UPDATE user_login SET password=? WHERE username=?";
                    pstmt=conn.prepareStatement(sql);
                    pstmt.setString(1,password);
                    pstmt.setString(2,username);
                    pstmt.executeUpdate();
                }
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
    }
}

