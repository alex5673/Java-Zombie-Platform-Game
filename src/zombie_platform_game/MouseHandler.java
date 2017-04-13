package zombie_platform_game;

import city.cs.engine.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Handles the mouse interactions between the player and the game.
 * @author Alex Gooding
 */
public class MouseHandler extends MouseAdapter {

    private Player player;

    /**
     * Passes in the view and player so mouse operations can to the player when the mouse is in the user view.
     * @param view the user view
     * @param player the player
     */
    public MouseHandler(WorldView view, Player player) {
        this.player = player;
    }

    /**
     * The player jumps when the mouse is pressed.
     * @param e the event that happens when the mouse is pressed
     */
    public void mousePressed(MouseEvent e) {
        player.jump(player.getJump());
    }   
    
    /**
     * Changes the player associated with the MouseHandler.
     * @param player the player
     */
    public void setBody(Player player) {
        this.player = player;
    }
}

