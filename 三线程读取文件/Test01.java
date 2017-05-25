package zuoye0502_3;

import java.io.File;
import java.io.IOException;

public class Test01 {

	public static long startTime=System.currentTimeMillis();   //获取开始时间
	public static void main(String[] args) {
		File f1 = new File("Test.txt");
		File f2 = new File("斗破苍穹.txt");
		int len2 = ((int)f2.length()%3==0 ? (int)f2.length()/3:(int)f2.length()/3+1);
		if(f1.exists()){
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		new Thread(new CopyFile(f1,f2,(int)(len2*0),startTime)).start();
		new Thread(new CopyFile(f1,f2,(int)(len2*1),startTime)).start();
		new Thread(new CopyFile(f1,f2,(int)(len2*2),startTime)).start();

	}

}
