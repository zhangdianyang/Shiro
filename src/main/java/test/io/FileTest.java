package test.io;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		try {
//			FileReader ir = new FileReader(new File("d://ab.txt"));
//			FileWriter iw = new FileWriter(new File("d://bc.txt"));
			FileInputStream ir = new FileInputStream(new File("d://ab.txt"));
			FileOutputStream iw = new FileOutputStream(new File("d://bc.txt"));
			BufferedInputStream bf = new BufferedInputStream(ir); 
			BufferedOutputStream bfo = new BufferedOutputStream(iw);  
			byte[] c = new byte[1024];
			int a = 0;
			while((a = bf.read(c))!= -1){
				System.out.println(c);
				bfo.write(c);
			}
			bf.close();
			bfo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
