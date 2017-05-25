package zuoye0504_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class InRunnable implements Runnable{
	private Socket socket;
	public InRunnable(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			//接收服务器返回
			BufferedReader bufferedReader = null;
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s = bufferedReader.readLine();
				System.out.println(s);
			} catch (IOException e) {
				System.out.println("服务器已关闭！");
				break;
			}
		}
	}
}
