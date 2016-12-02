package net.fooddelivery.restaurant.win;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class UpdateFoodWin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void show(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFoodWin window = new UpdateFoodWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateFoodWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
