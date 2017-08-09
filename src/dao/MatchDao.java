package dao;

import bean.Match;
import jdk.nashorn.internal.ir.CatchNode;
import org.w3c.dom.ls.LSException;

import java.sql.*;
import java.util.ArrayList;

public class MatchDao
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
    public MatchDao()
    {
        try
        {
            Class.forName(db_drive);   //加载数据库驱动
            conn= DriverManager.getConnection(db_url,user,password);  //建立数据库连接
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
    public void addmatch(String match_name,String start_time,String stop_time)
    {
        String sql;
        sql="INSERT INTO match_info VALUE (?,?,?)";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,match_name);
            pstmt.setString(2,start_time);
            pstmt.setString(3,stop_time);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
    }
    public ArrayList<Match> retrieve()
    {
        ArrayList<Match> matchs=new ArrayList<Match>();
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT match_name,start_time,stop_time FROM match_info");
            while (rs.next())
            {
                Match match=new Match();
                String match_name=rs.getString("match_name");
                String start_time=rs.getString("start_time");
                String stop_time=rs.getString("start_time");
                match.setMatch_name(match_name);
                match.setStart_time(start_time);
                match.setStop_time(stop_time);
                matchs.add(match);
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        return matchs;
    }
}
