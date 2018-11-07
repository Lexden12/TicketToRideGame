package ttr.up.edu.tickettoride;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import ttr.up.edu.game.GameHumanPlayer;
import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.infoMsg.GameInfo;
import ttr.up.edu.game.infoMsg.IllegalMoveInfo;
import ttr.up.edu.game.infoMsg.NotYourTurnInfo;

/**
 * class TTR_GameHumanPlayer
 *
 * is a class to extend the GameHumanPlayer to specify it for Ticket To Ride.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TTR_GameHumanPlayer extends GameHumanPlayer implements View.OnTouchListener{

    private Activity myActivity;

    private int layoutId;
    private ImageButton[] draw;
    private TextView trainCount;
    private TTR_SurfaceView surfaceView;
    private TTR_GameState state;

    TTR_GameHumanPlayer(String name, int layoutId){
        super(name);
        this.layoutId = layoutId;
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {
        if (surfaceView == null) return;

        if (info instanceof IllegalMoveInfo || info instanceof NotYourTurnInfo) {
            // if the move was out of turn or otherwise illegal, flash the screen
            surfaceView.flash(Color.RED, 50);
        }
        else if (!(info instanceof TTR_GameState))
            // if we do not have a TTR_GameState, ignore
            return;
        else {
            state = (TTR_GameState)info;
            for(int i=1;i<6;i++){
                if(state.faceUpTrainCards[i-1]!=null) {
                    draw[i].setVisibility(View.VISIBLE);
                    draw[i].setImageBitmap(state.faceUpTrainCards[i - 1].getBmp());
                }
                else
                    draw[i].setVisibility(View.GONE);
            }
            surfaceView.setState(state);
            surfaceView.invalidate();
            trainCount.setText("Trains Remaining: "+45);
            Log.i("human player", "receiving");
        }
    }

    public void setAsGui(GameMainActivity activity) {

        // remember our activitiy
        myActivity = activity;

        // Load the layout resource for the new configuration
        activity.setContentView(layoutId);
        /*View v = myActivity.findViewById(R.id.runTestButton);
        v.setOnClickListener(activity);*/
        draw = new ImageButton[7];
        draw[0] = myActivity.findViewById(R.id.trainDeck);
        draw[1] = myActivity.findViewById(R.id.card1);
        draw[2] = myActivity.findViewById(R.id.card2);
        draw[3] = myActivity.findViewById(R.id.card3);
        draw[4] = myActivity.findViewById(R.id.card4);
        draw[5] = myActivity.findViewById(R.id.card5);
        draw[6] = myActivity.findViewById(R.id.routeDeck);
        DrawOnClick drawOnClick = new DrawOnClick(this);
        for(ImageButton button:draw)
            button.setOnClickListener(drawOnClick);

        surfaceView = myActivity.findViewById(R.id.surfaceView);
        trainCount = myActivity.findViewById(R.id.trainCount);
    }

    public int getPlayerNum(){
        return this.playerNum;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
// ignore if not an "up" event
        if (event.getAction() != MotionEvent.ACTION_UP) return true;
        // get the x and y coordinates of the touch-location;
        // convert them to square coordinates (where both
        // values are in the range 0..2)
        int x = (int) event.getX();
        int y = (int) event.getY();

        // if the location did not map to a legal square, flash
        // the screen; otherwise, create and send an action to
        // the game
        /*if (p == null) {
            surfaceView.flash(Color.RED, 50);
        } else {
            ClaimRouteGameAction action = new ClaimRouteGameAction(this);
            Log.i("onTouch", "Human player sending CRGA ...");
            game.sendAction(action);
            surfaceView.invalidate();
        }*/

        // register that we have handled the event
        return true;
    }

    private class DrawOnClick implements View.OnClickListener{
        private TTR_GameHumanPlayer player;
        public DrawOnClick(TTR_GameHumanPlayer player){
            this.player = player;
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.trainDeck){
                game.sendAction(new DrawTrainDeckGameAction(player));
            }
            if(v.getId() == R.id.card1){
                game.sendAction(new DrawTrainDeckFaceUpGameAction(player, 0));
            }
            if(v.getId() == R.id.card2){
                game.sendAction(new DrawTrainDeckFaceUpGameAction(player, 1));
            }
            if(v.getId() == R.id.card3){
                game.sendAction(new DrawTrainDeckFaceUpGameAction(player, 2));
            }
            if(v.getId() == R.id.card4){
                game.sendAction(new DrawTrainDeckFaceUpGameAction(player, 3));
            }
            if(v.getId() == R.id.card5){
                game.sendAction(new DrawTrainDeckFaceUpGameAction(player, 4));
            }
            if(v.getId() == R.id.routeDeck){
                game.sendAction(new DrawRouteDeckGameAction(player));
            }
        }
    }
}
