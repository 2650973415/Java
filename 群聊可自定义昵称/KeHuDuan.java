package zuoye0504_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class KeHuDuan {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			System.out.println("请输入昵称：");
			String name = sc.nextLine();
			System.out.println("----- 客户端("+name+") -----");
			Socket socket = new Socket("192.168.199.119",20000);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write(name+"\n");
			printWriter.flush();
			
			//收
			new Thread(new InRunnable(socket)).start();
			//发
			new Thread(new OutRunnable(socket)).start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
