package pl.kasmagdam.flappy;

/**
 * Created by Kasia on 2015-08-09.
 */
public class Scrollable {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;
    protected boolean isScrolledLeft;

    public Scrollable(int x, int y, int width, int height, int scrollSpeed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = scrollSpeed;
        isScrolledLeft = false;
    }

    public void update() {
        x += speed;

        if(x + width < 0) {
            isScrolledLeft = true;
        }
    }

    public void reset(int x) {
        this.x = x;
        isScrolledLeft = false;
    }

    public boolean isScrolledLeft() {
        return isScrolledLeft;
    }

    public int getTailX() {
        return x + width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
