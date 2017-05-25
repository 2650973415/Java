package zuoye0508_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Test01 extends JFrame{
	static boolean flag = true;
	int a=0;
	public Test01(){
		this.setLayout(null);
		//标题
		this.setTitle("随机数");
		//随机数
		JLabel jLabel = new JLabel();
		jLabel.setText("获取结果：");
		jLabel.setBounds(40,30,100,20);
		this.add(jLabel);
		
		//随机数框
		JTextArea textArea = new JTextArea();
		textArea.setText("");
		textArea.setBounds(40,60,100,20);
		this.add(textArea);
		
		//用户输入
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("用户输入：");
		jLabel2.setBounds(40, 90, 100, 20);
		this.add(jLabel2);
		//用户输入框
		JTextArea textArea2 = new JTextArea();
		textArea2.setText("");
		textArea2.setBounds(40, 120, 100, 20);
		this.add(textArea2);
		
		//按钮
		JButton jButton = new JButton();
		jButton.setText("开始");
		jButton.setBounds(40, 150, 70, 20);
		jButton.setBackground(new Color(255,255,0));
		
		/**
		 * 用线程获取随机数
		 */
		
		//点击开始
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new Runnable() {
					public void run() {
						synchronized (jButton) {
							while(flag){
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								textArea.setText((int)(Math.random()*3+1)+"");
							}
						}
					}
				});
				t.start();
				//获取按钮value值
				String value = jButton.getText();
				//开关
				if(value.equals("开始")){
					flag = true;
					jButton.setText("结束");
				}else if(value.equals("结束")){
					flag = false;
					jButton.setText("开始");
					synchronized (jButton) {
						//判断是否与用户输入的一致
						if(textArea.getText().equals(textArea2.getText())){
							System.out.println("恭喜你猜对了！");
						}else{
							System.out.println("抱歉，猜错了！");
						}
					}
					
				}
				
				
			}
		};
		jButton.addActionListener(al);
		//添加到窗口中
		this.add(jButton);
		

		this.setBounds(20, 20, 350, 300);
		this.setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new Test01();
	}

}

