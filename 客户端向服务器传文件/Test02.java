package zuoye0502_5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Test02 {

	public static void main(String[] args) {
		try {
			System.out.println("服务器创建成功");
			ServerSocket ss = new ServerSocket(9292);//建立服务端的Socket服务
			while(true){
				File f = new File("t1.txt");
				if(!f.exists()){
					f.createNewFile();
				}
				System.out.println("正在监听端口");
				Socket s = ss.accept();//获取客户端对象
				long startTime=System.currentTimeMillis();   //获取开始时间
				InputStream inputStream = s.getInputStream();
				OutputStream os = new FileOutputStream(f);
				byte[] bytes = new byte[1024];
				int len = 0;
//				StringBuffer sb = new StringBuffer();
				while((len = inputStream.read(bytes))!=-1){
					os.write(bytes,0,len);
//					sb.append(new String(bytes,0,len));
				}
//				System.out.println("服务器:你是干什么的");
//				System.out.println("客户端："+sb.toString());
				inputStream.close();
				os.close();

				
				long endTime=System.currentTimeMillis(); //获取结束时间

				System.out.println("文件下载时间： "+(endTime-startTime)+"ms");
				String ip = s.getInetAddress().getHostAddress();
				System.out.println("有人来访问地址是"+ip);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
