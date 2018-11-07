package ttr.up.edu.tickettoride;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ttr.up.edu.game.GameHumanPlayer;
import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.infoMsg.GameInfo;

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

public class TTR_GameHumanPlayer extends GameHumanPlayer implements View.OnClickListener{

    private Activity myActivity;

    private int layoutId;

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

    }

    public void setAsGui(GameMainActivity activity) {

        // remember our activitiy
        myActivity = activity;

        // Load the layout resource for the new configuration
        activity.setContentView(layoutId);
        /*View v = myActivity.findViewById(R.id.runTestButton);
        v.setOnClickListener(activity);*/
    }

    public int getPlayerNum(){
        return this.playerNum;
    }

    @Override
    public void onClick(View view) {

    }
}
