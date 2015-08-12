package pl.kasmagdam.flappy;

import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Kasia on 2015-08-08.
 */
public class Obstacle extends Scrollable {

    private Random r;
    private Flappy flappy = GameScreen.getFlappy();
    private int lives = GameScreen.getLivesLeft();
    public Rect rect = new Rect(0, 0, 0, 0);

    public Obstacle(int x, int y, int width, int height, int scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        /*rect.set(x - width/2, y - height/2, x + width/2, y + height/2);*/
        r = new Random();
    }

    @Override
    public void reset(int x) {
        super.reset(x);

        height = r.nextInt(350) + 122;
    }

    public void update2() {
        rect.set(x - width/2, y - height, x + width/2, y + height);
        checkCollision();
    }

    private void checkCollision() {
        if (Rect.intersects(rect, Flappy.rect)) {
            lives = 0;
        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }


    /*private int centerX, speedX, centerY;
    private Flappy flappy = GameScreen.getFlappy();

    private int lives = GameScreen.getLivesLeft();

    public Rect r = new Rect(0, 0, 0, 0);

    public Obstacle() {
        centerX = 768;//697;
        centerY = 1000;//421;//843;
        speedX = -5;
    }

    public void update() {
        centerX += speedX;
        r.set(centerX - 71, centerY - 150, centerX + 71, centerY + 150);
        checkCollision();
    }

    private void checkCollision() {
        if (Rect.intersects(r, Flappy.rect)) {
            lives = 0;
        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }*/
}
