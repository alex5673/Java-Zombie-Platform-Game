package zombie_platform_game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
 

/**
 * Handles all the collisions between the objects in the game ie. the player and the enemies.
 * @author Alex Gooding
 */
public class CollisionHandler implements CollisionListener, ActionListener {
    private Zombie zombie;
    private Player player;
    private InvincibilityOrb orb;
    private SpeedOrb orb2;
    private Bat bat;
    private Ghost ghost;
    private Body wall;
    private World world;
    private Game game;
    private Timer timer;
    private Timer timer2;
    
    /**
     * CollisionHandler constructor for collisions between: The player and zombie enemies.
     * @param zombie a zombie enemy
     * @param player the player 
     * @param world the world
     * @param game the game
     */
    public CollisionHandler(Zombie zombie, Player player, World world, Game game) {
       this.zombie = zombie;
       this.player = player;
       this.world = world;
       this.game = game;
    }
     
    /**
     * CollisionHandler constructor for collisions between: The player and bat enemies.
     * @param bat a bat enemy
     * @param player the player
     * @param world the world
     * @param game the game
     */
    public CollisionHandler(Bat bat, Player player, World world, Game game) {
        this.bat = bat;
        this.player = player;
        this.world = world;
        this.game = game;
    }
     
    /**
     * CollisionHandler constructor for collisions between: Zombie enemies and bat enemies.
     * @param zombie a zombie enemy 
     * @param bat a bat enemy 
     * @param world the world
     */
    public CollisionHandler(Zombie zombie, Bat bat, World world) {
        this.zombie = zombie;
        this.bat = bat;
        this.world = world;
    }
     
    /**
     * CollisionHandler constructor for collisions between: The player and ghost enemies.
     * @param ghost a ghost enemy
     * @param player the player
     * @param world the world 
     * @param game the game
     */
    public CollisionHandler(Ghost ghost, Player player, World world, Game game) {
        this.ghost = ghost;
        this.player = player;
        this.world = world;
        this.game = game;
    }
     
    /**
     * CollisionHandler constructor for collisions between: Zombie enemies and ghost enemies.
     * @param zombie a zombie enemy
     * @param ghost a ghost enemy
     * @param world the world
     */
    public CollisionHandler(Zombie zombie, Ghost ghost, World world) {
        this.zombie = zombie;
        this.ghost = ghost;
        this.world = world;
    }
     
    /**
     * CollisionHandler constructor for collisions between: The player and invincibility orbs.
     * @param player the player
     * @param orb an invincibility orb
     * @param world the world
     * @param game the game
     */
    public CollisionHandler(Player player, InvincibilityOrb orb, World world, Game game) {
        this.player = player;
        this.orb = orb;
        this.world = world;
        this.game = game;
    } 
     
    /**
     * CollisionHandler constructor for collisions between: Zombie Enemies and invincibility orbs.
     * @param zombie a zombie enemy 
     * @param orb an invincibility orb
     * @param world the world
     */
    public CollisionHandler(Zombie zombie, InvincibilityOrb orb, World world) {
        this.zombie = zombie;
        this.orb = orb;
        this.world = world;
    } 
     
    /**
     * CollisionHandler constructor for collisions between: Bat enemies and invincibility orbs.
     * @param bat a bat enemy 
     * @param orb an invincibility orb
     * @param world the world
     */
    public CollisionHandler(Bat bat, InvincibilityOrb orb, World world) {
        this.bat = bat;
        this.orb = orb;
        this.world = world;
    } 
      
    /**
     * CollisionHandler constructor for collisions between: The player and speed orbs.
     * @param player the player
     * @param orb2 a speed orb
     * @param world the world
     * @param game the game
     */
    public CollisionHandler(Player player, SpeedOrb orb2, World world, Game game) {
        this.player = player;
        this.orb2 = orb2;
        this.world = world;
        this.game = game;
    }
     
    /**
     * CollisionHandler constructor for collisions between: Zombie enemies and speed orbs.
     * @param zombie a zombie enemy 
     * @param orb2 a speed orb
     * @param world the world
     */
    public CollisionHandler(Zombie zombie, SpeedOrb orb2, World world) {
        this.zombie = zombie;
        this.orb2 = orb2;
        this.world = world;
    }
     
    /**
     * CollisionHandler constructor for collisions between: Bat enemies and speed orbs.
     * @param bat a bat enemy 
     * @param orb2 a speed orb
     * @param world the world
     */
    public CollisionHandler(Bat bat, SpeedOrb orb2, World world) {
        this.bat = bat;
        this.orb2 = orb2;
        this.world = world;
    }
      
    /**
     * CollisionHandler constructor for collisions for collisions between: Zombie enemies and the wall outside of the user view that increments the player's score when a zombie goes out of the user view.
     * @param zombie a zombie enemy 
     * @param player the player
     * @param wall the scoring wall
     * @param world the world
     * @param game the game
     */
    public CollisionHandler(Zombie zombie, Player player, Body wall, World world, Game game) {
        this.zombie = zombie;
        this.player = player;
        this.wall = wall;
        this.world = world;
        this.game = game;
    }
     
    /**
     * CollisionHandler constructor for collisions for collisions between: Ghost enemies and the wall outside of the user view that increments the player's score when a ghost goes out of the user view
     * @param ghost a ghost enemy 
     * @param wall the scoring wall
     * @param world the world
     */
    public CollisionHandler(Ghost ghost, Body wall, World world) {
        this.ghost = ghost;
        this.wall = wall;
        this.world = world;
    }
    
    /**
     * Handles the operations that occur when objects within the game collide with each other
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        // Zombie collisons with player
        if ((e.getOtherBody() == player) && (e.getReportingBody() == zombie) && (player.getInivincibility() == false)) {
            zombie.stopWalking();
            player.stopWalking();
            System.out.println("GAME OVER");
            game.getLevelMusic().close();
            game.getAudioManager().getGameOverSound().play();
            world.stop();
        }
        else if ((e.getOtherBody() == player) && (e.getReportingBody() == zombie) && (player.getInivincibility() == true) &&  (player.getZombiesRemaining() > 1)) {
            zombie.destroy();
            player.decrementZombiesRemaining();
            System.out.println("ZOMBIE DESTROYED");
            System.out.println("" + player.getZombiesRemaining());
        }
        else if ((e.getOtherBody() == player) && (e.getReportingBody() == zombie) && (player.getInivincibility() == true) && (player.getZombiesRemaining() == 1)) {
            zombie.destroy();
            player.decrementZombiesRemaining();
            System.out.println("ZOMBIE DESTROYED");
            System.out.println("" + player.getZombiesRemaining());
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
        
        // Bat collisons with player
        if ((e.getOtherBody() == player) && (e.getReportingBody() == bat) && (player.getInivincibility() == false)) {
            bat.setLinearVelocity(new Vec2(0,0));
            player.stopWalking();
            System.out.println("GAME OVER");
            game.getLevelMusic().close();
            game.getAudioManager().getGameOverSound().play();
            world.stop();
        }
        else if ((e.getOtherBody() == player) && (e.getReportingBody() == bat) && (player.getInivincibility() == true)) {
            bat.destroy();
            System.out.println("BAT DESTROYED"); 
        } 
        
        // Ghost collisions with player
        if ((e.getOtherBody() == player) && (e.getReportingBody() == ghost) && (player.getInivincibility() == false)) {
            ghost.setLinearVelocity(new Vec2(0,0));
            player.stopWalking();
            System.out.println("GAME OVER");
            game.getLevelMusic().close();
            game.getAudioManager().getGameOverSound().play();
            world.stop();
        }
        else if ((e.getOtherBody() == player) && (e.getReportingBody() == ghost) && (player.getInivincibility() == true)) {
            ghost.destroy();
            System.out.println("GHOST DESTROYED");
        }
        
        // Invinsibility orb collision with player
        if (e.getOtherBody() == orb && e.getReportingBody() == player) {
            orb.destroy();
            timer = new Timer(15000, this);
            timer.setRepeats(false);
            player.setInvincibility(true);
            game.getLevelMusic().pause();
            game.getAudioManager().getInvincibleSound().play();
            timer.start();
            System.out.println("INVINCIBLE");
        }
        
        // Speed orb with player
        if (e.getOtherBody() == orb2 && e.getReportingBody() == player) {
            orb2.destroy();
            timer2 = new Timer(15000, this);
            timer2.setRepeats(false);
            player.setSpeed(8);
            game.getLevelMusic().pause();
            game.getAudioManager().getSuperSpeedSound().play();
            timer2.start();
            System.out.println("SUPER SPEED");
        } 
        
        // Scoring wall 
        if ((e.getOtherBody() == wall && e.getReportingBody() == zombie) &&  player.getZombiesRemaining() > 1) {
            player.decrementZombiesRemaining();
            zombie.destroy(); 
            System.out.println("ZOMBIE DODGED");
            System.out.println("" + player.getZombiesRemaining());
        }
        else if ((e.getOtherBody() == wall && e.getReportingBody() == zombie) &&  player.getZombiesRemaining() == 1) {
            player.decrementZombiesRemaining();
            zombie.destroy(); 
            System.out.println("ZOMBIE DODGED");
            System.out.println("" + player.getZombiesRemaining());
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
        else if ((e.getOtherBody() == wall) && (e.getReportingBody() == ghost)) {
            ghost.destroy(); 
            System.out.println("GHOST DODGED");
        }
        
        // Zombie collision with orbs 
        if (e.getOtherBody() == orb2 && e.getReportingBody() == zombie) {
            orb2.destroy();
            System.out.println("SPEED ORB DESTROYED");
        }
        else if (e.getOtherBody() == orb && e.getReportingBody() == zombie) {
            orb.destroy();
            System.out.println("INVINCIBILITY ORB DESTROYED");
        }
        
        // Bat collision with orbs 
        if (e.getOtherBody() == orb2 && e.getReportingBody() == bat) {
            orb2.destroy();
            System.out.println("SPEED ORB DESTROYED");
        }
        else if (e.getOtherBody() == orb && e.getReportingBody() == bat) {
            orb.destroy();
            System.out.println("INVINCIBILITY ORB DESTROYED");
        }
        
        // Zombie collision with Bat
        if (e.getOtherBody() == bat && e.getReportingBody() == zombie) {
            bat.setLinearVelocity(new Vec2(0,5));
        }
        
        // Zombie collision with Ghost
        if (e.getOtherBody() == ghost && e.getReportingBody() == zombie) {
            ghost.setLinearVelocity(new Vec2(0,15));
        }
    }
    
    /**
     * Sets the attributes of the player back to normal after the super speed or invincibility timer has resolved; also resuming the background music for the current level.
     * @param ae the action event occurring when the timer ends
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(timer != null) {
            player.setInvincibility(false);
            game.getAudioManager().getInvincibleSound().close();
            timer.stop();
        }
        if(timer2 != null) {
            player.setSpeed(6);
            game.getAudioManager().getSuperSpeedSound().close();
            timer2.stop();
        }
        game.getLevelMusic().resume();
    }
}
