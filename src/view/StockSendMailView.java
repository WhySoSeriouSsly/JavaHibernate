package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class StockSendMailView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockSendMailView frame = new StockSendMailView();
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
	public StockSendMailView() {
		setBounds(100, 100, 450, 300);

	}

}
