package zuoye0504_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class OutRunnable implements Runnable{
	public static Scanner sc = new Scanner(System.in);
	private Socket socket;
	public OutRunnable(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		while(true){
			//向服务器发送
			PrintWriter printWriter = null;
			try {
				String s = sc.next();
				printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(s+"\n");
				printWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}

}
