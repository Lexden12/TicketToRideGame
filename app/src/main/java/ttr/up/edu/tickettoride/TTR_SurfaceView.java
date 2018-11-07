package ttr.up.edu.tickettoride;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class TTR_SurfaceView extends SurfaceView {
    private TTR_GameState state;
    private Bitmap board;
    private Paint paint;
    Rect dest;

    public TTR_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        board = BitmapFactory.decodeResource(context.getResources(), R.drawable.board);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        dest = new Rect(0, 0, (int)(canvas.getHeight()*((double)board.getWidth()/board.getHeight())), canvas.getHeight());
        canvas.drawBitmap(board, null, dest, paint);
    }
}
