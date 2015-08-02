package pl.kasmagdam.pl.kasmagdam.framework.implementation;

import android.media.SoundPool;

import pl.kasmagdam.framework.Sound;

/**
 * Created by Kasia on 2015-08-01.
 */
public class AndroidSound implements Sound {

    int soundId;
    SoundPool soundPool;

    public AndroidSound(SoundPool soundPool, int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }

}
