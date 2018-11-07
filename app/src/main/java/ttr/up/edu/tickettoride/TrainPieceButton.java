package ttr.up.edu.tickettoride;

import android.graphics.Color;
import android.graphics.Point;

/**
 * class TrainPieceButton
 *
 * is a class to handle route claiming clicks.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TrainPieceButton {
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
        Miami,
        SEEID
    }

    public enum Color{
        BLACK,
        BLUE,
        RED,
        GREEN,
        YELLOW,
        GRAY
    }

    protected Point topLeft;
    protected Point topRight;
    protected Point bottomLeft;
    protected Point bottomRight;

    protected Color routeColor;
    protected boolean pieceSelected;
    protected boolean pieceClaimed;
    private City city1, city2;
    protected int routeID;
    //need to store if the route is pieceClaimed on board

    public TrainPieceButton(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight, Color color, City city1, City city2, int routeID) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        this.routeColor = color;
        this.city1 = city1;
        this.city2 = city2;
        this.routeID = routeID;
        this.pieceClaimed = false;
        this.pieceSelected = false;
    }

    public TrainPieceButton(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight, Color color, int routeID) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        this.routeColor = color;
        this.city1 = City.SEEID;
        this.city2 = City.SEEID;
        this.routeID = routeID;
        this.pieceClaimed = false;
        this.pieceSelected = false;
    }

    public boolean checkClicked(Point c1, Point c2, Point c3, Point c4){
        return false;
    }

    public void setPieceSelected(boolean pieceSelected){
        this.pieceSelected = pieceSelected;
    }

    public boolean getPieceSelected(){
        return this.pieceSelected;
    }

}
