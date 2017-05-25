package com.zhao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class TiShi extends JComponent{
	boolean color = true;//当前棋子颜色
	String s = "暂未设置按钮，可直接游戏！";
	public void paint(Graphics g) {
		g.setColor(new Color(255, 189, 136));
		g.fillRect(0, 0, 540, 50);
		if(color){
			g.setColor(new Color(0, 0, 0));
		}else{
			g.setColor(new Color(255, 255, 255));
		}
		g.fillOval(10, 10, 30, 30);
		g.setColor(new Color(0, 0, 0));
		g.setFont(new Font("黑体",0,20));
		g.drawString(s, 50, 32);
	}
	public void repaint2(boolean b,String s1){
		color = b;
		s = s1;
		this.repaint();
	}

}
