package zuoye0503_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OutRunnable implements Runnable{
	private Socket socket;
	public OutRunnable(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		while(true){
			//返回服务器的返回信息
			BufferedReader bufferedReader;
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s = bufferedReader.readLine();
				System.out.println("\n客户端返回的信息=="+s);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
