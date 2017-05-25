package zuoye0503_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FuWuQi {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			System.out.println("----- 服务器启动 -----");
			serverSocket = new ServerSocket(20000);
			//获取客户端
			System.out.println("正在读取客户端...");
			socket = serverSocket.accept();
			//获取客户端ip
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println("获取成功"+ip);
			while(true){
				
				//BufferedReader   缓冲流    //返回客户端传来的信息
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s = bufferedReader.readLine();
				System.out.println("客户端传来的信息=="+s);
				
				//向客户端返回信息
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(s+"\n");
				printWriter.flush();
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭
			if(serverSocket!=null){
				if(serverSocket.isClosed()){
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
