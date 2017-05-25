package zuoye0424;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * java 流
 * 
 *
 */

public class Test02 {
	public static Scanner sc = new Scanner(System.in);
										//直接抛出了异常
	public static void main(String[] args) throws Exception{
		//内存操作流-字节
		String s = "ABCDE";
		byte[] bytes = s.getBytes();
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int a = 0;
		//读取输入流中的数据到输出流
		while((a=bais.read())!=-1){
			baos.write(Character.toUpperCase((char) a));
		}
		String str = baos.toString();
		bais.close();
		baos.close();
		System.out.println(str);
		
		
		//打印流
		PrintStream out = new PrintStream(new FileOutputStream(new File("test.txt")));
		out.print(3 + " + " + 2 + " = ");  
		out.println(2 + 3);  
		out.println("Hello itcast!");  
		//将以上输出打印到test.txt文本
		out.close();
		
		//格式化输出printf();
		String s1   = "赵";  
		int age = 17;  
		float pi = 3.14F;  
		char c = 'U';  
		//%s输出字符串，%d输出整数，%f输出小数，%c输出字符
		System.out.printf("名字： %s, 年龄： %d, PI= %f, 字符： %c",s1,age,pi,c); 
		System.out.printf("名字： %s, 年龄： %s, PI= %s, 字符： %s", s1,age,pi,c);
		
		//缓冲流
		BufferedReader br = new BufferedReader(new FileReader("test2.txt"));  
		BufferedWriter bw = new BufferedWriter(new FileWriter("AA.txt")  );
		 
		String line = null;  
		while((line = br.readLine()) != null){//读一行  
			bw.write(line);//写一行
			bw.flush();
			bw.newLine();//写完一行就换行  
		}  
		bw.close();  
		br.close();
	}

}
