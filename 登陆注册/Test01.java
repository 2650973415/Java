package zuoye0509_4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Test01 {
	JFrame jf = null;//窗口
	JLabel jl1 = null;//标签1
	JLabel jl2 = null;//标签2
	JTextField jtf = null;//用户名输入框
	JPasswordField jpf = null;//密码输入框
	JButton jb1 = null;//登陆按钮
	JButton jb2 = null;//注册按钮
	File f = null;
	public Test01(){
		//配置文件
		f = new File("a.properties");
		//如果不存在就创建
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		jf = new JFrame("登陆");
		jf.setLayout(null);
		
		jl1 = new JLabel("账号：");
		jtf = new JTextField();
		jl2 = new JLabel("密码:");
		jpf = new JPasswordField();
		jb1 = new JButton("登陆");
		jb2 = new JButton("注册");
		jl1.setBounds(50, 50, 60, 20);
		jtf.setBounds(110, 50, 150, 20);
		jl2.setBounds(50, 90, 150, 20);
		jpf.setBounds(110, 90, 150, 20);
		jb1.setBounds(55, 130, 70, 25);
		jb2.setBounds(185, 130, 70, 25);
		jf.add(jl1);
		jf.add(jtf);
		jf.add(jl2);
		jf.add(jpf);
		jf.add(jb1);
		jf.add(jb2);
		//登陆
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//登陆方法
				String password = new String(jpf.getPassword());
				enter(jtf.getText(),password);
			}
		};
		jb1.addActionListener(al);
		
		//注册
		ActionListener al2 = new ActionListener() {
			JFrame jf = null;//窗口
			JLabel jl1 = null;//标签1
			JLabel jl2 = null;//标签2
			JTextField jtf = null;//用户名输入框
			JPasswordField jpf = null;//密码输入框
			JButton jb1 = null;//登陆按钮
			JButton jb2 = null;//注册按钮
			File f = null;
			public void actionPerformed(ActionEvent e) {
				jf = new JFrame("注册");
				jf.setLayout(null);
				jl1 = new JLabel("请输入账号：");
				jtf = new JTextField();
				jl2 = new JLabel("请输入密码:");
				jpf = new JPasswordField();
				jb1 = new JButton("确认注册");
				jb2 = new JButton("取消注册");
				jl1.setBounds(50, 50, 80, 20);
				jtf.setBounds(130, 50, 150, 20);
				jl2.setBounds(50, 90, 80, 20);
				jpf.setBounds(130, 90, 150, 20);
				jb1.setBounds(55, 130, 90, 25);
				jb2.setBounds(185, 130, 90, 25);
				jf.add(jl1);
				jf.add(jtf);
				jf.add(jl2);
				jf.add(jpf);
				jf.add(jb1);
				jf.add(jb2);
				jf.setBounds(0, 0, 350, 280);
				jf.setVisible(true);
				
				//确认
				ActionListener al = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String key = jtf.getText();
						String value = new String(jpf.getPassword());
						if(key.equals("")||key.equals(null)){
							JOptionPane.showMessageDialog(null, "用户名不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
						}else if(value.equals("")||value.equals(null)){
							JOptionPane.showMessageDialog(null, "密码不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
						}else{
							//注册方法
							login(key,value);
							//关闭当前窗口
							jf.dispose();
						}
					}
				};
				jb1.addActionListener(al);
				
				//取消
				ActionListener al2 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//关闭当前窗口
						jf.dispose();
					}
				};
				jb2.addActionListener(al2);
			}
		};
		jb2.addActionListener(al2);
		jf.setBounds(0, 0, 350, 280);
		jf.setVisible(true);
		//关闭窗口结束程序运行
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Test01();
	}
	
	
	//登录
	public void enter(String key,String value){
		//
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);//这个方法可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//创建一个迭代器，迭代判断用户名(也就是prop的key)是否存在
		Iterator<String> it=prop.stringPropertyNames().iterator();
		//boolean b 如果存在b=true，如果不存在b=false
		boolean b = false;
		while(it.hasNext()){
			if(it.next().equals(key)){
				b = true;
				break;
			}
		}
		if(b){//如果存在该用户，那么判断该用户的密码是否输入争取
			if(prop.getProperty(key).equals(value)){
				JOptionPane.showMessageDialog(null, "登陆成功！", "提示", JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "密码错误，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
			}
		}else if(!b){//如果不存在该用户，提示没有此用户
			JOptionPane.showMessageDialog(null, "没有此用户，请注册！", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
	//注册
	public void login(String key,String value){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(f,"rw");
			raf.seek(raf.length());
			raf.write((key+"="+value+"\r").getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "注册成功！", "提示", JOptionPane.ERROR_MESSAGE);
			
		}
	}
}
