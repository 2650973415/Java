import java.util.Scanner;
public class Num3{
	public static void main(String[] args){
		Scanner Sc= new Scanner(System.in);
		int[] a= new int[20];
		int b=0;
		System.out.print("Qing Shu Ru 20 Ge Shu:");
		for(int i=0;i<a.length;i++){
			a[i]=Sc.nextInt();
			if(a[i]>0) b++;
		}
		System.out.print(b);
	}
}