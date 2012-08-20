package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ClassPanel extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassPanel frame = new ClassPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClassPanel() {
		setBounds(100, 100, 450, 300);

	}

}
