import java.util.Scanner;
public class Jisuanqi2{
	public static void main(String[] args){
		Scanner Sc = new Scanner(System.in);
		System.out.println("请输入两个数");
		int a=Sc.nextInt();
		String c=Sc.next();
		char d=c.charAt(0);
		int b=Sc.nextInt();
		if(d=='+'){
			System.out.println(a+"+"+b+"="+(a+b));
		}
		if(d=='-'){
			System.out.println(a+"-"+b+"="+(a-b));
		}
		if(d=='*'){
			System.out.println(a+"*"+b+"="+(a*b));
		}
		if(d=='/'){
			System.out.println(a+"/"+b+"="+(a/b));
		}
	}
}