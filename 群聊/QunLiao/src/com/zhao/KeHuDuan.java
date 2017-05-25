package com.zhao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class KeHuDuan {
	static Socket socket = null;
	
	JFrame frame = null;//创建聊天窗口
	JLabel jLabel_1 = null;//标签1
	JTextArea jTextArea_1 = null;//消息接收框
	JLabel jLabel_2 = null;//标签2
	JButton button_1 = null;//历史纪录
	JTextArea jTextArea_2 = null;//消息编辑框
	JButton button_2 = null;//关闭窗口
	JButton button_3 = null;//发送按钮
	JButton button_4 = null;//清屏
	SQL sql = new SQL();
	public KeHuDuan(){
		window1();
	}
	public static void main(String[] args) {
		new KeHuDuan();
	}
	/**
	 * 链接服务器窗口
	 */
	public void window1(){
		JFrame frame2 = new JFrame("链接到群聊");
		frame2.setLayout(null);
		JLabel jLabel = new JLabel("请输入昵称：");
		jLabel.setFont(new Font("微软雅黑", 0, 20));
		JTextField field = new JTextField();
		JButton f2button_1 = new JButton("取消");
		JButton f2button_2 = new JButton("连接");
		jLabel.setBounds(60, 20, 200, 30);
		field.setBounds(60, 65, 200, 30);
		f2button_1.setBounds(60,110,80,25);
		f2button_2.setBounds(180,110,80,25);
		frame2.add(jLabel);
		frame2.add(field);
		frame2.add(f2button_1);
		frame2.add(f2button_2);
		frame2.setBounds(0,0,340,230);
		frame2.setVisible(true);
		//取消(退出程序)
		f2button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//点击链接
		f2button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//连接服务器
					socket = new Socket("192.168.199.120", 20000);
					int a = 0;
					if(field.getText().equals(null)||field.getText().equals("")){
						JOptionPane.showMessageDialog(null, "呢称不能为空！", "提示",0);
						return;
					}
					//向服务器发送昵称
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(field.getText()+"\n");
					printWriter.flush();
					//接收服务器返回信息
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					a = bufferedReader.read();
					if(a!=0){
						JOptionPane.showMessageDialog(null, "链接成功！", "提示",1);
					}else{
						JOptionPane.showMessageDialog(null, "已存在此呢称！", "提示",0);
						return;
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				window2();
				frame2.dispose(); 
			}
		});
		
		
	}
	
	/**
	 * 聊天窗口
	 */
	public void window2(){
		frame = new JFrame("群聊");
		frame.setLayout(null);
		//标签1
		jLabel_1 = new JLabel("消息接收");
		jLabel_1.setBounds(10, 10, 200, 25);
		frame.add(jLabel_1);
		//消息接收窗口
		jTextArea_1 = new JTextArea();
		JScrollPane bar = new JScrollPane(jTextArea_1);
		bar.setBounds(10, 45, 430, 500);
		frame.add(bar);
		sql.select(jTextArea_1);
		//接受服务器消息
		new Thread(new Runnable() {
			public void run() {
				//接收服务器发来的消息
				while(true){
					try {
						String message = "";
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						message = bufferedReader.readLine();
						jTextArea_1.setText(jTextArea_1.getText()+"\n"+message);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}).start();
		
		//标签2
		jLabel_2 = new JLabel("编辑消息");
		jLabel_2.setBounds(10, 555, 200, 25);
		frame.add(jLabel_2);
		//清屏
		button_4 = new JButton("清屏");
		button_4.setBounds(250, 555, 90, 25);
		frame.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextArea_1.setText("");
			}
		});
		//消息记录
		button_1 = new JButton("消息记录");
		button_1.setBounds(350, 555, 90, 25);
		frame.add(button_1);
		//点击查看消息记录
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f3 = new JFrame("消息记录");
				JTextArea area  = new JTextArea();
				JScrollPane pane = new JScrollPane(area);
				f3.add(pane);
				f3.setBounds(0, 0, 500, 500);
				f3.setVisible(true);
				//查询
				sql.select(area);
			}
		});
		//编辑消息框
		jTextArea_2 = new JTextArea();
		jTextArea_2.setBounds(10,590,430,110);
		frame.add(jTextArea_2);
		//关闭聊天窗/整个客户端
		button_2 = new JButton("关闭");
		button_2.setBounds(250, 710, 90, 25);
		frame.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//发送消息按钮
		button_3 = new JButton("发送");
		button_3.setBounds(350, 710, 90, 25);
		frame.add(button_3);
		//点击发送按钮向服务器发送消息
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = jTextArea_2.getText();
				try {
					if(message.equals("")||message.equals(null)){
						return;
					}
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(jTextArea_2.getText()+"\n");
					printWriter.flush();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				jTextArea_2.setText("");
			}
		});
		
		
		frame.setBounds(0, 0, 470, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
