package com.zhao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;

public class QiPan extends JComponent{
	
	static List<Pieces> pieces = new ArrayList<Pieces>();//存放棋子
	TiShi tiShi1 = new TiShi();//提示信息条
	String message;//存放当前提示信息
	boolean b = true;//控制游戏开始结束.true--->游戏结束;false--->游戏进行中;
	Pieces pi = null;//存放当前棋子
	public void paint(Graphics g) {
		//填充棋盘背景色
		g.setColor(new Color(245, 131, 65));
		g.fillRect(0, 0, 850, 850);
		//绘制棋盘线条
		for(int i = 0;i<=21;i++){
			int a = i*40+20;
			//填充棋盘线条色
			g.setColor(new Color(0,0,0));
			g.drawLine(20,a,820,a);
			g.drawLine(a,20,a,820);
		}
//		//绘制棋子
		for(Pieces p:pieces){
			//获取棋子颜色
			if(p.isB()){
				g.setColor(new Color(0, 0, 0));
			}else{
				g.setColor(new Color(255, 255, 255));
			}
			//绘制棋子
			g.fillOval(p.getX(), p.getY(),p.WITCH, p.WITCH);
		}
		//红点
		if(pieces.size()>0){
			Pieces p2 = pieces.get(pieces.size()-1);
			g.setColor(new Color(200, 0, 0));
			g.fillOval(p2.getX()+10, p2.getY()+10,10,10);
		}
	}
	/**
	 * 创建棋子
	 */
	public boolean chuangJian(MouseEvent e,boolean color){
		//控制游戏开始结束.true--->游戏结束;false--->游戏进行中;
		if(b){
			return true;
		}
		//获取坐标
		int xx = e.getX();
		int yy = e.getY();
		Pieces pi = new Pieces(xx, yy,color);
		//判断是否存在棋子，不存在则创建
		
		if(pp(pi.getX(),pi.getY())!=null){
			pi = new Pieces(xx, yy,!color);
			return true;
		}
		jie(pi);
		return false;
	}
	public void jie(Pieces ppi){
		pieces.add(ppi);
		pi = ppi;
		draw();
	}
	/**
	 * 绘制棋子与判断
	 */
	public void draw(){
		//绘制
		GameWindow.qiPan.repaint();
		message = "x = "+((pi.getX()-5)/40+1) +"   y = "+((pi.getY()-5)/40+1)+"   ";
		//判断胜负
		if(result(pi,1)||result(pi,2)||result(pi,3)||result(pi,4)){
			message = "游戏结束，"+"恭喜"+(pi.isB()? "黑棋":"白棋")+"赢了！";
			b = true;
//			jButton1.setText("开始游戏");
		}
		GameWindow.tiShi.repaint2(pi.isB(),message);
	}
	/**
	 * 开始与认输
	 */
	public boolean startAndEnd(TiShi tiShi){
		tiShi1 = tiShi;
		b = !b;
		if(b){
			if(pieces.size()==0){
				message = "游戏结束，"+"恭喜白棋赢了！";
			}else{
				message = "游戏结束，"+"恭喜"+(pi.isB()? "黑棋":"白棋")+"赢了！";
			}
			tiShi1.repaint2(pi==null?true:pi.isB(),message);
			return true;
		}
		pieces.clear();
		this.repaint();
		message = "游戏已开始！";
		tiShi1.repaint2(pi==null?true:pi.isB(),message);
		return false;
	}
	/**
	 * 重新开始
	 */
	public boolean resume(TiShi tiShi){
		tiShi1 = tiShi;
		pieces.clear();
		b = false;
		this.repaint();
		message = "游戏已开始！";
		tiShi1.repaint2(pi==null?true:pi.isB(),message);
		return true;
	}
	/**
	 * 悔棋
	 */
	public boolean takeBack(){
		b = false;
		if(pieces.size()==0){
			message = "无法悔棋，请下棋！";
			tiShi1.repaint2(pi==null?true:pi.isB(),message);
			return true;
		}
		pieces.remove(pieces.size()-1);
		this.repaint();
		return false;
	}
	
	
	/**
	 * 通过x，y坐标找棋子，如果有返回true,没有返回false
	 *
	 */
	public Pieces pp(int x,int y){
		for(Pieces p:pieces){
			if(p.getX()==x&&p.getY()==y){
				return p;
			}
		}
		return null;
	}
	/**
	 *判断胜负
	 */
	public boolean result(Pieces s,int h){
		int sum = 1;
		int x = s.getX();
		int y = s.getY();
		for(int i = 0;i<=4;i++){
			if(h==1){//判断"——"
				x-=40;
			}else if(h==2){//判断"|"
				y-=40;
			}else if(h==3){//判断"/"
				x-=40;
				y+=40;
			}else if(h==4){//判断"\"
				x-=40;
				y-=40;
			}
			//判断颜色
			if(pp(x,y)!=null&&s.isB()==pp(x,y).isB()){
				sum++;
			}else{
				break;
			}
			
		}
		x = s.getX();
		y = s.getY();
		for(int i = 0;i<=4;i++){
			if(h==1){//判断"——"
				x+=40;
			}else if(h==2){//判断"|"
				y+=40;
			}else if(h==3){//判断"/"
				x+=40;
				y-=40;
			}else if(h==4){//判断"\"
				x+=40;
				y+=40;
			}
			//判断颜色
			if(pp(x,y)!=null&&s.isB()==pp(x,y).isB()){
				sum++;
			}else{
				break;
			}
		}
		String cs = null;
		if(h==1){//判断"——"
			cs="横";
		}else if(h==2){//判断"|"
			cs="竖";
		}else if(h==3){//判断"/"
			cs="左斜";
		}else if(h==4){//判断"\"
			cs="右斜";
		}
		message += cs+"="+sum+"   ";
		//System.out.println("x="+s.getX()+"\ty="+s.getY()+"\tcolot="+s.isB()+"\t"+c+"="+sum);
		if(sum>=5){
			return true;
		}else{
			return false;
		}
	}

}
