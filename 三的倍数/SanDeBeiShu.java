public class SanDeBeiShu{
	public static void main(String[] args){
		int a=0;
		System.out.print("\n100以内3的倍数的数字有:\n");
		for(int i=0;i<101;i++){
			if(i%3==0){
				a++;
				System.out.print(i+"\t");
			}
		}
		System.out.print("\n100以内3的倍数的数字有"+a+"个!\n\n");
	}
}