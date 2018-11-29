package ttr.up.edu.tickettoride;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.HashMap;

import ttr.up.edu.game.util.FlashSurfaceView;

public class TTR_SurfaceView extends FlashSurfaceView{
    private TTR_GameState state;
    private Bitmap board;
    private Paint paint;
    private Rect dest;
    private HashMap<String, Bitmap> routeMap;
    private int clickX;
    private int clickY;
    private final boolean DEBUG = false;
    private boolean stateInitialized;


    public TTR_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        board = BitmapFactory.decodeResource(context.getResources(), R.drawable.board);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(75);
        clickX = -1;
        clickY = -1;
        stateInitialized = false;

        routeMap = new HashMap<>();
        routeMap.put("Winnipeg - Little Rock", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest1));
        routeMap.put("Denver - Pittsburgh", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest2));
        routeMap.put("Portland - Phoenix", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest3));
        routeMap.put("Vancouver - Santa Fe", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest4));
        routeMap.put("Calgary - Phoenix", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest5));
        routeMap.put("Los Angeles - Miami", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest6));
        routeMap.put("Los Angeles - New York", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest7));
        routeMap.put("Boston - Miami", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest8));
        routeMap.put("San Francisco - Atlanta", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest9));
        routeMap.put("Portland - Nashville", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest10));
        routeMap.put("Vancouver - Montreal", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest11));
        routeMap.put("Seattle - New York", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest12));
        routeMap.put("Dallas - New York", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest13));
        routeMap.put("Los Angeles - Chicago", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest14));
        routeMap.put("Toronto - Miami", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest15));
        routeMap.put("Helena - Los Angeles", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest16));
        routeMap.put("Sault St. Marie - Nashville", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest17));
        routeMap.put("Duluth - Houston", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest18));
        routeMap.put("Seattle - Los Angeles", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest19));
        routeMap.put("Montreal - Atlanta", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest20));
        routeMap.put("Sault Ste. Marie - Oklahoma City", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest21));
        routeMap.put("Denver - El Paso", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest22));
        routeMap.put("New York - Atlanta", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest23));
        routeMap.put("Chicago - New Orleans", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest24));
        routeMap.put("Kansas City - Houston", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest25));
        routeMap.put("Calgary - Salt Lake City", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest26));
    }

    /**
     * Overrides the standard View's onDraw. Draws the board and all the cards in the human
     * player's hand.
     * @param canvas the canvas to draw on
     */
    @Override
    protected void onDraw(Canvas canvas) {
        float xScale = 1753;
        float yScale = 1168;
        int x = (int)(canvas.getHeight()*((double)board.getWidth()/board.getHeight()));
        int y = canvas.getHeight();
        dest = new Rect(0, 0, x, y);
        canvas.drawBitmap(board, null, dest, paint);
        if (DEBUG) {
            Log.i("width of map:", "" + x);
            Log.i("height of map", "" + y);
            Paint paint = new Paint();
            paint.setColor(0xff00ff00);
            paint.setStrokeWidth((float) 10.0);
            canvas.drawLine(0, 0, clickX, clickY, paint); //testing drawLine
            canvas.drawLine(217,189,428,160, paint); //vancouver-calgary
        }
        else if (stateInitialized){
            Paint paint = new Paint();
            paint.setStrokeWidth((float) 10.0);
            for (City city : state.getGraph().getCities().values()){
                for (String routeName : city.getRoutes().keySet()){ //todo fix this issue
                    Route route = city.getRoutes().get(routeName);
                    if (route.getPlayerNum() != -1) { //if the route is claimed
                        //get the color of the player who claimed the route
                        paint.setColor(getRouteColor(route));
                        //draw the appropriate line on the map
                        if (city.getName().equals("Winnipeg") && routeName.equals("Calgary")) {
                            canvas.drawLine((float)217/xScale*(float)x, (float)189/yScale*(float)y, (float)428/xScale*(float)x, (float)160/yScale*(float)y, paint);
                        } else if (city.getName().equals("Portland") && routeName.equals("Seattle1")) {
                            canvas.drawLine((float)188/xScale*(float)x, (float)282/yScale*(float)y, (float)168/xScale*(float)x, (float)337/yScale*(float)y, paint);
                        } else if (city.getName().equals("Portland") && route.getCity().equals("Seattle2")) {
                            canvas.drawLine((float)190/xScale*(float)x, (float)343/yScale*(float)y, (float)208/xScale*(float)x, (float)297/yScale*(float)y, paint);
                        }
                        else if (false){
                            //todo continue adding the rest of the cities here...
                        }

                    }
                }
            }
        }
        if(state!=null) {
            canvas.drawText("Player " + state.getCurrentPlayer() + "'s Turn", dest.right / 2, dest.bottom / 10, paint);
            if(state.getPlayerHands().get(0).getRouteCards().size() > 0 && state.getPlayerHands().get(0).getRouteCards().get(0) != null){
                ArrayList<RouteCard> routeCards = state.getPlayerHands().get(0).getRouteCards();
                int top = 0;
                int left = dest.right;
                int space = (dest.bottom - dest.top - routeMap.get(routeCards.get(0).getName()).getHeight()/2) / routeCards.size();
                for(int i=0;i<routeCards.size();i++){
                    canvas.drawBitmap(routeMap.get(routeCards.get(i).getName()), left, top+space*i, paint);
                }
            }
        }
    }

    /**
     * this method is used for development purposes only
     * logs the x and y coordinates to the console
     * @param event the touch event to be handled
     * @return true if the event was handled, false otherwise
     */
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (DEBUG && event.getAction() == MotionEvent.ACTION_UP) {
            clickX = (int) event.getX();
            clickY = (int) event.getY();
            Log.i("X Coordinate: ", "" + clickX);
            Log.i("Y Coordinate: ", "" + clickY);
            this.invalidate();
        }
        return true;
    }

    public void setState(TTR_GameState state) {
        stateInitialized = true;
        this.state = state;
        invalidate();
    }


    /**
     * Gets the player color of a claimed route.
     * Specifically useful for grey routes where who claimed it may not immediately be obvious.
     * @param r the route to examine
     * @return an integer value representing a Color, -1 if the route isn't claimed
     */
    private int getRouteColor(Route r){
        if (r.getPlayerNum() == -1) return -1;
        String playerHandColor = state.getPlayerHands().get(r.getPlayerNum()).getColor();
        switch(playerHandColor){
            case "Black":
                return Color.BLACK;
            case "Purple":
                return Color.argb(255,160,32,240);
            case "White":
                return Color.WHITE;
            case "Blue":
                return Color.BLUE;
            case "Yellow":
                return Color.YELLOW;
            case "Orange":
                return Color.argb(255,136,0,204);
            case "Red":
                return Color.RED;
            case "Green":
                return Color.GREEN;
            default:
                return -1;
        }
    }
}
