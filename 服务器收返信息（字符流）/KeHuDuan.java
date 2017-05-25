package zuoye0503_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class KeHuDuan {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.199.119",20000);
			while(true){
				//向服务器发送信息
				String s2 = sc.next();
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(s2+"\n");
				printWriter.flush();
				
				//返回服务器的返回信息
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s = bufferedReader.readLine();
				
				System.out.println("客户端返回的信息=="+s);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(socket!=null){
				if(socket.isClosed()){
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

}
