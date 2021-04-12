import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket server = null;

		try {
			server = new ServerSocket(6005);
			socket = server.accept();

			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			Scanner console = new Scanner(System.in);

			Thread t1 = new Thread(() -> {
				while (true) {
					String str = in.nextLine();
					if ("/end".equals(str)) {
						out.println("/end");
						break;
					}
					System.out.println("Client " + str);
				}
			});
			t1.start();

			Thread t2 = new Thread(() -> {
				while (true) {
					System.out.println("Введите сообщение: ");
					String str = console.nextLine();
					System.out.println("Сообщение отправлено");
					out.println(str);
				}
			});

			t2.setDaemon(true);
			t2.start();

			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
