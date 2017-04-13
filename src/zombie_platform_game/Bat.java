package zombie_platform_game;

import city.cs.engine.*;

/**
 * Creates a bat enemy.
 * @author Alex Gooding
 */
public class Bat extends DynamicBody {
    
    private static final Shape enemy = new PolygonShape(1.5f,2.5f,1.5f,-2.2f,-1.5f,-2.2f,-1.5f,2.5f);
    private static final BodyImage bat = new BodyImage("data/bat.png",3);
    private final SolidFixture fixture = new SolidFixture(this, enemy, 0.5f);
    
    /**
     * Initialises a bat enemy into the world passed in.
     * @param world the world
     */
    public Bat(World world) {
        super(world);
        addImage(bat);
        fixture.setFriction(0.2f);
        fixture.setRestitution(1);
    }
}
