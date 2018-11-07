package ttr.up.edu.tickettoride;

import android.graphics.Color;
import android.graphics.Point;

import java.util.ArrayList;

/**
 * class TrainPieceStash
 *
 * is a class to store all the train pieces in the game
 * holds the count of the number of trains for each routeColor remaining in game
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TrainPieceStash {

    protected ArrayList<TrainPieceButton> trains;

    protected int blueTrains;
    protected int redTrains;
    protected int greenTrains;
    protected int yellowTrains;
    protected int blackTrains;

    public TrainPieceStash() {
        this.blueTrains = 45;
        this.redTrains = 45;
        this.greenTrains = 45;
        this.yellowTrains = 45;
        this.blackTrains = 45;

        trains = new ArrayList<TrainPieceButton>();
        //todo create train buttons needed per path via TrainPieceButton
        //example (values not correct; points will be updated later):
        //once a route (city1 and city2) has been assigned an ID, a separate constructor omitting city1 and city2 can be used
        trains.add(new TrainPieceButton(new Point(0,0),new Point(0,0),new Point(0,0),new Point(0,0), TrainPieceButton.Color.GRAY, TrainPieceButton.City.Calgary, TrainPieceButton.City.Winnipeg, 1) );
    }

    public void takeBlueTrain(){

    }

    public void takeRedTrain(){

    }

    public void takeGreenTrain(){

    }

    public void takeYellowTrain(){

    }

    public void takeBlackTrain(){

    }

}
