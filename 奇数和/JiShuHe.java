public class JiShuHe{
	public static void main(String[] args){
		int sum=0;
		for(int i=100;i<=200;i++){
			if(i%2!=0){
				sum=sum+i;
			}
		}
		System.out.println("100 到200之间所有奇数的和："+sum);
	}
}