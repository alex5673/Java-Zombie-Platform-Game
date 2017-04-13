package zombie_platform_game;
 
import city.cs.engine.*;
import java.awt.BorderLayout;

import javax.swing.JFrame;
  

/**
 * The main class that builds the Game.    
 * @author Alex Gooding
 */
public class Game { 

    private GameLevel world;

    private final MyView view;
    
    private int level;
    
    private final int enemyCount;
    
    private final KeyHandler keyHandler;
    
    private final ControlPanel controlPanel;
    
    private AudioManager audioManager;
    
    private SoundClip levelMusic;
    
    /** Initialise a new Game. */
    public Game() {
        
        level = 1;
        
        enemyCount = 15;
        
        // world
        world = new Level1();
        
        world.populate(this);
        
        // view
        view = new MyView(world, this, 1000, 650);

        view.setGridResolution(1);

        // mouse controls
        view.addMouseListener(new MouseHandler(view, world.getPlayer()));
               

        // display the view in a frame
        JFrame frame = new JFrame("Multi-Level game");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        controlPanel = new ControlPanel(world, this);
        frame.add(controlPanel, BorderLayout.WEST);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        
        keyHandler = new KeyHandler(world.getPlayer());
        // key controls
        frame.addKeyListener(keyHandler);
        
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        // Invincibility
        if(world.getPlayer().getInivincibility() == true) {
           world.getPlayer().removeAllCollisionListeners();
        }   

        // Debugging view
        // JFrame debugView = new DebugViewer(gameWorld, 1000, 650);
        
        // background sound
        audioManager = new AudioManager();
        levelMusic = audioManager.getLevel1Sound();
        levelMusic.loop();
        
        // start!
        world.start();
        
    }

    /** The player in the current level.
     * @return player  */
    public Player getPlayer() {
        return world.getPlayer();
    }
    
    /**
     * The current view.
     * @return view 
     */
    public MyView getMyView() {
        return view;
    }
    
    /**
     * The current world.
     * @return world
     */
    public World getWorld() {
        return world;
    }
    
    /**
     * The current level.
     * @return level
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * The current AudioManager initialised.
     * @return audioManager
     */
    public AudioManager getAudioManager() {
        return audioManager;
    }
    
    /**
     * The current background music associated with the current level.
     * @return levelMusic
     */
    public SoundClip getLevelMusic() {
        return levelMusic;
    }
    
    /**
     * Ends the current level and starts the next level.
     */
    public void goNextLevel() {
        world.stop();
        levelMusic.close();
        if(level == 1) {
            level++;
            world = new Level2();
            world.populate(this);
            keyHandler.setBody(world.getPlayer());
            view.setWorld(world);
            controlPanel.setWorld(world);
            audioManager = new AudioManager();
            levelMusic = audioManager.getLevel2Sound();
            levelMusic.loop();
            world.start();
        }
        else if(level == 2) {
            level++;
            world = new Level3();
            world.populate(this);
            keyHandler.setBody(world.getPlayer());
            view.setWorld(world);
            controlPanel.setWorld(world);
            audioManager = new AudioManager();
            levelMusic = audioManager.getLevel3Sound();
            levelMusic.loop();
            world.start();
        }
        else {
            System.out.println("PLAYER SURVIVED");
            System.exit(0);
        }
    }
    
    /**
     * Initialises a new instance of the current level.
     */
    public void restartLevel() {
        world.stop();
        levelMusic.close();
        if(level == 1) {
            world = new Level1();
            world.populate(this);
            keyHandler.setBody(world.getPlayer());
            view.setWorld(world);
            audioManager = new AudioManager();
            levelMusic = audioManager.getLevel1Sound();
            levelMusic.loop();
            controlPanel.setWorld(world);
            world.start();
        }
        else if(level == 2) {
            world = new Level2();
            world.populate(this);
            keyHandler.setBody(world.getPlayer());
            view.setWorld(world);
            audioManager = new AudioManager();
            levelMusic = audioManager.getLevel2Sound();
            levelMusic.loop();
            world.start();
        }
        else if(level == 3) {
            world = new Level3();
            world.populate(this);
            keyHandler.setBody(world.getPlayer());
            view.setWorld(world);
            audioManager = new AudioManager();
            levelMusic = audioManager.getLevel3Sound();
            levelMusic.loop();
            world.start();
        }
    }
    
    
    /** Run the game.
     * @param args */
    public static void main(String[] args) {
        new Game();
    }
}  

