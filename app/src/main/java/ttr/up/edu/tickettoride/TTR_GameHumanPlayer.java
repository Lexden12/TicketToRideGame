package ttr.up.edu.tickettoride;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

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

public class TTR_GameHumanPlayer extends GameHumanPlayer{

    private Activity myActivity;

    private int layoutId;
    private TextView[] hand_count;
    private ImageButton[] draw;
    private TextView trainCount;
    private TTR_SurfaceView surfaceView;
    private TTR_GameState state;
    private Spinner routes;
    private ArrayAdapter<String> routeAdapter;
    private Button claimButton;
    private String route;
    private HashMap<String, Bitmap> trainMap;
    private ArrayList<String> unclaimedRoutes;

    TTR_GameHumanPlayer(String name, int layoutId){
        super(name);
        this.layoutId = layoutId;
    }

    @Override
    public View getTopView() {
        return null;
    }

    /**
     * Override receiveInfo to allow the HumanPlayer to accurately update their view.
     * @param info the info being sent to them.
     */
    @Override
    public void receiveInfo(GameInfo info) {
        if (surfaceView == null) return;

        if (info instanceof IllegalMoveInfo || info instanceof NotYourTurnInfo) {
            // if the move was out of turn or otherwise illegal, flash the screen
            surfaceView.flash(Color.RED, 100);
        }
        //todo remove and modify else statement
        else if (!(info instanceof TTR_GameState))
            // if we do not have a TTR_GameState, ignore
            return;
        else {
            state = (TTR_GameState)info;
            for(int i=1;i<6;i++){
                if(state.faceUpTrainCards[i-1]!=null) {
                    draw[i].setVisibility(View.VISIBLE);
                    draw[i].setImageBitmap(trainMap.get(state.faceUpTrainCards[i - 1].getName()));
                }
                else
                    draw[i].setVisibility(View.GONE);
            }
            for(int i=0;i<9;i++){
                hand_count[i].setText(state.getPlayerHands().get(playerNum).getCardCount(i)+"");
            }
            surfaceView.setState(state);
            surfaceView.invalidate();
            trainCount.setText("Trains Remaining: "+state.getPlayerHands().get(playerNum).getTrains());
            Log.i("human player", "receiving");
            if(routes.getAdapter() == null)
                initSpinner();
            for(City c:state.getGraph().getCities().values()){
                for(String s:c.getRoutes().keySet()){
                    if(c.getRoutes().get(s).getPlayerNum() != -1){
                        String r = c.getName() + "<->" + s;
                        routeAdapter.remove(r);
                    }
                }
            }
        }
    }

    private void updateSpinner(){

    }

    /**
     * The game sends the human player the MainActivity of the game, allowing us to initialize
     * our GUI
     * @param activity the main activity of the game
     */
    public void setAsGui(GameMainActivity activity) {

        // remember our activitiy
        myActivity = activity;

        // Load the layout resource for the new configuration
        activity.setContentView(layoutId);
        /*View v = myActivity.findViewById(R.id.runTestButton);
        v.setOnClickListener(activity);*/
        hand_count = new TextView[9];
        hand_count[0] = myActivity.findViewById(R.id.black_count);
        hand_count[1] = myActivity.findViewById(R.id.blue_count);
        hand_count[2] = myActivity.findViewById(R.id.green_count);
        hand_count[3] = myActivity.findViewById(R.id.orange_count);
        hand_count[4] = myActivity.findViewById(R.id.purple_count);
        hand_count[5] = myActivity.findViewById(R.id.rainbow_count);
        hand_count[6] = myActivity.findViewById(R.id.red_count);
        hand_count[7] = myActivity.findViewById(R.id.white_count);
        hand_count[8] = myActivity.findViewById(R.id.yellow_count);
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
        routes = myActivity.findViewById(R.id.routeSpinner);
        claimButton = myActivity.findViewById(R.id.claimButton);
        claimButton.setOnClickListener(drawOnClick);
        trainMap = new HashMap<>();
        trainMap.put("Black Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.black_card));
        trainMap.put("Blue Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.blue_card));
        trainMap.put("Green Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.green_card));
        trainMap.put("Orange Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.orange_card));
        trainMap.put("Purple Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.purple_card));
        trainMap.put("Red Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.red_card));
        trainMap.put("White Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.white_card));
        trainMap.put("Yellow Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.yellow_card));
        trainMap.put("Rainbow Train", BitmapFactory.decodeResource(myActivity.getResources(), R.drawable.rainbow_card));
    }

    /**
     * wait until we receive info with a GameState to initialize the Spinner so that we can have a
     * fully initialized ArrayAdapter
     */
    public void initSpinner(){
        ArrayList<String> routeList = new ArrayList<>();
        for(City c:state.getGraph().cities.values()){
            for(String r:c.getRoutes().keySet()){
                String s = c.getName() + "<->" + r;
                routeList.add(s);
            }
        }
        routeList = quickSort(routeList, 0, routeList.size());
        routeAdapter = new ArrayAdapter<>(myActivity, android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, routeList);
        routes.setAdapter(routeAdapter);
        routes.setOnItemSelectedListener(new RoutesSpinnerListener());
    }

    public ArrayList<String> quickSort(ArrayList<String> list, int low, int high){
        if(low >= high-1)
            return list;
        String pivot = list.get(low);
        int idx = low+1;
        for(int i=low+1; i<high; i++){
            if(list.get(i).compareTo(pivot)<0){
                if(i != idx)
                    list = quickSortHelper(list, i, idx);
                idx++;
            }
        }
        list = quickSortHelper(list, low, idx-1);
        quickSort(list, low, idx-1);
        return quickSort(list, idx, high);
    }

    private ArrayList<String> quickSortHelper(ArrayList<String> list, int i, int j){
        String s = list.get(i);
        list.set(i, list.get(j));
        list.set(j, s);
        return list;
    }

    public int getPlayerNum(){
        return this.playerNum;
    }

    /**
     * Class to handle all the clicks of the buttons in the GUI
     * sends the appropriate GameAction to the game in response to a click
     */
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
            if(v.getId() == R.id.claimButton){
                game.sendAction(new ClaimRouteGameAction(player, route));
            }
        }
    }

    /**
     * Set the route selected in the Spinner each time it changes so that it is accessible
     * in the onClick
     */
    private class RoutesSpinnerListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            route = routeAdapter.getItem(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
