package pl.kasmagdam.flappy;

import pl.kasmagdam.framework.Image;
import pl.kasmagdam.framework.Music;
import pl.kasmagdam.framework.Sound;

/**
 * Created by Kasia on 2015-08-01.
 */
public class Assets {

    public static Image menu, splash, background, paused, character, character2, character3,
            character4, character5, obstacle, bar, gameover, tap, tryagainbutton, ground;
    public static Image resumebutton, menubutton;
    public static Sound click;
    public static Music theme;

    public static void load(FlappyGame flappyGame) {
        theme = flappyGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();

    }
}
