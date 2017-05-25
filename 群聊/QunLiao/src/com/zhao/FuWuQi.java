package com.zhao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FuWuQi {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		Map<Socket,String> map = new HashMap<Socket,String>();
		try {
			serverSocket = new ServerSocket(20000);
			while(true){
				//监听端口
				socket = serverSocket.accept();
				String name = "";
				int a = 1;
				//接收昵称
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				name = bufferedReader.readLine();
				//判断用户是否存在
				Set<Socket> setSocket = map.keySet();
				for(Socket sn:setSocket){
					if(name.equals(map.get(sn))){
						a = 0;
						break;
					}
				}
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(a);
				printWriter.flush();
				//如果不存在就保存此用户信息
				if(a!=0){
					map.put(socket, name);
				}else if(a==0){
					continue;
				}
				for(Socket sn:setSocket){
					PrintWriter printWriter2 = new PrintWriter(sn.getOutputStream());
					printWriter2.write("系统提示："+map.get(socket)+"已上线！\n");
					printWriter2.flush();
				}
				System.out.println(map.get(socket)+"已连接到服务器！");
				
				
				//接收客户端消息与返回给客户端消息
				new Thread(new FuWuQiRunnable(socket,map)).start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
