import java.util.Scanner;
import java.util.Arrays;
public class ErFenChaZhao{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		//Arrays.copyOf(数组,M)----------->复制前几个
		//Arrays.copyOfRange(数组,M,N)---->复制指定位置M->N
		int[] d = Arrays.copyOf(a,8);
		int[] b = Arrays.copyOfRange(a,0,10);
		int[] c = {8,4,6,2,10,1,9,3,5,7};
		System.out.print("数组a[]:");
		for(int i=0;i<a.length;i++) System.out.print(a[i]+"  ");
		System.out.print("\n数组b[]:");
		for(int i=0;i<b.length;i++) System.out.print(b[i]+"  ");
		System.out.print("\n数组c[]:");
		for(int i=0;i<c.length;i++) System.out.print(c[i]+"  ");
		System.out.print("\n数组d[]:");
		for(int i=0;i<d.length;i++) System.out.print(d[i]+"  ");
		System.out.print("\n(Arrays.copyOfRange)copyOf复制数组b[]输出：");
		for(int i=0;i<b.length;i++) System.out.print(b[i]+"  ");
		//Arrays.binarySearch(数组,值)---->之所在数组中的位置，需先升序排序
		System.out.println("\n(Arrays.binarySearch)7所在数组a[]的位置："+Arrays.binarySearch(a,7));
		//Arrays.equals(数组1,数组2)------>比较数组
		System.out.println("(Arrays.equals)比较数组a[]\\b[]："+Arrays.equals(a,b));
		//Arrays.sort(数组,M,N)--------------->给M->N排序，升序
		Arrays.sort(c,3,9);
		System.out.print("(Arrays.sort)给M->N排序后数组c[]:");
		for(int i=0;i<c.length;i++) System.out.print(c[i]+"  ");
		//Arrays.sort(数组)--------------->给整个数组排序，升序
		Arrays.sort(c);
		System.out.print("\n(Arrays.sort)整个数组排序后数组c[]:");
		for(int i=0;i<c.length;i++) System.out.print(c[i]+"  ");
		//Arrays.fill(数组,值)------------>给数组重新赋值
		Arrays.fill(a,1);
		System.out.print("\n(Arrays.fill)全部重新赋值后的数组a[]:");
		for(int i=0;i<a.length;i++) System.out.print(a[i]+"  ");
		//Arrays.fill(数组,M,N值)--------->给数组M->N重新赋值
		Arrays.fill(a,2,8,2);
		System.out.print("\n(Arrays.fill)M->N重新赋值后的数组a[]:");
		for(int i=0;i<a.length;i++) System.out.print(a[i]+"  ");



		System.out.println("\n\n\n");
	}
}