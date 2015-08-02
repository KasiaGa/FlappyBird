package pl.kasmagdam.pl.kasmagdam.framework.implementation;

import java.util.List;

import android.view.View.OnTouchListener;

import pl.kasmagdam.framework.Input;

/**
 * Created by Kasia on 2015-08-01.
 */
public interface TouchHandler extends OnTouchListener {

    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<Input.TouchEvent> getTouchEvents();
}
