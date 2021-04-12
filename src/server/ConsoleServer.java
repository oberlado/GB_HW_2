package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ConsoleServer {
	private Vector<ClientHandler> users;

	public ConsoleServer() {
		users = new Vector<>();
		ServerSocket server = null;
		Socket socket = null;
		try {
			AuthService.connect();
			server = new ServerSocket(6001);
			System.out.println("Server started");

			while (true) {
				socket = server.accept();
				System.out.printf("Client [%s] try to connect\n", socket.getInetAddress());
				new ClientHandler(this, socket);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.printf("Client [%s] disconnected", socket.getInetAddress());
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			AuthService.disconnect();
		}
	}

	public void subscribe(ClientHandler client) {
		users.add(client);
		System.out.println(String.format("User [%s] connected", client.getNickname()));
		broadcastClientsList();
	}

	public void unsubscribe(ClientHandler client) {
		users.remove(client);
		System.out.println(String.format("User [%s] disconnected", client.getNickname()));
		broadcastClientsList();
	}

	public void broadcastMessage(ClientHandler from, String str) {
		for (ClientHandler c : users) {
			if (!c.checkBlackList(from.getNickname())) {
				c.sendMsg(str);
			}
		}
	}

	public boolean isNickBusy(String nick) {
		for (ClientHandler c : users) {
			if (c.getNickname().equals(nick)) {
				return true;
			}
		}
		return false;
	}

	public void sendPrivateMsg(ClientHandler nickFrom, String nickTo, String msg) {
		for (ClientHandler c : users) {
			if (c.getNickname().equals(nickTo)) {
				if (!nickFrom.getNickname().equals(nickTo)) {
					c.sendMsg(nickFrom.getNickname() + ": [Send for " + nickTo + "] " + msg);
					nickFrom.sendMsg(nickFrom.getNickname() + ": [Send for " + nickTo + "] " + msg);
				}
			}
		}
	}

	private void broadcastClientsList() {
		StringBuilder sb = new StringBuilder();
		sb.append("/clientList ");
		for (ClientHandler c : users) {
			sb.append(c.getNickname() + " ");
		}

		String out = sb.toString();
		for (ClientHandler c : users) {
			c.sendMsg(out);
		}
	}

}
