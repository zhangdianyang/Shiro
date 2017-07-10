package test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.concurrent.ThreadPoolExecutor;

public class Socket {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9874);
			java.net.Socket socket = server.accept();
			
			testdo testdo = new testdo(socket);
			Thread t = new Thread(testdo);
			t.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
