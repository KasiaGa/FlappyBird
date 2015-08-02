package pl.kasmagdam.framework;

/**
 * Created by Kasia on 2015-07-31.
 */
public interface Image {
    public int getWidth();
    public int getHeight();
    public Graphics.ImageFormat getFormat();
    public void dispose();
}
