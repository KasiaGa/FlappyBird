package pl.kasmagdam.pl.kasmagdam.framework.implementation;

import android.graphics.Bitmap;

import pl.kasmagdam.framework.Graphics.ImageFormat;
import pl.kasmagdam.framework.Image;

/**
 * Created by Kasia on 2015-08-01.
 */
public class AndroidImage implements Image {

    Bitmap bitmap;
    ImageFormat format;

    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
