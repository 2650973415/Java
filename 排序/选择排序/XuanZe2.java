import java.util.Scanner;
public class XuanZe2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int[] a={2,56,3,61,7,5,33,0,9,8};
		for(int i=0;i<a.length;i++){
			int b=i,c;
			int min=a[i];
			for(int j=i;j<a.length;j++){
				if(a[j]<min){
					min=a[j];
					b=j;
				}
			}
			c=a[i];
			a[i]=a[b];
			a[b]=c;
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
	}
}