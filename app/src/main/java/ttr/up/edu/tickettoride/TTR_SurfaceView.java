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

/**
 * class TTR_SurfaceView
 * <p>
 * a class to represent the map and route cards
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version November 2018
 */

public class TTR_SurfaceView extends FlashSurfaceView {
    private final boolean DEBUG = false;
    private TTR_GameState state;
    private Bitmap board;
    private Paint paint;
    private Rect dest;
    private HashMap<String, Bitmap> routeMap;
    private int clickX;
    private int clickY;
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
     *
     * @param canvas the canvas to draw on
     */
    @Override
    protected void onDraw(Canvas canvas) {
        float xScale = 1753;
        float yScale = 1168;
        int x = (int) (canvas.getHeight() * ((double) board.getWidth() / board.getHeight()));
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
            canvas.drawLine(217, 189, 428, 160, paint); //vancouver-calgary
        } else if (stateInitialized) {
            Paint paint = new Paint();
            paint.setStrokeWidth((float) 10.0);
            for (City city : state.getGraph().getCities().values()) {
                for (String routeName : city.getRoutes().keySet()) {
                    Route route = city.getRoutes().get(routeName);
                    if (route.getPlayerNum() != -1) { //if the route is claimed
                        //get the color of the player who claimed the route
                        paint.setColor(getRouteColor(route));
                        //draw the appropriate line on the map
                        if (city.getName().equals("Vancouver") && routeName.equals("Calgary")) {
                            canvas.drawLine((float) 217 / xScale * (float) x, (float) 189 / yScale * (float) y, (float) 428 / xScale * (float) x, (float) 160 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Portland") && routeName.equals("Seattle1")) {
                            canvas.drawLine((float) 188 / xScale * (float) x, (float) 282 / yScale * (float) y, (float) 168 / xScale * (float) x, (float) 337 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Portland") && routeName.equals("Seattle2")) {
                            canvas.drawLine((float) 190 / xScale * (float) x, (float) 343 / yScale * (float) y, (float) 208 / xScale * (float) x, (float) 297 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Seattle") && routeName.equals("Calgary")) {
                            canvas.drawLine((float) 230 / xScale * (float) x, (float) 278 / yScale * (float) y, (float) 423 / xScale * (float) x, (float) 162 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Calgary") && routeName.equals("Winnipeg")) {
                            canvas.drawLine((float) 430 / xScale * (float) x, (float) 157 / yScale * (float) y, (float) 788 / xScale * (float) x, (float) 169 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Calgary") && routeName.equals("Helena")) {
                            canvas.drawLine((float) 426 / xScale * (float) x, (float) 160 / yScale * (float) y, (float) 585 / xScale * (float) x, (float) 370 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Winnipeg") && routeName.equals("Helena")) {
                            canvas.drawLine((float) 789 / xScale * (float) x, (float) 175 / yScale * (float) y, (float) 588 / xScale * (float) x, (float) 370 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Helena") && routeName.equals("Seattle")) {
                            canvas.drawLine((float) 585 / xScale * (float) x, (float) 368 / yScale * (float) y, (float) 210 / xScale * (float) x, (float) 278 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Portland") && routeName.equals("San Francisco1")) {
                            canvas.drawLine((float) 148 / xScale * (float) x, (float) 675 / yScale * (float) y, (float) 172 / xScale * (float) x, (float) 378 / yScale * (float) y, paint);
                        } else if (city.getName().equals("Portland") && routeName.equals("San Francisco2")) {
                            canvas.drawLine((float) 143 / xScale * (float) x, (float) 367 / yScale * (float) y, (float) 125 / xScale * (float) x, (float) 676 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Seattle") && routeName.equals("Vancouver1")) {
                            canvas.drawLine((float) 198 / xScale * (float) x, (float) 204 / yScale * (float) y, (float) 197 / xScale * (float) x, (float) 257 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Seattle") && routeName.equals("Vancouver2")) {
                            canvas.drawLine((float) 223 / xScale * (float) x, (float) 209 / yScale * (float) y, (float) 223 / xScale * (float) x, (float) 260 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Portland") && routeName.equals("Salt Lake City")) {
                            canvas.drawLine((float) 168 / xScale * (float) x, (float) 360 / yScale * (float) y, (float) 466 / xScale * (float) x, (float) 575 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Helena") && routeName.equals("Salt Lake City")) {
                            canvas.drawLine((float) 465 / xScale * (float) x, (float) 575 / yScale * (float) y, (float) 581 / xScale * (float) x, (float) 370 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Helena") && routeName.equals("Duluth")) {
                            canvas.drawLine((float) 583 / xScale * (float) x, (float) 367 / yScale * (float) y, (float) 974 / xScale * (float) x, (float) 362 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Helena") && routeName.equals("Denver")) {
                            canvas.drawLine((float) 583 / xScale * (float) x, (float) 370 / yScale * (float) y, (float) 676 / xScale * (float) x, (float) 623 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Salt Lake City") && routeName.equals("San Francisco1")) {
                            canvas.drawLine((float) 158 / xScale * (float) x, (float) 660 / yScale * (float) y, (float) 438 / xScale * (float) x, (float) 563 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Salt Lake City") && routeName.equals("San Francisco2")) {
                            canvas.drawLine((float) 448 / xScale * (float) x, (float) 593 / yScale * (float) y, (float) 173 / xScale * (float) x, (float) 685 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Helena") && routeName.equals("Omaha")) {
                            canvas.drawLine((float) 586 / xScale * (float) x, (float) 372 / yScale * (float) y, (float) 921 / xScale * (float) x, (float) 510 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Denver") && routeName.equals("Omaha")) {
                            canvas.drawLine((float) 683 / xScale * (float) x, (float) 625 / yScale * (float) y, (float) 928 / xScale * (float) x, (float) 513 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Duluth") && routeName.equals("Omaha1")) {
                            canvas.drawLine((float) 949 / xScale * (float) x, (float) 377 / yScale * (float) y, (float) 913 / xScale * (float) x, (float) 481 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Duluth") && routeName.equals("Omaha2")) {
                            canvas.drawLine((float) 938 / xScale * (float) x, (float) 493 / yScale * (float) y, (float) 974 / xScale * (float) x, (float) 385 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Duluth") && routeName.equals("Winnipeg")) {
                            canvas.drawLine((float) 786 / xScale * (float) x, (float) 180 / yScale * (float) y, (float) 971 / xScale * (float) x, (float) 362 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Denver") && routeName.equals("Salt Lake City1")) {
                            canvas.drawLine((float) 656 / xScale * (float) x, (float) 598 / yScale * (float) y, (float) 485 / xScale * (float) x, (float) 563 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Denver") && routeName.equals("Salt Lake City2")) {
                            canvas.drawLine((float) 481 / xScale * (float) x, (float) 585 / yScale * (float) y, (float) 650 / xScale * (float) x, (float) 618 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Salt Lake City") && routeName.equals("Las Vegas")) {
                            canvas.drawLine((float) 466 / xScale * (float) x, (float) 590 / yScale * (float) y, (float) 385 / xScale * (float) x, (float) 748 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Los Angeles") && routeName.equals("Las Vegas")) {
                            canvas.drawLine((float) 265 / xScale * (float) x, (float) 828 / yScale * (float) y, (float) 358 / xScale * (float) x, (float) 763 / yScale * (float) y, paint);
                        }else if (city.getName().equals("San Francisco") && routeName.equals("Los Angeles1")) {
                            canvas.drawLine((float) 137 / xScale * (float) x, (float) 708 / yScale * (float) y, (float) 230 / xScale * (float) x, (float) 854 / yScale * (float) y, paint);
                        }else if (city.getName().equals("San Francisco") && routeName.equals("Los Angeles2")) {
                            canvas.drawLine((float) 248 / xScale * (float) x, (float) 834 / yScale * (float) y, (float) 162 / xScale * (float) x, (float) 693 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Los Angeles") && routeName.equals("Phoenix")) {
                            canvas.drawLine((float) 263 / xScale * (float) x, (float) 853 / yScale * (float) y, (float) 448 / xScale * (float) x, (float) 864 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Phoenix") && routeName.equals("Denver")) {
                            canvas.drawLine((float) 455 / xScale * (float) x, (float) 861 / yScale * (float) y, (float) 679 / xScale * (float) x, (float) 623 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Los Angeles") && routeName.equals("El Paso")) {
                            canvas.drawLine((float) 270 / xScale * (float) x, (float) 869 / yScale * (float) y, (float) 636 / xScale * (float) x, (float) 941 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Phoenix") && routeName.equals("Santa Fe")) {
                            canvas.drawLine((float) 455 / xScale * (float) x, (float) 869 / yScale * (float) y, (float) 679 / xScale * (float) x, (float) 623 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Santa Fe") && routeName.equals("El Paso")) {
                            canvas.drawLine((float) 665 / xScale * (float) x, (float) 776 / yScale * (float) y, (float) 651 / xScale * (float) x, (float) 931 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Phoenix") && routeName.equals("El Paso")) {
                            canvas.drawLine((float) 456 / xScale * (float) x, (float) 869 / yScale * (float) y, (float) 651 / xScale * (float) x, (float) 926 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Santa Fe") && routeName.equals("Denver")) {
                            canvas.drawLine((float) 678 / xScale * (float) x, (float) 631 / yScale * (float) y, (float) 666 / xScale * (float) x, (float) 773 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Santa Fe") && routeName.equals("Oklahoma City")) {
                            canvas.drawLine((float) 898 / xScale * (float) x, (float) 751 / yScale * (float) y, (float) 679 / xScale * (float) x, (float) 773 / yScale * (float) y, paint);
                        }else if (city.getName().equals("El Paso") && routeName.equals("Oklahoma City")) {
                            canvas.drawLine((float) 923 / xScale * (float) x, (float) 748 / yScale * (float) y, (float) 666 / xScale * (float) x, (float) 926 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Oklahoma City") && routeName.equals("Denver")) {
                            canvas.drawLine((float) 918 / xScale * (float) x, (float) 739 / yScale * (float) y, (float) 683 / xScale * (float) x, (float) 638 / yScale * (float) y, paint);
                        }else if (city.getName().equals("El Paso") && routeName.equals("Dallas")) {
                            canvas.drawLine((float) 696 / xScale * (float) x, (float) 936 / yScale * (float) y, (float) 941 / xScale * (float) x, (float) 899 / yScale * (float) y, paint);
                        }else if (city.getName().equals("El Paso") && routeName.equals("Houston")) {
                            canvas.drawLine((float) 674 / xScale * (float) x, (float) 956 / yScale * (float) y, (float) 1008 / xScale * (float) x, (float) 976 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Denver") && routeName.equals("Kansas City1")) {
                            canvas.drawLine((float) 941 / xScale * (float) x, (float) 615 / yScale * (float) y, (float) 709 / xScale * (float) x, (float) 650 / yScale * (float) y, paint);
                        }else if (city.getName().equals("Denver") && routeName.equals("Kansas City2")) {
                            canvas.drawLine((float) 701 / xScale * (float) x, (float) 621 / yScale * (float) y, (float) 936 / xScale * (float) x, (float) 590 / yScale * (float) y, paint);
                        }
                    }
                }
            }
        }
        if (state != null) {
            canvas.drawText("Player " + state.getCurrentPlayer() + "'s Turn", dest.right / 2, dest.bottom / 10, paint);
            if (state.getPlayerHands().get(0).getRouteCards().size() > 0 && state.getPlayerHands().get(0).getRouteCards().get(0) != null) {
                ArrayList<RouteCard> routeCards = state.getPlayerHands().get(0).getRouteCards();
                int top = 0;
                int left = dest.right;
                int space = (dest.bottom - dest.top - routeMap.get(routeCards.get(0).getName()).getHeight() / 2) / routeCards.size();
                for (int i = 0; i < routeCards.size(); i++) {
                    canvas.drawBitmap(routeMap.get(routeCards.get(i).getName()), left, top + space * i, paint);
                }
            }
        }
    }

    /**
     * this method is used for development purposes only
     * logs the x and y coordinates to the console
     *
     * @param event the touch event to be handled
     * @return true if the event was handled, false otherwise
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
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
     *
     * @param r the route to examine
     * @return an integer value representing a Color, -1 if the route isn't claimed
     */
    private int getRouteColor(Route r) {
        if (r.getPlayerNum() == -1) return -1;
        String playerHandColor = state.getPlayerHands().get(r.getPlayerNum()).getColor();
        switch (playerHandColor) {
            case "Black":
                return Color.BLACK;
            case "Purple":
                return Color.argb(255, 160, 32, 240);
            case "White":
                return Color.WHITE;
            case "Blue":
                return Color.BLUE;
            case "Yellow":
                return Color.YELLOW;
            case "Orange":
                return Color.argb(255, 136, 0, 204);
            case "Red":
                return Color.RED;
            case "Green":
                return Color.GREEN;
            default:
                return -1;
        }
    }
}
