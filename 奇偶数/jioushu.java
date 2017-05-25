public class jioushu{
	public static void main(String arge[]){
		System.out.print("jishu:\n");
		for(int i=0;i<101;i++){
			if(i%2!=0) System.out.print(i+"\t");
		}
		System.out.print("\noushu:\n");
		for(int i=0;i<101;i++){
			if(i%2==0) System.out.print(i+"\t");
		}
	}
}