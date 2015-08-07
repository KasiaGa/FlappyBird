package pl.kasmagdam.flappy;

import pl.kasmagdam.framework.Screen;
import pl.kasmagdam.pl.kasmagdam.framework.implementation.AndroidGame;

/**
 * Created by Kasia on 2015-08-01.
 */
public class FlappyGame extends AndroidGame {

//    public static String map;
    boolean firstTimeCreate = true;

    @Override
    public Screen getInitScreen() {

        if (firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }

        return new SplashLoadingScreen(this);
    }

    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }

    @Override
    public void onResume() {
        super.onResume();
        Assets.theme.play();
    }

    @Override
    public void onPause() {
        super.onPause();
        Assets.theme.pause();
    }
}
