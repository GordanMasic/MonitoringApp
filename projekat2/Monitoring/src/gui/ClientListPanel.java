package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import server.Server;

public class ClientListPanel extends JPanel {

	private static final long serialVersionUID = -1151382542037019676L;

	// Declaring variables
	private static JTextArea area;
	private static ArrayList<String> ipAddressList;
	private static int counter;
	private JScrollPane pane;

	public ClientListPanel() {
		// Settings for panel
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Client list"));
		setSize(200, 600);

		// Initializing text area
		area = new JTextArea();
		area.setText("                         		");
		area.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
		area.setEditable(false);
		pane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		DefaultCaret caret = (DefaultCaret) area.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		pane.setPreferredSize(new Dimension(150, 300));
		add(pane);

	}

	/**
	 * Adding connected clients to the text area
	 */
	public synchronized void addClients() {

		ipAddressList = Server.getListOfIpAddresses();

		area.setText("");

		counter = 0;
		for (int i = 0; i < ipAddressList.size(); i++) {
			area.append("Client" + (++counter) + " : " + ipAddressList.get(i)
					+ "\t\n");
		}
		area.repaint();

	}
}
