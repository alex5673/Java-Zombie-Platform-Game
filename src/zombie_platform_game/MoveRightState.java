package zombie_platform_game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 * Defines what a Ghost instance does when the player is in range to the right of the ghost.
 * @author Alex Gooding
 */
public class MoveRightState extends FSMState<Ghost> {
    
    protected void update() {
        Ghost ghost = getContext();
        if (ghost.inRangeLeft()) {
            gotoState(new MoveLeftState());
        } else if (!ghost.inRange()) {
            gotoState(new StandStillState());
        } else {
            ghost.setLinearVelocity(new Vec2(2,0));
        }
    }

    protected void enter() {
        Ghost ghost = getContext();
        ghost.setAngularVelocity(-1);
    }
    
    protected void exit() {
    }
}
