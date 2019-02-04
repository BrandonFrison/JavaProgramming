import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Brandon
 *
 */
public class SnakeGameworks extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8654330300510178806L;
	private ImageIcon titleForGame;
	
	public SnakeGameworks()
	{
		
	}
	public void paint(Graphics g)
	{
		// Border for the Snake title
		g.setColor(Color.WHITE);
		g.drawRect(24,10,420,103);
		
		// Importing the title image
		titleForGame = new ImageIcon("SnakeGameTitle.jpg");
		titleForGame.paintIcon(this, g, 25, 11);
		
		// Border for the game itself
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(24, 125, 851, 577);
		
		//for the gameplay area
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
			
	}
	
	
	
}
