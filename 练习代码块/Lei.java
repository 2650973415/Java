public class Lei{
	static {
		int i = 1;
		System.out.println("我是类中静态代码块，值："+i);
	}
	{
		int i = 1;
		System.out.println("我是类中构造代码块，值："+i);
	}
	public Lei(){
		System.out.println("我是构造器！");
		{
		int i = 1;
		System.out.println("我是类中普通代码块，值："+i);
		}
	}
}