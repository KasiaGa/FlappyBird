package pl.kasmagdam.flappy;

import pl.kasmagdam.framework.Image;
import pl.kasmagdam.framework.Music;
import pl.kasmagdam.framework.Sound;

/**
 * Created by Kasia on 2015-08-01.
 */
public class Assets {

    public static Image menu, splash, background, paused, character;
    public static Image button;
    public static Sound click;
    public static Music theme;

    public static void load(FlappyGame flappyGame) {
        theme = flappyGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();

    }
}
