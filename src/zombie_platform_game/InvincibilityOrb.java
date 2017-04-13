package zombie_platform_game;

import city.cs.engine.*; 

/**
 * Creates an invincibility orb pickup object.
 * @author Alex Gooding
 */
public class InvincibilityOrb extends DynamicBody {
    private static final Shape circle = new CircleShape(0.5f);
    private static final BodyImage orb = new BodyImage("data/silver_orb.png", 1);
    private final SolidFixture fixture = new SolidFixture(this, circle, 1);
    
    /**
     * Initialises an invincibility orb into the world passed in.
     * @param world the world
     */
    public InvincibilityOrb(World world) {
        super(world);
        addImage(orb);
        fixture.setFriction(0);
        fixture.setRestitution(0);
    }
}