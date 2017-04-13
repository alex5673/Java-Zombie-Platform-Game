package zombie_platform_game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 * Defines what a Ghost instance does when the player is not in range.
 * @author Alex Gooding
 */
public class StandStillState extends FSMState<Ghost> {
    
    protected void update() {
        Ghost ghost = getContext();
        if (ghost.inRangeLeft()) {
            gotoState(new MoveLeftState());
        } else if (ghost.inRangeRight()) {
            gotoState(new MoveRightState());
        }
    }

    protected void enter() {
        Ghost ghost = getContext();
        ghost.setLinearVelocity(new Vec2(0,0));
    }

    protected void exit() {
    }
}
