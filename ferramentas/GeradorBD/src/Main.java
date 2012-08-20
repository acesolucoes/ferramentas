

import gui.GeradorFrame;

import java.awt.EventQueue;

public class Main {

	/**
	 * @param args
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeradorFrame frame = new GeradorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
