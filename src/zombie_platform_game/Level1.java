package zombie_platform_game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Defines objects that are created in level 1.
 * @author Alex Gooding
 */
public class Level1 extends GameLevel implements ActionListener {
    
    private final static int enemyCount = 5;
    private Zombie zombie;
    private Timer timer;
    private Shape shape2;
    private Body platform1;
    private Shape shape3;
    private Body platform2; 
    
    /**
     * Initialises the objects that are specific to level 1, into the game.
     * @param game the game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        timer = new Timer(15000, this);
        timer.setRepeats(false);
        timer.start();
        
        // platforms
        shape2 = new BoxShape(4, 0.5f);
        platform1 = new StaticBody(this, shape2);
        platform1.setPosition(new Vec2(-4, -1.4f));    
        shape3 = new BoxShape(4, 0.5f);
        platform2 = new StaticBody(this, shape3);
        platform2.setPosition(new Vec2 (9, 3));
        
        // zombies
        for(int i=1; i<=5; i++) {
            zombie = new Zombie(this);
            zombie.setPosition(new Vec2((zombie.getXPos() + i*20), zombie.getYPos()));
            zombie.startWalking(zombie.getSpeed());
            zombie.addCollisionListener(new CollisionHandler(zombie, getPlayer(), this, game));
            zombie.addCollisionListener(new CollisionHandler(zombie, getInvincibilityOrb(), this));
            zombie.addCollisionListener(new CollisionHandler(zombie, getSpeedOrb(), this));
            zombie.addCollisionListener(new CollisionHandler(zombie, getPlayer(), getWall(), this, game));
        }    
    }
    
    /**
     * Destroys the two platforms in the level after the timer resolves.
     * @param ae action event that occurs when the timer ends
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        platform1.destroy();
        platform2.destroy();
        timer.stop();
    }
    
    /**
     * Whether the requirements for completing the level are satisfied.
     * @return true or false depending on whether the amount of zombies remaining is equal to enemy count
     */
    public boolean levelCompleted() {
        return getPlayer().getZombiesRemaining() == enemyCount;
    }
}
