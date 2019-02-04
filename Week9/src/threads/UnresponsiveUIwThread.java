package threads;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Illustrate the Unresponsive UI problem caused by "starved" event-dispatching
 * thread
 * 
 * @author nt.edu.sg
 * @author EDITED by m.aibin
 */
public class UnresponsiveUIwThread extends JFrame implements ActionListener {
	private static final long serialVersionUID = 29587468741401655L;
	private boolean stop = false;
	private JTextField tfCount;
	private int count = 1;
	private JButton btnStart, btnStop;

	/** Constructor to setup the GUI components */
	public UnresponsiveUIwThread() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		cp.add(new JLabel("Counter"));
		tfCount = new JTextField(count + "", 10);
		tfCount.setEditable(false);
		cp.add(tfCount);

		btnStart = new JButton("Start Counting");
		cp.add(btnStart);
		btnStart.addActionListener(this);

		btnStop = new JButton("Stop Counting");
		cp.add(btnStop);
		btnStop.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Counter");
		setSize(300, 120);
		setVisible(true);
	}

	/** The entry main method */
	public static void main(String[] args) {
		// Run GUI codes in Event-Dispatching thread for thread safety
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new UnresponsiveUIwThread(); // Let the constructor do the job
			}
		});
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		Thread t = new Thread() {
			@Override
			public void run() { // override the run() to specify the running
								// behavior
				if (e.getSource().equals(btnStart)) {
					stop = false;
					for (int i = 0; i < 100000; ++i) {
						if (stop)
							break; // check if STOP button has been pushed,
									// which changes the stop flag to true
						tfCount.setText(count + "");
						++count;
					}
				} else {
					stop = true;
				}
			}
		};
		t.start(); // call back run()
	}
}