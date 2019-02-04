import java.awt.Color;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Brandon Frison 300243731
 *
 */
public class MainGameClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Jframe window initiation code
		JFrame frame = new JFrame();
		SnakeGameworks game = new SnakeGameworks(); 
		frame.setBounds(50, 50, 905, 700);
		frame.setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		
	}

}
