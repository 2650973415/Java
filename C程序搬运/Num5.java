public class Num5{
	public static void main(String[] args){
		for(int a=1;a<=(500-20-10-5)/50;a++){
			for(int b=1;b<=(500-50-10-5)/20;b++){
				for(int c=1;c<=(500-50-20-5)/10;c++){
					for(int d=1;d<=(500-50-20-10)/5;d++){
						if(50*a+20*b+10*c+5*d==500){
							System.out.print("50:"+a+"\t20:"+b+"\t10:"+c+"\t5:"+d+"\n");
						}
					}
				}
			}
		}
	}
}