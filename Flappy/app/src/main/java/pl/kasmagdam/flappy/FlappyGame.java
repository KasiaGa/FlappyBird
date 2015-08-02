package pl.kasmagdam.flappy;

import pl.kasmagdam.framework.Screen;
import pl.kasmagdam.pl.kasmagdam.framework.implementation.AndroidGame;

/**
 * Created by Kasia on 2015-08-01.
 */
public class FlappyGame extends AndroidGame {

    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this);
    }
}
