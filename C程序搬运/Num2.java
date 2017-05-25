import java.util.Scanner;
public class Num2{
	public static void main(String[] args){
		int a,sum=0;
		Scanner Sc= new Scanner(System.in);
		while(1==1){
			System.out.print("Please enter a positive number:");
			a=Sc.nextInt();
			if(a>1) break;
		}
		for(int i=1;i<=a;i++){
			sum=sum+i;
		}
		System.out.print(sum);
	}
}