package zombie_platform_game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Handles key presses imputed by the player.
 * @author Polo Dealer
 */
public class KeyHandler extends KeyAdapter {
    private Player player;
    
    /**
     * Passes in the player so that operations can be performed when keys are pressed.
     * @param player the player
     */
    public KeyHandler(Player player) {
        this.player = player;
    }
    
    /**
     * Handles the operations that occur when keys are pressed.
     * @param e the event that happens when a key is pressed 
     */
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_RIGHT) {
            player.startWalking(player.getSpeed());
        }
        else if(code == KeyEvent.VK_LEFT) {
            player.startWalking(-player.getSpeed());
        }
        else if (code == KeyEvent.VK_SPACE) {
            player.jump(player.getJump());
        }
    }    

    /**
     * Handles the operations that occur when keys are released.
     * @param e the event that happens when a key is released
     */
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
             if(code == KeyEvent.VK_RIGHT) {
            player.stopWalking();
        }
        else if(code == KeyEvent.VK_LEFT) {
            player.stopWalking();
        }
    }
    
    /**
     * Changes the player associated with the KeyHandler.
     * @param player the player
     */
    public void setBody(Player player) {
        this.player = player;
    }
}
        



