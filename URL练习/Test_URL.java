
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.Scanner;

public class Test_URL {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
//		String url = "https://www.baidu.com/";
//		String url = "http://img.17gexing.com/uploadfile/2017/04/2/20170422090632451.jpg";
		System.out.println("");
		String s2 = sc.next();
		String url = "http://www.tuling123.com/openapi/api?key=cabcb3fa298c4f96bf512646903804ca&info="+s2;
		try {
			//创建URL对象
			URL url1 = new URL(url);
			//打开URL
			URLConnection connection = url1.openConnection();
			//发起请求连接
			connection.connect();
			
			/**
			 * 获取网页源文件
			 */
//			//获取返回内容
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			StringBuffer stringBuffer = new StringBuffer();
//			String s = "";
////			while(!((s=bufferedReader.readLine()).equals(null))){
////				stringBuffer.append(s);
////			}
//			System.out.println(bufferedReader.readLine());
//			System.out.println(bufferedReader.readLine());
//			System.out.println(bufferedReader.readLine());

			/**
			 * 下载图片
			 */
//			InputStream inputStream = connection.getInputStream();
//			byte[] bytes = new byte[1024];
//			int len = 0;
//			File f = new File("1.jpg");
//			FileOutputStream fos = new FileOutputStream(f);
//			while((len = inputStream.read(bytes))!=-1){
//				fos.write(bytes, 0, len);
//			}
			
			/**
			 * 机器人
			 */
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String s = "";
//			while(!((s=bufferedReader.readLine()).equals(null))){
//				stringBuffer.append(s);
//			}
			System.out.println(bufferedReader.readLine());
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
