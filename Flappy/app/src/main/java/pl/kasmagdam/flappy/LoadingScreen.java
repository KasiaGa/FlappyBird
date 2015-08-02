package pl.kasmagdam.flappy;

import pl.kasmagdam.framework.Game;
import pl.kasmagdam.framework.Graphics;
import pl.kasmagdam.framework.Screen;

/**
 * Created by Kasia on 2015-08-01.
 */
public class LoadingScreen extends Screen {

    public LoadingScreen(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("menu.jpg", Graphics.ImageFormat.RGB565);
        Assets.click = game.getAudio().createSound("explode.ogg");



        game.setScreen(new MainMenuScreen(game));


    }


    @Override
    public void paint(float deltaTime) {


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


    }
}
