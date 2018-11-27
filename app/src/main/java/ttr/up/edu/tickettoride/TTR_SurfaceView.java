package ttr.up.edu.tickettoride;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.HashMap;

import ttr.up.edu.game.util.FlashSurfaceView;

public class TTR_SurfaceView extends FlashSurfaceView {
    private TTR_GameState state;
    private Bitmap board;
    private Paint paint;
    private Rect dest;
    private HashMap<String, Bitmap> routeMap;


    public TTR_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        board = BitmapFactory.decodeResource(context.getResources(), R.drawable.board);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(75);

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
        dest = new Rect(0, 0, (int)(canvas.getHeight()*((double)board.getWidth()/board.getHeight())), canvas.getHeight());
        canvas.drawBitmap(board, null, dest, paint);
        if(state!=null) {
            canvas.drawText("Player " + state.getCurrentPlayer() + "'s Turn", dest.right / 2, dest.bottom / 10, paint);
            if(state.getPlayerHands().get(0).getRouteCards().size() > 0 && state.getPlayerHands().get(0).getRouteCards().get(0) != null){
                ArrayList<Card> routeCards = state.getPlayerHands().get(0).getRouteCards();
                int top = 0;
                int left = dest.right;
                int space = (dest.bottom - dest.top - routeMap.get(routeCards.get(0).getName()).getHeight()/2) / routeCards.size();
                for(int i=0;i<routeCards.size();i++){
                    canvas.drawBitmap(routeMap.get(routeCards.get(i).getName()), left, top+space*i, paint);
                }
            }
        }
    }

    public void setState(TTR_GameState state) {
        this.state = state;
        invalidate();
    }
}
