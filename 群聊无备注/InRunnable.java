package zuoye0503_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class InRunnable implements Runnable{
	public static Scanner sc = new Scanner(System.in);
	private Socket socket;
	public InRunnable(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		while(true){
			//向服务器发送信息
			System.out.print("请输入：");
			String s2 = sc.next();
			PrintWriter printWriter;
			try {
				printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(s2+"\n");
				printWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
