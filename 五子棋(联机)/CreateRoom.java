package com.zhao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateRoom extends JComponent{
	boolean color;
	public CreateRoom(){
		JFrame f1 = new JFrame("创建与加入对局");
		f1.setLayout(null);
		JLabel jLabel = new JLabel("请输入游戏房间号：");
		jLabel.setFont(new Font("微软雅黑", 0, 20));
		JTextField field = new JTextField();
		JButton f2button_2 = new JButton("进入");
		jLabel.setBounds(60, 20, 200, 30);
		field.setBounds(60, 65, 200, 30);
		f2button_2.setBounds(180,110,80,25);
		f1.add(jLabel);
		f1.add(field);
		f1.add(f2button_2);
		f1.setBounds(0,0,340,230);
		f1.setVisible(true);
		//进入
		f2button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//连接服务器
				try {
					Main.socket = new Socket("192.168.199.120", 20000);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				//判断空值
				if(field.getText().equals(null)||field.getText().equals("")){
					JOptionPane.showMessageDialog(null, "房间号不能为空！", "提示",0);
					return;
				}
				PrintWriter printWriter;
				try {
					//将房间号发送给服务器
					printWriter = new PrintWriter(Main.socket.getOutputStream());
					printWriter.write(field.getText()+"\n");
					printWriter.flush();
					//服务器返回信息
					int a = 2;
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Main.socket.getInputStream()));
					a = bufferedReader.read();
					//提示信息
					if(a==2){
						JOptionPane.showMessageDialog(null, "该房间不存在，已为您新建，开始游戏吧！", "提示",1);
						color = true;//黑棋
//						zhuangTai = false;
					}else if(a==1){
						JOptionPane.showMessageDialog(null, "成功进入房间，开始游戏吧！", "提示",1);
						color = false;//白棋
//						zhuangTai = true;
					}else if(a==0){
						JOptionPane.showMessageDialog(null, "该房间已满人，请重新输入房间号！", "提示",0);
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//进入游戏！
				new GameWindow(color);
				new Thread(new Acceptor()).start();
				//关闭进入房间窗口
				f1.dispose();
			}
		});
	}
}
