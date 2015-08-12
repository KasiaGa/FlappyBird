package pl.kasmagdam.flappy;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import pl.kasmagdam.framework.Game;
import pl.kasmagdam.framework.Graphics;
import pl.kasmagdam.framework.Image;
import pl.kasmagdam.framework.Screen;
import pl.kasmagdam.framework.Input.TouchEvent;

/**
 * Created by Kasia on 2015-08-01.
 */
public class GameScreen extends Screen {

    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Ready;

    // Variable Setup
    // You would create game objects here.

    static int livesLeft = 1;
    Paint paint, paint2;
    private static Flappy flappy;
    private static Obstacle obst;
    private Image currentSprite, character, character2, character3, character4,
            character5, bg, obstacle, bar, ground;
    private Animation anim, anim2;
    private static boolean hitObstacle, hitGround;
    private ScrollHandler scroller;
    private static Obstacle bar1, bar2;
    private static Ground ground1, ground2;

    public GameScreen(Game game) {
        super(game);

        // Initialize game objects here
        bg = Assets.background;

        flappy = new Flappy();
        scroller = new ScrollHandler(1158);
        bar1 = scroller.getBar1();
        bar2 = scroller.getBar2();
        ground1 = scroller.getGround1();
        ground2 = scroller.getGround2();
        /*obst = new Obstacle();*/

        character = Assets.character;
        character2 = Assets.character2;
        character3 = Assets.character3;
        character4 = Assets.character4;
        character5 = Assets.character5;

        obstacle = Assets.obstacle;
        bar = Assets.bar;
        ground = Assets.ground;

        anim = new Animation();
        anim.addFrame(character, 50);
        anim.addFrame(character2, 50);
        anim.addFrame(character3, 50);
        anim.addFrame(character2, 50);

        anim2 = new Animation();
        anim2.addFrame(character, 200);
        anim2.addFrame(character5, 50);

        currentSprite = anim.getImage();
        hitObstacle = false;
        hitGround = false;

        // Defining a paint object
        paint = new Paint();
        paint.setTextSize(35);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

        paint2 = new Paint();
        paint2.setTextSize(100);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.WHITE);

        state = GameState.Ready;
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        // We have four separate update methods in this example.
        // Depending on the state of the game, we call different update methods.
        // Refer to Unit 3's code. We did a similar thing without separating the
        // update methods.

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List<TouchEvent> touchEvents) {

        // This example starts with a "Ready" screen.
        // When the user touches the screen, the game begins.
        // state now becomes GameState.Running.
        // Now the updateRunning() method will be called!

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_DOWN) {

                if (inBounds(event, 0, 0, 768, 1280)) {
                    state = GameState.Running;
                }
            }
        }



  /*      if (touchEvents.size() > 0)
            state = GameState.Running;*/
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

        //This is identical to the update() method from our Unit 2/3 game.


        // 1. All touch input is handled here:
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_DOWN) {

                flappy.setJumped(true);
                currentSprite = anim.getImage();
            }

            if (event.type == TouchEvent.TOUCH_UP) {

                flappy.setJumped(false);
                currentSprite = anim.getImage();

            }


        }

        if(flappy.getLives() == 0) {
            hitGround = true;
        }

        if(bar1.getLives() == 0 || bar2.getLives() == 0) {
            hitObstacle = true;
        }

        if(hitGround || hitObstacle)
            livesLeft = 0;

        // 2. Check miscellaneous events like death:

        if (livesLeft == 0) {
            state = GameState.GameOver;
        }

        // 3. Call individual update() methods here.
        // This is where all the game updates happen.
        // For example, robot.update();


        flappy.update();

        if (livesLeft == 0) {
            currentSprite = Assets.character4;
        }
        else if(flappy.isShouldntFlap()) {
            currentSprite = anim2.getImage();
        }
        else
            currentSprite = anim.getImage();

        scroller.update();
        bar1.update2();
        bar2.update2();
        /*obst.update();*/
        animate();
    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, 75, 350, 618, 91)) {
                    state = GameState.Running;
                }

                if (inBounds(event, 75, 480, 618, 91)) {
                    nullify();
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN) {
                if (inBounds(event, 75, 350, 618, 91)) {
                    nullify();
                    game.setScreen(new GameScreen(game));
                    return;
                }

                if (inBounds(event, 75, 480, 618, 91)) {
                    nullify();
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }

    }

    private boolean inBounds(TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();

        // First draw the game elements.
        g.drawImage(bg, 0, 0);
        /*g.drawImage(obstacle, obst.getCenterX() - 71, obst.getCenterY() - 157);
        g.drawImage(bar, obst.getCenterX(), obst.getCenterY());*/
        g.drawImage(ground, ground1.getX(), ground1.getY());
        g.drawImage(ground, ground2.getX(), ground2.getY());
        g.drawImage(bar, bar1.getX(), bar1.getY());
        g.drawImage(bar, bar2.getX(), bar2.getY());
        g.drawImage(currentSprite, flappy.getCenterX() - 108, flappy.getCenterY() - 56);
        // Example:
        // g.drawImage(Assets.background, 0, 0);
        // g.drawImage(Assets.character, characterX, characterY);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void nullify() {

        // Set all variables to null. You will be recreating them in the
        // constructor.
        paint = null;
        bg = null;
        flappy = null;
        currentSprite = null;
        character = null;
        character2 = null;
        character3 = null;
        character4 = null;
        character5 = null;
        anim = null;
        anim2 = null;
        obst = null;
        obstacle = null;
        livesLeft = 1;
        bar1 = null;
        bar2 = null;
        ground1 = null;
        ground2 = null;
        bar = null;
        ground = null;

        // Call garbage collector to clean up memory.
        System.gc();
    }

    public void animate() {
        anim.update(10);
        anim2.update(10);
    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();
        g.drawARGB(155, 0, 0, 0);
        /*g.drawString("Tap screen to start.",
                384, 300, paint);*/
        g.drawImage(Assets.tap, 86, 300);

    }

    private void drawRunningUI() {
        Graphics g = game.getGraphics();
    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        // Darken the entire screen so you can display the Paused screen.
        g.drawARGB(155, 0, 0, 0);
        g.drawImage(Assets.paused, 196, 200);
        g.drawImage(Assets.resumebutton, 75, 350);
        g.drawImage(Assets.menubutton, 75, 480);
        /*g.drawString("Resume", 196, 300, paint2);
        g.drawString("Menu", 196, 400, paint2);*/
    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        g.drawARGB(155, 0, 0, 0);
        g.drawImage(Assets.gameover, 94, 200);
        g.drawImage(Assets.tryagainbutton, 75, 350);
        g.drawImage(Assets.menubutton, 75, 480);
        /*g.drawString("GAME OVER.", 384, 300, paint);*/
       /* g.drawString("try again", 384, 450, paint);
        g.drawString("menu", 384, 600, paint);*/
    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        pause();
    }

    public static int getLivesLeft() {
        return livesLeft;
    }

    public static Flappy getFlappy() {
        return flappy;
    }

}
