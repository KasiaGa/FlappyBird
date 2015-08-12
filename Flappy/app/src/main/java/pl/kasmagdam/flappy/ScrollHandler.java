package pl.kasmagdam.flappy;

/**
 * Created by Kasia on 2015-08-09.
 */
public class ScrollHandler {

    private static Ground ground1, ground2;
    private static Obstacle bar1, bar2;
    public static final int SCROLL_SPEED = -5;
    public static final int PIPE_GAP = 500;

    public ScrollHandler(int y) {
        ground1 = new Ground(0, y, 141, 122, SCROLL_SPEED);
        ground2 = new Ground(ground1.getTailX(), y, 141, 122, SCROLL_SPEED);

        bar1 = new Obstacle(768, 0, 114, 315, SCROLL_SPEED);
        bar2 = new Obstacle(bar1.getTailX() + PIPE_GAP, 0, 114, 315, SCROLL_SPEED);
    }

    public void update() {
        ground1.update();
        ground2.update();
        bar1.update();
        bar2.update();

        if(bar1.isScrolledLeft()) {
            bar1.reset(bar2.getTailX() + PIPE_GAP);
        }
        else if(bar2.isScrolledLeft()) {
            bar2.reset(bar1.getTailX() + PIPE_GAP);
        }

        if(ground1.isScrolledLeft()) {
            ground1.reset(ground2.getTailX());
        }
        else if(ground2.isScrolledLeft()) {
            ground2.reset(ground1.getTailX());
        }
    }

    public Ground getGround1() {
        return ground1;
    }

    public Ground getGround2() {
        return ground2;
    }

    public Obstacle getBar1() {
        return bar1;
    }

    public Obstacle getBar2() {
        return bar2;
    }
}
