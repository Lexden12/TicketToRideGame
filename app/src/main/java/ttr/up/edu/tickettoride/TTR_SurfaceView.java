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

import ttr.up.edu.game.util.FlashSurfaceView;

public class TTR_SurfaceView extends FlashSurfaceView {
    private TTR_GameState state;
    private Bitmap board;
    private Paint paint;
    private Rect dest;
    private int cardWidth;

    public TTR_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        board = BitmapFactory.decodeResource(context.getResources(), R.drawable.board);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(75);
    }

    @Override
    protected void onDraw(Canvas canvas) {//TODO display and draw hand
        dest = new Rect(0, 0, (int)(canvas.getHeight()*((double)board.getWidth()/board.getHeight())), canvas.getHeight());
        canvas.drawBitmap(board, null, dest, paint);
        if(state!=null) {
            canvas.drawText("Player " + state.getCurrentPlayer() + "'s Turn", dest.right / 2, dest.bottom / 10, paint);
            if (state.getPlayerHands().get(0).getTrainCards().size() > 0 && state.getPlayerHands().get(0).getTrainCards().get(0) != null) {
                ArrayList<Card> trainCards = state.getPlayerHands().get(0).getTrainCards();
                int top = 0;
                int left = dest.right;
                if(cardWidth == 0)
                    cardWidth = trainCards.get(0).getBmp().getWidth();
                int space = (dest.bottom - dest.top - trainCards.get(0).getBmp().getHeight()/2) / trainCards.size();
                for(int i=0;i<trainCards.size();i++){
                    canvas.drawBitmap(trainCards.get(i).getBmp(), left, top+space*i, paint);
                }
            }
            if(state.getPlayerHands().get(0).getRouteCards().size() > 0 && state.getPlayerHands().get(0).getTrainCards().get(0) != null){
                ArrayList<Card> routeCards = state.getPlayerHands().get(0).getRouteCards();
                int top = 0;
                int left = dest.right + cardWidth;
                int space = (dest.bottom - dest.top - routeCards.get(0).getBmp().getHeight()/2) / routeCards.size();
                for(int i=0;i<routeCards.size();i++){
                    canvas.drawBitmap(routeCards.get(i).getBmp(), left, top+space*i, paint);
                }
            }
        }
    }

    public void setState(TTR_GameState state) {
        this.state = state;
        invalidate();
    }
}
