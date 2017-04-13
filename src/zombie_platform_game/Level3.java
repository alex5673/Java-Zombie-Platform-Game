package zombie_platform_game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Defines objects that are created in level 3.
 * @author Alex Gooding
 */
public class Level3 extends GameLevel implements ActionListener {
    
    private final static int enemyCount = 15;
    private Zombie zombie;
    private Bat bat;
    private Bat bat2;
    private Ghost ghost;
    private Ghost ghost2;
    private Timer timer;
    private Shape shape2;
    private Body platform1; 
    private Shape shape3;
    private Body platform2;
    
    /**
     * Initialises the objects that are specific to level 2, into the game.
     * @param game the game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        getPlayer().setZombiesRemaining(15);
        
        timer = new Timer(25000, this);
        timer.setRepeats(false);
        timer.start();
        
        // platforms
        shape2 = new BoxShape(6, 0.5f);
        platform1 = new StaticBody(this, shape2);
        platform1.setPosition(new Vec2(-6, 3));
            
        shape3 = new BoxShape(6, 0.5f);
        platform2 = new StaticBody(this, shape3);
        platform2.setPosition(new Vec2 (3, -5));
        
        // bats
        bat = new Bat(this);
        bat.setPosition(new Vec2(10,20));
        bat.setLinearVelocity(new Vec2(-5, 5));
        bat.addCollisionListener(new CollisionHandler(bat, getPlayer(), this, game));
        bat.addCollisionListener(new CollisionHandler(bat, getInvincibilityOrb(), this));
        bat.addCollisionListener(new CollisionHandler(bat, getSpeedOrb(), this));
        
        bat2 = new Bat(this);
        bat2.setPosition(new Vec2(-10,20));
        bat2.setLinearVelocity(new Vec2(5, 5));
        bat2.addCollisionListener(new CollisionHandler(bat2, getPlayer(), this, game));
        bat2.addCollisionListener(new CollisionHandler(bat2, getInvincibilityOrb(), this));
        bat2.addCollisionListener(new CollisionHandler(bat2, getSpeedOrb(), this));
        
        // ghosts
        ghost = new Ghost(game);
        ghost.setPosition(new Vec2(-10, 20));
        ghost.setLinearVelocity(new Vec2(0,5));
        ghost.addCollisionListener(new CollisionHandler(ghost, getPlayer(), this, game));
        ghost.addCollisionListener(new CollisionHandler(ghost, getWall(), this));
        
        ghost2 = new Ghost(game);
        ghost2.setPosition(new Vec2(9, 20));
        ghost2.setLinearVelocity(new Vec2(0,5));
        ghost2.addCollisionListener(new CollisionHandler(ghost2, getPlayer(), this, game));
        ghost2.addCollisionListener(new CollisionHandler(ghost2, getWall(), this));
        
        // zombies
        for(int i=1; i<=15; i++) {
            zombie = new Zombie(this);
            zombie.setPosition(new Vec2((zombie.getXPos() + i*20), zombie.getYPos()));
            zombie.startWalking(zombie.getSpeed() - 1);
            zombie.addCollisionListener(new CollisionHandler(zombie, getPlayer(), this, game));
            zombie.addCollisionListener(new CollisionHandler(zombie, bat, this));
            zombie.addCollisionListener(new CollisionHandler(zombie, ghost, this));
            zombie.addCollisionListener(new CollisionHandler(zombie, bat2, this));
            zombie.addCollisionListener(new CollisionHandler(zombie, ghost2, this));
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
