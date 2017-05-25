public class wanshu{
	public static void main(String arge[]){
		for(int i=1;i<=1000;i++){
			int sum=0;
			for(int j=1;j<i;j++){
				if(i%j==0){
					sum=sum+j;
				}
			}
			if(i==sum){
				System.out.print(i+"\n");
			}
		}
	}
}
//6	6	6	6	6	6
//%	%	%	%	%	%
//1	2	3	4	5	6
//=	=	=	=	=	=
//0	0	0	2	1	0