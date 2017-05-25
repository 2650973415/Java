public class TangSeng{
	public static void main(String[] args){
		int sum=0;
		for(int i=1;i<=100;i++){
			sum=sum+i;
			if(i==25){
				System.out.println("ÌÆÉ®£º"+sum);
				sum=0;
			}else if(i==50){
				System.out.println("Îò¿Õ£º"+sum);
				sum=0;
			}else if(i==75){
				System.out.println("°Ë½ä£º"+sum);
				sum=0;
			}else if(i==100){
				System.out.println("É³É®£º"+sum);
			}
		}
	}
}
