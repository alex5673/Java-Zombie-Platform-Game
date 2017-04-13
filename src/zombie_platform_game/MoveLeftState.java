package zombie_platform_game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 * Defines what a Ghost instance does when the player is in range to the left of the ghost.
 * @author Alex Gooding
 */
public class MoveLeftState extends FSMState<Ghost> {
    
    protected void update() {
        Ghost ghost = getContext();
        if (ghost.inRangeRight()) {
            gotoState(new MoveRightState());
        } else if (!ghost.inRange()) {
            gotoState(new MoveLeftState());
        } else {
            ghost.setLinearVelocity(new Vec2(-2,0));
        }
    }

    protected void enter() {
        Ghost ghost = getContext();
        ghost.setAngularVelocity(1);
    }
    
    protected void exit() {
        
    }
}
