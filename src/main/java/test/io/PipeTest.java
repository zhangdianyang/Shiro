package test.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeTest {
	public static void main(String[] args) throws IOException {
		final PipedOutputStream out = new PipedOutputStream();
		final PipedInputStream in = new PipedInputStream(out);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					out.write("abc".getBytes());
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int data = in.read();
					while(data != -1){
						System.out.println((char)data);
						data=in.read();
					}
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
