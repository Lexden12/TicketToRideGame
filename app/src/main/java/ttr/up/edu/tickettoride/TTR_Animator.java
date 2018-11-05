package ttr.up.edu.tickettoride;

import android.graphics.Canvas;
import android.view.MotionEvent;

import ttr.up.edu.animation.Animator;

public class TTR_Animator implements Animator {
    @Override
    public int interval() {
        return 100;
    }

    @Override
    public int backgroundColor() {
        return 0xFF000000;
    }

    //implement pause with the
    @Override
    public boolean doPause() {
        return false;
    }

    @Override
    public boolean doQuit() {
        return false;
    }

    @Override
    public void tick(Canvas canvas) {

    }

    @Override
    public void onTouch(MotionEvent event) {

    }
}
