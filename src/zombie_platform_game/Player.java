package zombie_platform_game;

import city.cs.engine.*;

/**
 * Creates a player.
 * @author Alex Gooding
 */
public class Player extends Walker {
   
    private static final Shape player = new PolygonShape(1,1.5f,1f,-3.2f,-1.5f,-3.4f,-1.5f,1.5f);
    private static final BodyImage man = new BodyImage("data/man0.png", 7);
    
    private boolean invincible;
    private final float xPos;
    private final float yPos;
    private int speed;
    private final int jump;
    private int zombiesRemaining;
    
    /**
     * Initialises the player into the world passed in.
     * @param world the world
     */
    public Player(World world) {
        super(world, player);
        invincible = false;
        xPos = -22.5f;
        yPos = -10;
        speed = 6;
        jump = 15;
        zombiesRemaining = 5;
        addImage(man);
    }
    
    /**
     * Whether the player is invincible or not.
     * @return invincible 
     */
    public boolean getInivincibility() {
        return invincible;
    }  
    
    /**
     * The x position of the player.
     * @return xPos
     */
    public float getXPos() {
        return xPos;
    }
    
    /**
     * The y position of the player.
     * @return yPos
     */
    public float getYPos() {
        return yPos;
    }
    
    /**
     * The speed of the player.
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * The jumping height of the player.
     * @return jump
     */
    public int getJump() {
        return jump;
    }
    
    /**
     * The amount of zombies left.
     * @return zombiesRemaining
     */
    public int getZombiesRemaining() {
        return zombiesRemaining;
    }
    
    /**
     * Changes the speed of the player.
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    /**
     * Changes the amount of zombies left.
     * @param zr
     */
    public void setZombiesRemaining(int zr) {
        zombiesRemaining = zr;
    }
    
    /**
     * Decreases the amount of zombies left. 
     */
    public void decrementZombiesRemaining() {
        zombiesRemaining = zombiesRemaining - 1;
    }
    
    /**
     * Changes whether the player is invincible or not. 
     * @param invincible 
     */
    public void setInvincibility(boolean invincible) {
        this.invincible = invincible;    
    }
}
    

