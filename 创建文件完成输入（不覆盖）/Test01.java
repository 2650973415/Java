import java.io.*;
import java.util.Scanner;

public class Test01 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		File f = new File("Test01.txt");
		if(!f.exists())
		try{
			f.createNewFile();
		}catch(Exception e){
			e.printStackTrace();
		}
		FileInputStream fis = new FileInputStream(f);
			StringBuffer s = new StringBuffer();
			byte[] bytes = new byte[1024];
			int a = 0;
			while((a=fis.read(bytes))!=-1){
				s.append( new String(bytes,0,a));
			}
			System.out.println(s.toString());
		/*
		FileWriter fw = null;
		FileReader fr = null;
		//输出流
		System.out.println("请输入需要插入的数据：");
		while(true){
			try{
				String s = "";
				fr = new FileReader(f);
				char[] c = new char[4];
				int a = 0;
				while((a=fr.read(c))!=-1){
					s+=new String(c,0,a);
				}
				String str = sc.next();
				fw = new FileWriter(f);
				fw.write(s+str);
				fw.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		*/
	}
}
