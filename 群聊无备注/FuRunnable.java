package zuoye0503_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class FuRunnable implements Runnable{
	private Socket socket;
	private List<Socket> l;
	public FuRunnable(Socket socket,List<Socket> l){
		this.socket = socket;
		this.l = l;
	}
	@Override
	public void run() {
		synchronized (socket) {
			while(true){
				//BufferedReader   缓冲流    //返回客户端传来的信息
				BufferedReader bufferedReader;
				try {
					bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String s = bufferedReader.readLine();
					System.out.println("客户端传来的信息=="+s);
					
					//向客户端返回信息
					for(Socket socket1:l){
						PrintWriter printWriter = new PrintWriter(socket1.getOutputStream());
						printWriter.write(socket1.getInetAddress().getHostAddress()+s+"\n");
						printWriter.flush();	
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		
	}

}
