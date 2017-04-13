package zombie_platform_game;

import city.cs.engine.*;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Manages all the sound clips needed for background music and sound effects.
 * @author Alex Gooding
 */
public class AudioManager {
    
    private SoundClip level1;
    private SoundClip level2;
    private SoundClip level3;
    private SoundClip invincible;
    private SoundClip superSpeed;
    private SoundClip gameOver;
    
    /**
     * Initialises all the SoundClip variables with sound files, or printing an error message if an exception is found.
     */
    public AudioManager() { 
        
        try {
            level1 = new SoundClip("data/level1_sound.wav");   
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
        
        try {
            level2 = new SoundClip("data/level2_sound.wav");   
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
        
        try {
            level3 = new SoundClip("data/level3_sound.wav");   
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
        
        try {
            invincible = new SoundClip("data/Invincibility_sound.wav");   
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
        
        try {
            superSpeed = new SoundClip("data/super_speed_sound.wav");   
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
        
        try {
            gameOver = new SoundClip("data/game_over_sound.wav");   
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }
    
    /**
     * The level 1 background music.
     * @return level1 sound
     */
    public SoundClip getLevel1Sound() {
        return level1;
    }
    
    /**
     * The level 2 background music.
     * @return level2 sound
     */
    public SoundClip getLevel2Sound() {
        return level2;
    }
     
    /**
     * The level 3 background music.
     * @return level3 sound
     */
    public SoundClip getLevel3Sound() {
        return level3;
    }
    
    /**
     * The invincibility sound. 
     * @return invincible sound
     */
    public SoundClip getInvincibleSound() {
        return invincible;
    }
    
    /**
     * The super speed sound.
     * @return superSpeed sound
     */
    public SoundClip getSuperSpeedSound() {
        return superSpeed;
    }
    
    /**
     * The game over sound.
     * @return gameOver sound
     */
    public SoundClip getGameOverSound() {
        return gameOver;
    }
}
