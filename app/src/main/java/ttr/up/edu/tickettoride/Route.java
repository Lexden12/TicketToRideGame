package ttr.up.edu.tickettoride;

public class Route{
    City city;
    int length, playerNum;
    String color;
    public Route(City c, int l, String c1) {
        city = c;
        length = l;
        color = c1;
        playerNum = -1;
    }

    public Route(Route r){
        city = r.getCity();
        length = r.getLength();
        playerNum = r.getPlayerNum();
        color = r.getColor();
    }

    public void setPlayerNum(int playerNum) {
        if(this.playerNum != -1) return;
        this.playerNum = playerNum;
    }

    public City getCity() {
        return city;
    }

    public int getLength() {
        return length;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public String getColor() {
        return color;
    }
}