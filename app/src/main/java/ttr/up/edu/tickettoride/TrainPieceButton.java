package ttr.up.edu.tickettoride;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    //todo finish update instance variable usage
    protected Point topLeft;
    protected Point topRight;
    protected Point bottomLeft;
    protected Point bottomRight;
    protected Color color;
    protected boolean selected;
    protected boolean visible;
    protected BoardRoute route;
    //need to store if the route is claimed on board

    public TrainPieceButton(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight, Color trainColor){
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        this.color = trainColor;
        this.visible = true;
    }

    //todo remove after implementation complete
    /*public void drawTrain(Canvas canvas){

    }*/

    public boolean checkClicked(Point c1, Point c2, Point c3, Point c4){
        return false;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public boolean getSelected(){
        return this.selected;
    }

    public void draw(Canvas c){
        Paint trainPaint = new Paint();
        trainPaint.setColor(Color.GREEN); //temporary
        c.drawLine(topLeft.x, topLeft.y, topRight.x, topRight.y, trainPaint);
        c.drawLine(topLeft.x, topLeft.y, bottomLeft.x, bottomRight.y, trainPaint);
        c.drawLine(bottomLeft.x, bottomLeft.y, bottomRight.x, bottomRight.y, trainPaint);
        c.drawLine(bottomRight.x, bottomRight.y, topRight.x, topRight.y, trainPaint);
    }
}
