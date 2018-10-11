package ttr.up.edu.tickettoride;

public class Route {
    public enum City{
        Vancouver,
        Calgary,
        Winnipeg,
        Sault_St_Marie,
        Montreal,
        Boston,
        Toronto,
        Duluth,
        Helena,
        Seattle,
        Portland,
        Salt_Lake_City,
        Denver,
        Omaha,
        Chicago,
        Pittsburgh,
        New_York,
        Washington,
        Raleigh,
        Nashville,
        Saint_Louis,
        Kansas_City,
        Little_Rock,
        Oklahoma_City,
        San_Francisco,
        Los_Angeles,
        Phoenix,
        Las_Vegas,
        Santa_Fe,
        El_Paso,
        Dallas,
        Houston,
        New_Orleans,
        Atlanta,
        Charleston,
        Miami
    }

    private City city1, city2;
    private boolean isDual;
    private int player;

    public Route(City c1, City c2, boolean dual){
            city1 = c1;
            city2 = c2;
            isDual = dual;
            player = 0;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "City 1: "+city1.toString()+", City 2: "+city2.toString()+", Claimed by: "+player;
    }
}
