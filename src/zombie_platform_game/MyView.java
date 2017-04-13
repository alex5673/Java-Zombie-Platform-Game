package zombie_platform_game;

import city.cs.engine.*;

import city.cs.engine.UserView;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Creates a specified user view.
 * @author Alex Gooding
 */
public class MyView extends UserView { 
    
    private final Image background;
    private final Game game;
    
    /**
     * Forms a view using the width and height measurements and the world passed in, into the game which is passed in. 
     * @param world the world
     * @param game the game
     * @param width the width of the view
     * @param height the height of the view
     */
    public MyView(World world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
        background = new ImageIcon("data/Halloween_background.jpg").getImage();
    }
     
    /**
     * Adds the background image to the view.
     * @param g graphics
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
    
    /**
     * Displays the current level and how zombies are left to the user in front of the background image.
     * @param g graphics
     */
    @Override
    public void paintForeground(Graphics2D g) {
        g.setColor(Color.red);
        g.drawString("Level:" + game.getLevel(), 110, 20);
        g.drawString("Zombies remaining:" + game.getPlayer().getZombiesRemaining(), 770, 20);
    }
}
