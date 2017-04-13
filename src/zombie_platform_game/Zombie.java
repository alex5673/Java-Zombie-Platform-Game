package zombie_platform_game;

import city.cs.engine.*;


/**
 * Creates a Zombie enemy.
 * @author Alex Gooding 
 */
public class Zombie extends Walker {
    
    private static final Shape enemy = new PolygonShape(1.5f,2.5f,1.5f,-2.2f,-1.5f,-2.2f,-1.5f,2.5f);
    private static final BodyImage zombie = new BodyImage("data/zombie.png",7);
    
    private final float xPos;
    private final float yPos;
    private final int speed;
    
    /**
     * Initialises a zombie enemy into the world passed in.
     * @param world the world
     */
    public Zombie(World world) {
        super(world, enemy);
        addImage(zombie);
        xPos = 22.5f;
        yPos = -8;
        speed = -4;
    }
    
    /**
     * The x position of the zombie.
     * @return xPos
     */
    public float getXPos() {
        return xPos;
    }
    
    /**
     * The y position of the zombie.
     * @return yPos
     */
    public float getYPos() {
        return yPos;
    }
    
    /**
     * The speed of the zombie.
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }
}
