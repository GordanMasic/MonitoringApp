package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = 7446192599263749847L;

	// Declaring variables
	private static final int WIDTH = 350;
	private static final int HEIGHT = 300;
	private static ClientListPanel clientListPanel;
	private static ChooseClientPanel chooseClientPanel;
	private static ButtonPanel buttonsPanel;
	private JPanel panel;

	public Window() {

		// Setting layout of frame
		setLayout(new BorderLayout());

		// Initializing ordinary panel
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setSize(600, 600);

		// Initializing panel for choosing client
		chooseClientPanel = new ChooseClientPanel();
		panel.add(chooseClientPanel, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);

		// Initializing panel that shows connected clients
		clientListPanel = new ClientListPanel();
		add(clientListPanel, BorderLayout.WEST);

		// Initializing panel with buttons
		buttonsPanel = new ButtonPanel();
		panel.add(buttonsPanel, BorderLayout.NORTH);

		setTitle("Monitoring Application");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * Adding client to client panel
	 */
	public void addClients() {
		clientListPanel.addClients();
		clientListPanel.repaint();
	}

}
