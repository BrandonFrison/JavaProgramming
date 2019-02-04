package ball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Bouncing ball example
 * 
 * @author m.aibin
 *
 */
public class BouncingBallSimple extends JPanel {

	private static final long serialVersionUID = 5617994995530990532L;
	private static final int BOX_WIDTH = 1600;
	private static final int BOX_HEIGHT = 900;

	/** Image properties **/
	private float radius = 25;
	private float x = radius / 2;
	private float y = radius / 2;
	private double speedX = 2;
	private double speedY = 10;
	private static final double GRAVITY = 0.5;
	private static final double BOUNCE_REDUCE = 0.7;
	private double previousAngle = 15.0;
	private BufferedImage image;

	private static final int UPDATE_RATE = 30; // Number of refresh per second

	/** Constructor to create the UI components and init game objects. */
	public BouncingBallSimple() {
		this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));

		// Start the ball bouncing (in its own thread)
		Thread gameThread = new Thread() {
			public void run() {
				while (true) {
					// Calculate the ball's new position
					x += speedX;
					y += speedY;
					speedY += GRAVITY;
					// Check if the ball moves over the bounds
					if (x - radius < 0) {
						speedX = -speedX; // Reflect along normal
						x = radius; // Re-position the ball at the edge
					} else if (x + radius > BOX_WIDTH) {
						speedX = -speedX;
						x = BOX_WIDTH - radius;
					}
					// May cross both x and y bounds
					if (y - radius < 0) {
						speedY = -speedY * BOUNCE_REDUCE;
						y = radius;
					} else if (y + radius > BOX_HEIGHT) {
						speedY = -speedY * BOUNCE_REDUCE;
						y = BOX_HEIGHT - radius;
					}
					// Refresh the display
					repaint();
					// Delay for timing control and give other threads a chance
					try {
						Thread.sleep(1000 / UPDATE_RATE); // milliseconds
					} catch (InterruptedException ex) {
					}
				}
			}
		};
		gameThread.start(); // Callback run()
	}

	/** Custom rendering codes for drawing the JPanel */
	@SuppressWarnings("resource")
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Paint background

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

		try {
			image = ImageIO.read(new File("img1.png"));
		} catch (IOException e) {
		}
		previousAngle -= 0.05;
		image = rotate(image, previousAngle);
		g.drawImage(image, (int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius), null);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier New", Font.BOLD, 16));
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb);
		String text = "Ball @(%3.0f,%3.0f) Speed=(%1.0f,%1.0f) Angle=(%1.0f degrees)";
		formatter.format(text, x, y, speedX, speedY, previousAngle);
		g.drawString(sb.toString(), (BOX_WIDTH - g.getFontMetrics().stringWidth(text)) / 2, 25);
	}

	/** main program (entry point) */
	public static void main(String[] args) {
		// Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Set up main window (using Swing's Jframe)
				JFrame frame = new JFrame("A Bouncing Ball");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new BouncingBallSimple());
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Rotate image logic
	 * 
	 * @param image
	 * @param angle
	 * @return
	 */
	public static BufferedImage rotate(BufferedImage image, double angle) {
		angle = -angle;
		double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
		int w = image.getWidth(), h = image.getHeight();
		int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
		GraphicsConfiguration gc = getDefaultConfiguration();
		BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();
		g.translate((neww - w) / 2, (newh - h) / 2);
		g.rotate(angle, w / 2, h / 2);
		g.drawRenderedImage(image, null);
		g.dispose();
		return result;
	}

	/**
	 * Configuration for rotation
	 * 
	 * @return
	 */
	private static GraphicsConfiguration getDefaultConfiguration() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		return gd.getDefaultConfiguration();
	}
}