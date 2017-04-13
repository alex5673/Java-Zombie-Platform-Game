package zombie_platform_game;

import city.cs.engine.*;
import fsm.FSM;

/**
 * Creates a ghost enemy.
 * @author Polo Dealer
 */
public class Ghost extends DynamicBody implements StepListener {
    
    private static final Shape enemy = new PolygonShape(1.5f,2.5f,1.5f,-2.2f,-1.5f,-2.2f,-1.5f,2.5f);
    private static final BodyImage ghost = new BodyImage("data/ghost.png",4);
    private final SolidFixture fixture = new SolidFixture(this, enemy);

    private static final float RANGE = 3;
    
    private final Game game;
    private final FSM<Ghost> fsm;
    
    /**
     * Initialises a ghost enemy in the world passed in. 
     * @param game the game
     */
    public Ghost(Game game) {
        super(game.getWorld(), enemy);
        this.game = game;
        addImage(ghost);
        fixture.setDensity(0.5f);
        fixture.setFriction(0);
        fixture.setRestitution(0);
        fsm = new FSM<Ghost>(this, new StandStillState());
        getWorld().addStepListener(this);
    }
    
    /**
     * Whether the player is a certain distance to the left of the ghost enemy.  
     * @return true or false depending on if the gap is less than RANGE.
     */
    public boolean inRangeLeft() {
        Body a = game.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }
    
    /**
     * Whether the player is a certain distance to the right of the ghost enemy.
     * @return true or false depending on if the gap is more than -RANGE.
     */
    public boolean inRangeRight() {
        Body a = game.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;
    }
    
    /**
     * Whether the player is a certain distance to the left or right of the ghost enemy.
     * @return true or false depending on if the gap is more than -RANGE or less than RANGE.
     */
    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
    }
    
    /**
     * Updates the state of the instance of Ghost. 
     * @param e the event that happens before a state change
     */
    public void preStep(StepEvent e) {
        fsm.update();
    }
    
    /**
     * Actions performed after a state change.
     * @param e the event that happens after a state change
     */
    public void postStep(StepEvent e) {
    }
}
