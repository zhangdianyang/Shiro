package test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testdo implements Runnable {

	public java.net.Socket socket;
	
	public testdo(java.net.Socket socket) {
		super();
		this.socket = socket;
	}


	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = null;
			while((msg = in.readLine())!=null){
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
