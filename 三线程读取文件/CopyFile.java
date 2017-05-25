package zuoye0502_3;

import java.io.*;

public class CopyFile implements Runnable{
	private File f1;
	private File f2;
	private int len;
	long startTime;
	public CopyFile(File f1, File f2, int len,long startTime){
		this.f1 = f1;
		this.f2 = f2;
		this.len = len;
		this.startTime = startTime;
	}
	public void run() {
		
		synchronized (Test01.class) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			RandomAccessFile r1 = null;
			RandomAccessFile r2 = null;
			try {
				r1 = new RandomAccessFile(f1,"rw");
				r2 = new RandomAccessFile(f2,"rw");
				r1.seek(len);
				r2.seek(len);
				int len2 = ((int)f2.length()%3==0 ? (int)f2.length()/3:(int)f2.length()/3+1);
				byte[] bytes = new byte[1024];
				int a = 0;
				int count = 0;
				while((a = r2.read(bytes))!=-1){
					count = count + a;
					if(count>len2){
						r1.write(bytes,0,a-(count-len2));
						break;
					}
					r1.write(bytes,0,a);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					r1.close();
					r2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("复制完成！");
				long endTime=System.currentTimeMillis(); //获取结束时间

				System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
			}
		}
		
	}
}
