package zuoye0508_2;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Test01{
	JFrame win1 = null;//窗口
	JMenuBar bar = null;//菜单条
	JMenu jMenu = null;//菜单
	JMenuItem item1 = null;//菜单项
	JMenuItem item2 = null;//菜单项
	JMenuItem item3 = null;//菜单项
	JTextArea jTextArea = null;//文本编辑

	File f1 = null;//文件1
	public Test01(){
		//窗口
		win1 = new JFrame("客户端");
		win1.setTitle("客户端");
		win1.setLayout(new BorderLayout());
		//菜单
		bar = new JMenuBar();
		bar.setBackground(new Color(255, 255, 255));
		jMenu = new JMenu("文件");
		item1 = new JMenuItem("新建");
		item2 = new JMenuItem("打开");
		item3 = new JMenuItem("保存");
		win1.setJMenuBar(bar);
		bar.add(jMenu);
		jMenu.add(item1);
		jMenu.add(item2);
		jMenu.add(item3);
		
		//文本编辑
		jTextArea = new JTextArea();
		jTextArea.setBounds(0, 0, 500, 450);
		win1.add(jTextArea);
		
		//添加功能
		/**
		 * 新建
		 */
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = JOptionPane.showInputDialog("请输入文件名："); 
				if(s.equals("")||s.equals(null)){
					s="新建文本文档";
				}
				f1 = new File(s+".txt");
				if(!f1.exists()){
					try {
						f1.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				//清空文本编辑框
				jTextArea.setText("");
				
			
			}
		};
		item1.addActionListener(al);
		/**
		 * 打开
		 */
		ActionListener al2 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//通过路径打开文件
					while(true){
						String s = JOptionPane.showInputDialog("请输入文件路径："); 
						f1 = new File(s);
						if(f1.exists()){
							if(f1.isFile()){
								break;
							}else{
								s = "不是一个文件！" + s;
							}
						}else{
							s = "没有此文件，"+s;
						}
					}
					
					FileInputStream fr = new FileInputStream(f1);
					byte[] bytes = new byte[1024];
					int len = 0;
					StringBuffer sb = new StringBuffer();
					while((len = fr.read(bytes))!=-1){
						sb.append(new String(bytes,0,len));
					}
					jTextArea.setText(sb.toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		item2.addActionListener(al2);
		
		/**
		 * 保存
		 */
		ActionListener al3 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//保存
				try {
					FileWriter fw = new FileWriter(f1);
					fw.write(jTextArea.getText());
					fw.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		item3.addActionListener(al3);
		
		
		win1.setBounds(0, 0, 500, 450);
		win1.setVisible(true);

	}

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		new Test01();
	}
}
