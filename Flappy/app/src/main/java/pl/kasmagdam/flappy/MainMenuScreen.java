package pl.kasmagdam.flappy;

import java.util.List;

import pl.kasmagdam.framework.Game;
import pl.kasmagdam.framework.Graphics;
import pl.kasmagdam.framework.Input;
import pl.kasmagdam.framework.Screen;

/**
 * Created by Kasia on 2015-08-01.
 */
public class MainMenuScreen extends Screen {

    public MainMenuScreen(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();


        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {


                if (inBounds(event, 80, 375, 615, 85)) {
                    //START GAME
                    game.setScreen(new GameScreen(game));
                }


            }
        }
    }


    private boolean inBounds(Input.TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.menu, 0, 0);
       /* g.drawImage(Assets.button, 90, 90);*/
    }


    @Override
    public void pause() {
    }


    @Override
    public void resume() {


    }


    @Override
    public void dispose() {


    }


    @Override
    public void backButton() {
        android.os.Process.killProcess(android.os.Process.myPid());
        //Display "Exit Game?" Box


    }
}
