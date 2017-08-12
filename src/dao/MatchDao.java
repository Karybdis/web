package dao;

import bean.Match;
import com.sun.scenario.animation.AbstractMasterTimer;
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
        sql="INSERT INTO match_info VALUE (null,?,?,?)";
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

    public void delmatch(int id)
    {
        String sql="DELETE FROM match_info WHERE id=?";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }

    }

    public Match editmatch(int id)
    {
        String sql="SELECT * FROM match_info WHERE id=?";
        Match match=new Match();
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            if (rs.next())
            {
                match.setId(id);
                match.setMatch_name(rs.getString("match_name"));
                match.setStart_time(rs.getString("start_time"));
                match.setStop_time(rs.getString("stop_time"));
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }

        return match;
    }

    public void updatematch(String match_name,String start_time,String stop_time,int id)
    {
        String sql="UPDATE match_info SET match_name=?,start_time=?,stop_time=? WHERE id=?";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,match_name);
            pstmt.setString(2,start_time);
            pstmt.setString(3,stop_time);
            pstmt.setInt(4,id);
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
            rs=stmt.executeQuery("SELECT id,match_name,start_time,stop_time FROM match_info");
            while (rs.next())
            {
                Match match=new Match();
                match.setId(rs.getInt("id"));
                match.setMatch_name(rs.getString("match_name"));
                match.setStart_time(rs.getString("start_time"));
                match.setStop_time(rs.getString("stop_time"));
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
