package test.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.ibatis.javassist.bytecode.ByteArray;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class byteTest {
	public static void main(String[] args) throws IOException {
		byte[] b = new byte[1024];
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		out.write("dd".getBytes());
		
		
		while((in.read(b))!= -1){
			String a = new String(b);
			System.out.println(b);
		}
		
		out.close();
		in.close();
	}
}
