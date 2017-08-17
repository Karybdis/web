package bean;

/**
 * Created by sunsc on 2017/8/9.
 */
public class Match
{
    private int id;
    private String match_name;
    private String start_time;
    private String stop_time;
    private int teammate_num;
    private String information;
    private int leader;

    public String getMatch_name()
    {
        return match_name;
    }

    public void setMatch_name(String match_name)
    {
        this.match_name = match_name;
    }

    public String getStart_time()
    {
        return start_time;
    }

    public void setStart_time(String start_time)
    {
        this.start_time = start_time;
    }

    public String getStop_time()
    {
        return stop_time;
    }

    public void setStop_time(String stop_time)
    {
        this.stop_time = stop_time;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getTeammate_num()
    {
        return teammate_num;
    }

    public void setTeammate_num(int teammate_num)
    {
        this.teammate_num = teammate_num;
    }

    public int getLeader()
    {
        return leader;
    }

    public void setLeader(int leader)
    {
        this.leader = leader;
    }

    public String getInformation()
    {
        return information;
    }

    public void setInformation(String information)
    {
        this.information = information;
    }
}
