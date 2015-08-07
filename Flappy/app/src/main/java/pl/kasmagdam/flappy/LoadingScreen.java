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
        Assets.menu = g.newImage("menu.png", Graphics.ImageFormat.RGB565);
        Assets.background = g.newImage("background.png", Graphics.ImageFormat.RGB565);
        Assets.paused = g.newImage("paused.png", Graphics.ImageFormat.ARGB4444);
        Assets.character = g.newImage("character.png", Graphics.ImageFormat.ARGB4444);
        /*Assets.character = g.newImage("character.png", Graphics.ImageFormat.ARGB4444);*/
        /*Assets.button = g.newImage("button.png", Graphics.ImageFormat.ARGB4444);*/

//        Assets.click = game.getAudio().createSound("explode.ogg");

        game.setScreen(new MainMenuScreen(game));
    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.splash, 0, 0);
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
