import java.util.*;
public class ZuoYe1{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] a = new int[5];
		System.out.println("请输入5个整数：");
		for(int i=0;i<a.length;i++){
			String str = sc.next();
			int num;
			try{
				//字符串转换为整型
				num = Integer.parseInt(str);
			}catch(Exception e){
				System.out.println(str+"不是整数，请输入整数!");
				--i;
			}
			//a[i]=num;
		}
		/*for(int i:a){
			System.out.print(i+"\t");
		}*/
	}
}