package com.zhao;

import java.io.*;
import java.net.*;
import java.util.*;

public class FuWuQiRunnable implements Runnable{
	Socket socket;
	Map<Socket,String> map = null;
	public FuWuQiRunnable(Socket socket,Map<Socket,String> map){
		this.socket = socket;
		this.map = map;
	}
	
	public void run() {
		BufferedReader bufferedReader;
		
		while(true){
			try {
				//接收客户端发来的信息
				String message = "";
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				message = bufferedReader.readLine();
				//向数据库插入数据
				SQL sql = new SQL();
				sql.insert(map.get(socket), message);
				//返回给所有客户端消息
				Set<Socket> setSocket = map.keySet();
				for(Socket sn:setSocket){
					PrintWriter printWriter = new PrintWriter(sn.getOutputStream());
					printWriter.write(map.get(socket)+"："+message+"\n");
					printWriter.flush();
				}
			} catch (Exception e) {
				Set<Socket> setSocket = map.keySet();
				for(Socket sn:setSocket){
					PrintWriter printWriter;
					try {
						printWriter = new PrintWriter(sn.getOutputStream());
						printWriter.write("系统提示："+map.get(socket)+"已下线！\n");
						printWriter.flush();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				System.out.println(map.get(socket)+"已退出服务器！");
				map.remove(socket);
				return;
			}
		}
	}
}
