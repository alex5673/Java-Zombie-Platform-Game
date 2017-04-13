package zombie_platform_game;

import city.cs.engine.*;
import java.util.Random;
import org.jbox2d.common.Vec2;

/**
 * Defines the objects that are in every level of the game.
 * @author Polo Dealer
 */
public abstract class GameLevel extends World {
    
    private Player player;
    private InvincibilityOrb orb;
    private SpeedOrb orb2;
    private Shape shape4;
    private Body wall;
    
    Random ran = new Random();
    Random ran2 = new Random();
    int randomStart = ran.nextInt(15) - 10;
    int randomStart2 = ran2.nextInt(15);
   
    /**
     * The current player.
     * @return player
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * The invincibility orb.
     * @return orb
     */
    public InvincibilityOrb getInvincibilityOrb() {
        return orb;
    }
    
    /**
     * The speed orb.
     * @return orb2
     */
    public SpeedOrb getSpeedOrb() {
        return orb2;
    }
    
    /**
     * The scoring wall.
     * @return wall
     */
    public Body getWall() {
        return wall;
    }
    
    /**
     * Initialises the objects that are in every level ie. the player, speed orb, invincibility orb and platforms, into the game. 
     * @param game the game
     */
    public void populate(Game game) {
        
        // Invinvibility orb
        orb = new InvincibilityOrb(this);
        orb.setPosition(new Vec2(randomStart, 30));
        
        // Speed orb
        orb2 = new SpeedOrb(this);
        orb2.setPosition(new Vec2(randomStart2, 30));
        
        // Player
        player = new Player(this);
        player.setPosition(new Vec2(player.getXPos(), player.getYPos()));
        player.setGravityScale(1.3f); 
        player.addCollisionListener(new CollisionHandler(player, orb, this, game));
        player.addCollisionListener(new CollisionHandler(player, orb2, this, game));
        
        // ground
        Shape shape = new BoxShape(1200, 1.5f);
        Body ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -14.8f));
        
        // Wall outside view window to use to increment score when Zombies have been successfully dodged
        shape4 = new BoxShape(1.5f, 650);
        wall = new StaticBody(this, shape4);
        wall.setPosition(new Vec2 (-30, 0));
        
    }
    
    /**
     * Method that will be defined in subclasses that specifies when the current level is completed. 
     * @return true or false depending on whether the level is completed or not
     */
    public abstract boolean levelCompleted();
    
}
