package pl.kasmagdam.flappy;

import android.graphics.Rect;

/**
 * Created by Kasia on 2015-08-06.
 */
public class Flappy {

    private int lives = GameScreen.getLivesLeft();

    final int UPSPEED = -15;
    final int DOWNSPEED = 5;

    private int centerX = 384;
    private int centerY = 640;
    private boolean jumped = false;
    private boolean movingDown = true;

    private int speedUp = 0;
    private int speedDown = 5;

    private float rotation;
    private static boolean shouldntFlap = false;

    public static Rect rect = new Rect(0, 0, 0, 0);

    public void update() {
/*        if (speedUp > 0) {
            centerY += speedUp;
        }*/

        if(jumped) {
            speedUp = 20;
            speedDown = 0;
        }

        if(!jumped) {
            speedUp = 0;
        }

        if(centerY >1120) {
            lives = 0;
            /*speedDown = 0;*/
        }

        if(centerY <=1120) {
            speedDown = 5;
        }

        if(centerY<0) {
            speedUp=0;
        }

        if(speedUp <=0) {
            shouldntFlap = true;
        }
        else
            shouldntFlap = false;

        centerY += speedDown;
        centerY -= speedUp;

        rect.set(centerX - 108, centerY - 56, centerX + 108, centerY + 56);

    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public boolean isJumped() {
        return jumped;
    }

    public int getSpeedUp() {
        return speedUp;
    }

    public int getSpeedDown() {
        return speedDown;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }

    public void setSpeedUp(int speedUp) {
        this.speedUp = speedUp;
    }

    public void setSpeedDown(int speedDown) {
        this.speedDown = speedDown;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public static boolean isShouldntFlap() {
        return shouldntFlap;
    }

    public static void setShouldntFlap(boolean shouldntFlap) {
        Flappy.shouldntFlap = shouldntFlap;
    }

}
