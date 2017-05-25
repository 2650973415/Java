import java.util.Scanner;
public class XuanZe{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int[] a=new int[10];
		System.out.println("请输入10个整数（结果为asc）：");
		//输入10个数
		for(int i=0;i<a.length;i++){
			System.out.println("第"+(i+1)+"个：");
			a[i]=sc.nextInt();
		}
		//创建循环，假设最小值min=a[i]
		for(int i=0;i<a.length;i++){
			int min,b=i,c;
			min=a[i];
			for(int j=i+1;j<a.length;j++){
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