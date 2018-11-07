package ttr.up.edu.tickettoride;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import ttr.up.edu.game.util.FlashSurfaceView;

public class TTR_SurfaceView extends FlashSurfaceView {
    private TTR_GameState state;
    private Bitmap board;
    private Paint paint;
    Rect dest;

    public TTR_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        board = BitmapFactory.decodeResource(context.getResources(), R.drawable.board);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(75);
    }

    @Override
    protected void onDraw(Canvas canvas) {//TODO display current player and draw hand
        dest = new Rect(0, 0, (int)(canvas.getHeight()*((double)board.getWidth()/board.getHeight())), canvas.getHeight());
        canvas.drawBitmap(board, null, dest, paint);
        if(state!=null)
            canvas.drawText("Player "+state.getCurrentPlayer()+"'s Turn", dest.right/2, dest.bottom/10, paint);
        //int top = 0;
        //int left = dest.left;
        //int right = left +//TODO finish drawing the hand
        for(Card c:state.getPlayerHands().get(0).getTrainCards()){

        }
    }

    public void setState(TTR_GameState state) {
        this.state = state;
    }
}
