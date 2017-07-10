package test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class testIo {
	public static void main(String[] args) {
		String uri = "D:"+File.separator+"ab.txt";
		File file = new File(uri);
		InputStream in = null;
		byte [] b = null;
		try {
			in = new FileInputStream(file);
			b = new byte[(int) file.length()];
			in.read(b);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("长度为="+file.length());
		System.err.println(new String(b));
	}
}
