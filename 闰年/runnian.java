public class runnian 
{
	public static void main(String[] args) 
	{
		for(int i=1000;i<=2200;i++){
			if(i%4==0&&i%100!=0||i%400==0){
				System.out.print(i+"\t");
			}
		}
		//System.out.println("Hello World!");
	}
}
