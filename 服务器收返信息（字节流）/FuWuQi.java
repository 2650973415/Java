package zuoye0502_6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FuWuQi {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			//启动服务器
			System.out.println("----- 服务器启动 -----");
			serverSocket = new ServerSocket(20000);
			while(true){
				System.out.println("正在获取客户端...");
				socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("成功获取客户端"+ip);
				
				//读取客户端发来的信息
				InputStream is = socket.getInputStream();
				byte[] bytes = new byte[1024];
				int len=0;
				StringBuffer sb = new StringBuffer();
				while((len=is.read(bytes))!=-1){
					sb.append(new String(bytes,0,len));
				}
				System.out.println("成功接收到客户端发来的信息=="+sb);
				
				//返回给客户端的信息
				OutputStream os = socket.getOutputStream();
				os.write((sb.toString()).getBytes());
				os.flush();
				socket.shutdownOutput();
				
				//判断服务器是否停止
//				System.out.println(socket.isClosed());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			/**
			 * 关闭
			 */
//			if(serverSocket.isClosed()){
//				try {
//					serverSocket.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}	
//			}
			
		}
	}

}
