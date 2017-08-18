package dao;

import bean.Match;
import bean.Team;
import com.sun.scenario.animation.AbstractMasterTimer;
import jdk.nashorn.internal.ir.CatchNode;
import org.w3c.dom.ls.LSException;

import java.sql.*;
import java.time.temporal.TemporalAdjuster;
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
    private PreparedStatement pstmt=null,pstmt2=null;
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

    public void addmatch(String match_name,String start_time,String stop_time,int teammate_num,String information) //添加比赛
    {
        String sql;
        sql="INSERT INTO match_info VALUE (null,?,?,?,?,?)";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,match_name);
            pstmt.setString(2,start_time);
            pstmt.setString(3,stop_time);
            pstmt.setInt(4,teammate_num);
            pstmt.setString(5,information);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
    }

    public void delmatch(int id) //删除比赛
    {
        String sql;
        try
        {
            sql="DELETE FROM match_info WHERE id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            sql="DELETE FROM user_match WHERE id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
    }

    public Match editmatch(int id)  //编辑比赛
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
                match.setTeammate_num(rs.getInt("teammate_num"));
                match.setInformation(rs.getString("information"));
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
        return match;
    }

    public void updatematch(String match_name,String start_time,String stop_time,int teammate_num,String information,int id) //更新编辑好的比赛
    {
        String sql="UPDATE match_info SET match_name=?,start_time=?,stop_time=?,teammate_num=?,information=? WHERE id=?";
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,match_name);
            pstmt.setString(2,start_time);
            pstmt.setString(3,stop_time);
            pstmt.setInt(4,teammate_num);
            pstmt.setString(5,information);
            pstmt.setInt(6,id);
            pstmt.executeUpdate();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
    }


    public ArrayList<Match> retrieve()  //主页显示比赛
    {
        ArrayList<Match> matchs=new ArrayList<Match>();
        try
        {
            stmt = conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM match_info");
            while (rs.next())
            {
                Match match=new Match();
                match.setId(rs.getInt("id"));
                match.setMatch_name(rs.getString("match_name"));
                match.setStart_time(rs.getString("start_time"));
                match.setStop_time(rs.getString("stop_time"));
                match.setInformation(rs.getNString("information"));
                matchs.add(match);
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        close();
        return matchs;
    }

    public ArrayList<Team> match_team(int id)
    {
        String sql="SELECT * FROM user_match WHERE id=?";
        ArrayList<Team> teams=new ArrayList<>();
        ResultSet rs2=null;
        try
        {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                Team team=new Team();
                if (rs.getInt("leader")==1)
                {
                    team.setLeader_name(rs.getString("leader_name"));
                    team.setId(id);
                    sql="SELECT name FROM user_match WHERE id=? AND leader_name=?";
                    pstmt=conn.prepareStatement(sql);
                    pstmt.setInt(1,id);
                    pstmt.setString(2,team.getLeader_name());
                    rs2=pstmt.executeQuery();
                    while (rs2.next())
                        team.names.add(rs2.getString("name"));
                    teams.add(team);
                }
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        return teams;
    }
}
