package ttr.up.edu.tickettoride;

public class Route{
    City city;
    int length, playerNum;
    String color;
    public Route(City c, int l, String c1) {
        city = c;
        length = l;
        color = c1;
    }

    public Route(Route r){
        city = r.getCity();
        length = r.getLength();
        playerNum = r.getPlayerNum();
        color = r.getColor();
    }

    //todo Clarify what the functionality of this is... the behavior seems weird
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
        city.routes.get(city.name).setPlayerNum(playerNum);
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