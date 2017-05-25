package zuoye0509_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test01 {
	JFrame jf1 = null;
	JLabel jLabel = null;
	ImageIcon image1 = new ImageIcon("2.jpg");
	Image image;
	int a = 0;
	int length = 120;
	public Test01(){
		jf1 = new JFrame("ºìÂ·µÆ");
		jf1.setLayout(null);
		new Thread(new Runnable() {
			public void run() {
				int a = 1;
				int b = 50;
				jLabel = new JLabel();
				jf1.add(jLabel);
				while(true){
					if(a>3){
						a=1;
						b=50;
					}
					jLabel.setIcon(new ImageIcon(a+".png"));
					jLabel.setBounds(b,50,162,162);
					try{
						if(a==1){
							Thread.sleep(2000);
						}else if(a == 2){
							Thread.sleep(2000);
						}else if(a == 3){
							Thread.sleep(2000);
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					a++;
					b+=182;
				}
			}
		}).start();;
//		//ºì
//		jLabel = new JLabel(new ImageIcon(1+".png"));
//		jLabel.setBounds(50,50,162,162);
//		jf1.add(jLabel);
//		//ÂÌ
//		jLabel = new JLabel(new ImageIcon(2+".png"));
//		jLabel.setBounds(232,50,162,162);
//		jf1.add(jLabel);
//		//»Æ
//		jLabel = new JLabel(new ImageIcon(3+".png"));
//		jLabel.setBounds(414,50,162,162);
//		jf1.add(jLabel);
		//µ×Í¼
//		jLabel = new JLabel(image1);
//		jLabel.setBounds(0, 0, 769, 769);
//		jf1.add(jLabel);

		jf1.setBounds(0, 0, 656, 320);
		jf1.setVisible(true);
	}
	public static void main(String[] args) {
		new Test01();
	}

}
