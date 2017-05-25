public class Main{
	static {
		int i = 1;
		System.out.println("静态代码块，值："+i);
	}
	public static void main(String[] args){
		new Lei();
		{
			int i = 1;
			System.out.println("普通代码块，值："+i);
		}
	}
}