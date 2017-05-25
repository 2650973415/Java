package zuoye0502_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test01 {

	public static void main(String[] args) {
		File f = new File("¶·ÆÆ²Ôñ·.txt");
		try {
			Socket s = new Socket("192.168.199.119",9292);
			InputStream is = new FileInputStream(f);
			byte[] bytes = new byte[(int) f.length()];
			is.read(bytes);
			OutputStream os = s.getOutputStream();
			os.write(bytes);
			os.close();
			is.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
