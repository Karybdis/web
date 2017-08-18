package bean;

import java.util.ArrayList;


public class Team
{
    private String leader_name;
    public ArrayList<String> names=new ArrayList<>();
    private int id;

    public String getLeader_name()
    {
        return leader_name;
    }

    public void setLeader_name(String leader_name)
    {
        this.leader_name = leader_name;
    }

    public ArrayList<String> getNames()
    {
        return names;
    }

    public void setNames(ArrayList<String> names)
    {
        this.names = names;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
