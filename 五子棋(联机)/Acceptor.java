package com.zhao;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Acceptor implements Runnable{
	public void run() {
		while(true){
			Pieces ppi = null;
			try {
				ObjectInputStream inputStream = new ObjectInputStream(Main.socket.getInputStream());
				ppi = (Pieces)inputStream.readObject();
				GameWindow.b = !GameWindow.b;
				System.out.println("客户端接收到");
				new QiPan().jie(ppi);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
