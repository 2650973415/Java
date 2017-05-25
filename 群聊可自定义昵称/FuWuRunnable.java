package zuoye0504_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class FuWuRunnable implements Runnable{
	private Socket socket;
	Map<Socket,String> map;
	public FuWuRunnable(Socket socket,Map<Socket,String> map){
		this.socket = socket;
		this.map = map;
	}
	@Override
	public void run() {
		while(true){
			BufferedReader bufferedReader = null;
			try {
				//接收客户端信息
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s = bufferedReader.readLine();
				System.out.println(map.get(socket)+":"+s);
				
				//返回给所有链接的客户端信息
				Set<Socket> setMap = map.keySet();
				for(Socket socket1:setMap){
					PrintWriter printWriter = new PrintWriter(socket1.getOutputStream());
					printWriter.write(map.get(socket)+":"+s+"\n");
					printWriter.flush();
				}
				
				
			} catch (IOException e) {
				//向所有在线客户端发送下线信息
				Set<Socket> setMap = map.keySet();
				for(Socket socket1:setMap){
					PrintWriter printWriter = null;
					try {
						printWriter = new PrintWriter(socket1.getOutputStream());
						printWriter.write("系统提示："+map.get(socket)+"退出群聊！\n");
						printWriter.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println(map.get(socket)+"与服务器断开！");
				map.remove(socket);
				break;
			}
		}
			
	}

}
