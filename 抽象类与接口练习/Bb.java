interface IA{//接口IA
	//int a;
	public static final double PI = 3.14;
	abstract void abs();
	//public void abs2(){
	//	System.out.println("我是抽象类中的普通方法！");
	//}
}
interface IA2 extends IA{//接口IA2	
	public static final double PI2 = 3.0;
	//int a;
	abstract void abs2();
}
class C implements IA2{//只连接了接口IA，
	public void abs(){
		System.out.println("我是IA接口抽象方法！");
	}
	public void abs2(){
		System.out.println("我是IA2接口抽象方法！");
	}
}
public class Bb{
	public static void main(String[] args){
		IA2 c = new C();
		c.abs();
		c.abs2();
		//c2.abs2();
		new C().abs2();
		System.out.println(c.PI);
		System.out.println(c.PI2);
		//new C().abs2();
	}
}