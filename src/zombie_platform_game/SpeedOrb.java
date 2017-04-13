package zombie_platform_game;

import city.cs.engine.*; 

/**
 * Creates a speed orb pickup object.
 * @author Alex Gooding
 */
public class SpeedOrb extends DynamicBody {
    private static final Shape circle = new CircleShape(0.5f);
    private static final BodyImage orb2 = new BodyImage("data/red_orb.png", 1);
    private final SolidFixture fixture = new SolidFixture(this, circle, 1);
    
    /**
     * Initialises an speed orb into the world passed in.
     * @param world the world
     */
    public SpeedOrb(World world) {
        super(world);
        addImage(orb2);
        fixture.setFriction(0);
        fixture.setRestitution(0);
    }
}