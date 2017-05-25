import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		//获取文件
		File f = new File("a.properties");
		//如果不存在就创建
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//菜单
		menu(f);
	}
	//菜单
	public static void menu(File f){
		System.out.println("-------请选择-------");
		System.out.println("   1.登录");
		System.out.println("   2.注册");
		int num = sc.nextInt();
		if(num==1){//登录
			System.out.println("-------登录-------");
			enter(f);
		}else if(num==2){//注册
			System.out.println("-------注册-------");
			login(f);
		}
	}
	//登录
	public static void enter(File f){
		//
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);//这个方法可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//输入用户名&密码
		System.out.print("用户名：");
		String username = sc.next();
		System.out.print("密　码：");
		String password = sc.next();
		//创建一个迭代器，迭代判断用户名(也就是prop的key)是否存在
		Iterator<String> it=prop.stringPropertyNames().iterator();
		//boolean b 如果存在b=true，如果不存在b=false
		boolean b = false;
		while(it.hasNext()){
			if(it.next().equals(username)){
				b = true;
				break;
			}
		}
		if(b){//如果存在该用户，那么判断该用户的密码是否输入争取
			if(prop.getProperty(username).equals(password)){
				System.out.println("登录成功！");
				menu(f);
			}else{
				System.out.println("密码错误！");
				menu(f);
			}
		}else if(!b){//如果不存在该用户，提示没有此用户
			System.out.println("没有此用户！");
			menu(f);
		}
	}
	//注册
	public static void login(File f){
		FileInputStream fis = null;
		FileWriter fw = null;
		try{
			if(!f.exists()){
				f.createNewFile();
			}
			fis = new FileInputStream(f);
			String s = "";
			byte[] bytes = new byte[1024];
			int a = 0;
			while((a=fis.read(bytes))!=-1){
				s += new String(bytes,0,a)+"\r";
			}

			//注册
			String username = null;
			String password = null;
			System.out.print("username=");//用户名
			username = sc.next();
			System.out.print("password=");//密码
			password = sc.next();
			
			fw = new FileWriter(f);
			fw.write(s+username+"="+password);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭流
			try {
				if(fis!=null){
					fis.close();
				}
				if(fw!=null){
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("注册成功！");
			menu(f);
		}
	}

}
