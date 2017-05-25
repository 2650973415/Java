/*class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}*/
public class sushu{
	public static void main(String args[]){
		for(int a=3;a<=100;a++){
			int i=0;
			for(int b=2;b<a;b++){
				if(a%b==0){
					break;
				}
				else i++;
			}
			if(i==a-2){
				System.out.println(a);
			}
		}
		//System.out.println("Hello World!");
	}
}