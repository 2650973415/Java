import java.util.Scanner;
public class Num4{
	public static void main(String[] args){
		Scanner Sc=new Scanner(System.in);
		int[] a=new int[5],b=new int[5];
		System.out.print("Qing Shu Ru 5 Ge Zheng Shu:");
		for(int i=0;i<a.length;i++){
			a[i]=Sc.nextInt();
		}
		for(int i=0,j=5;i<a.length;i++,j++){
			b[i]=a[j];
			System.out.print(b[i]);
		}
	}
}