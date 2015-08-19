package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import server.Server;

public class ChooseClientPanel extends JPanel {

	private static final long serialVersionUID = -5504607050243272566L;

	// Declaring variables
	private JTextField field;
	private ArrayList<Socket> clientList;
	private static Socket client;
	private String ipAdress;
	private int index = -1;

	public ChooseClientPanel() {
		setSize(100, 100);

		// Getting list of clients connected to server
		clientList = Server.getListOfClients();

		// Initializing text field
		field = new JTextField();
		field.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setPreferredSize(new Dimension(150, 30));
		setBorder(BorderFactory.createTitledBorder("Choose client"));
		add(field);

		// Adding KeyListener to text field
		field.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ipAdress = field.getText();
					index = Server.searchIpAdress(ipAdress);
					client = clientList.get(index);
					ButtonPanel.chooseClient(client);
				}
			}
		});
	}

	//Getter for client
	public static Socket getChosenClient() {
		return client;
	}
}
