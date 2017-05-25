import java.util.Scanner;
public class Num6{
	public static void main(String[] args){
		Scanner Sc=new Scanner(System.in);
		int a = Sc.nextInt(),sum=0;
		for(int i=1;i<a;i++){
			if(i%3==0&&i%7==0){
				sum=sum+i;
			}
		}
		System.out.print(Math.sqrt(sum));
	}
}