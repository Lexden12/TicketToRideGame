package ttr.up.edu.tickettoride;

public class BoardRoute {
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
    public enum Color{
        Red,
        Yellow,
        Green,
        Blue,
        Orange,
        Purple,
        White,
        Black,
        Grey
    }

    private City city1, city2;
    private Color color;
    private boolean isDual;
    private int player;

    public BoardRoute(City c1, City c2, Color c, boolean dual){
            city1 = c1;
            city2 = c2;
            color = c;
            isDual = dual;
            player = 0;
    }

    public BoardRoute clone(){
        BoardRoute boardRoute = new BoardRoute(getCity1(), getCity2(), getColor(), isDual());
        boardRoute.setPlayer(getPlayer());
        return boardRoute;
    }

    public City getCity1() {
        return city1;
    }

    public City getCity2() {
        return city2;
    }

    public Color getColor() {
        return color;
    }

    public int getPlayer() {
        return player;
    }

    public boolean isDual() {
        return isDual;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "City 1: "+city1.toString()+", City 2: "+city2.toString()+", Claimed by: "+player;
    }
}
