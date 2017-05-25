package zuoye0504_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class FuWuQi {

	public static void main(String[] args) {
		System.out.println("------ 服务器启动 (群聊) ------");
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(20000);
			socket = null;
			Map<Socket,String> map = new HashMap<Socket,String>();
			int num = 0;
			while(true){
				//监听端口
				socket = serverSocket.accept();
				//获取客户端名字
				String name = "";
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				name = bufferedReader.readLine();
				//如果客户端名字为空，系统默认给定一个
				if(name==null||name.equals("")){
					num++;
					name = "客户端"+num;
				}
				//保存客户端
				map.put(socket,name);
				System.out.println(map.get(socket)+"已连接到服务器！");
				Set<Socket> setMap = map.keySet();
				for(Socket socket1:setMap){
					PrintWriter printWriter = null;
					try {
						printWriter = new PrintWriter(socket1.getOutputStream());
						printWriter.write("系统提示："+map.get(socket)+"加入群聊！\n");
						printWriter.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//给客户端返回是否连接成功
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write("连接成功，开始聊天吧！"+"\n");
				printWriter.flush();
				//收，回客户端信息
				new Thread(new FuWuRunnable(socket,map)).start();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭服务器
			if(serverSocket!=null){
				if(!serverSocket.isClosed()){
					try {
						serverSocket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
