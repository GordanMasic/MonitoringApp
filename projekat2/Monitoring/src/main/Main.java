package main;

import server.Server;

public class Main {

	public static void main(String[] args) {
		Server.startServer();

		while (true) {
			Server.connectClient();
			Server.getWindow().addClients();
		}
	}
}
