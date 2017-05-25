import java.util.Scanner;
public class Num1{
	public static void main(String[] args){
		int[] b = new int[5];
		int a;
		Scanner Sc= new Scanner(System.in);
		while(1==1){
			System.out.print("Please enter an integer a is no more than five:");
			a=Sc.nextInt();
			if(a<100000&&a>0) break;
		}
		b[0]=a%10;
		b[1]=a/10%10;
		b[2]=a/100%10;
		b[3]=a/1000%10;
		b[4]=a/10000;
		for(int i=0,j=1;i<b.length;i++,j=j*10){
			if(a/j==0) break;
			else System.out.print(b[i]);
		}
		
	}
}