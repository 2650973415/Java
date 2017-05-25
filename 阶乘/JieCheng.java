public class JieCheng{
	public static void main(String[] args){
		int ji=1,sum=0;
		for(int i=1;i<=10;i++){
			ji=ji*i;
			sum=sum+ji;
		}
		System.out.println("1!+2!+...+10!="+sum);
	}
}