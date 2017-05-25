package com.zhao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameWindow extends JFrame{
	JButton jButton1 = null;//开始按钮
	JButton jButton2 = null;//重新开始按钮
	JButton jButton3 = null;//悔棋按钮
	static TiShi tiShi = null;//提示信息条
	static QiPan qiPan = null;//棋盘
	boolean color = true;//棋子颜色
	public GameWindow(){
		this.setLayout(null);
		/**
		 * 开始
		 */
		jButton1 = new JButton("开始游戏");
		jButton1.setBounds(10, 10, 90, 30);
		this.add(jButton1);
		/**
		 * 开始
		 */
		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = qiPan.startAndEnd(tiShi);
				String label = "";
				if(b){
					label = "开始游戏";
					color = true;
				}else{
					label = "认输";
				}
				jButton1.setText(label);
			}
		};
		jButton1.addActionListener(al1);
		/**
		 * 重新开始
		 */
		jButton2 = new JButton("重新开始");
		jButton2.setBounds(110, 10, 90, 30);
		this.add(jButton2);
		/**
		 * 重新开始
		 */
		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(qiPan.resume(tiShi)){
					color = true;
				};
				jButton1.setText("认输");
			}
		};
		jButton2.addActionListener(al2);
		
		/**
		 * 悔棋
		 */
		jButton3 = new JButton("悔棋");
		jButton3.setBounds(210, 10, 90, 30);
		this.add(jButton3);
		/**
		 * 悔棋
		 */
		ActionListener al3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(qiPan.takeBack()){
					color = true;
				}else{
					color = !color;
				}
			}
		};
		jButton3.addActionListener(al3);
		
		/**
		 * 操作提示信息
		 */
		tiShi = new TiShi();
		tiShi.setBounds(310, 0, 540, 50);
		this.add(tiShi);
		
		/**
		 * 绘制内容
		 */
		qiPan = new QiPan();
		qiPan.setBounds(10, 50, 840, 840);
		/**
		 * 鼠标点击后执行
		 */
		qiPan.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				boolean b1 = qiPan.chuangJian(e, color);
				if(b1){
					return;
				}
				color = !color;
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		this.add(qiPan);
		this.setBounds(0, 0, 880, 950);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {

	}

}
