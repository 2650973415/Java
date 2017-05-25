import java.util.Scanner;
public class Bb{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Aa a = new Aa();
		Aa[] as = new Aa[100];
		for(int i=0;i<2;i++){
			as[i].name=sc.next();
			as[i].sex=sc.next();
			as[i].age=sc.nextInt();
		}
		for(int i:as){
			if(as[i]!=null){
				as[i].stu();
			}
		}
	}
}