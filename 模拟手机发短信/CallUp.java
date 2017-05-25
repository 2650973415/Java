import java.util.Scanner;
public class CallUp{
	static Scanner sc = new Scanner(System.in);
	public static Person[] person = new Person[100];
	public static Phone[] phone = new Phone[100];
	public static SIM[] sim = new SIM[100];
	public static Person person2 = new Person();
	public static Phone phone2 = new Phone();
	public static SIM sim2 = new SIM();
	public static void main(String[] args){
		init();
		ssm();
	}
	//初始化值
	static void init(){
		sim[0] = new SIM("联通","18669925665");
		phone[0] = new Phone("红米note","白","小米手机",sim[0]);
		person[0] = new Person("赵庆海",'男',17,phone[0]);
		sim[1] = new SIM("移动","17853941237");
		phone[1] = new Phone("小米5","黑","小米手机",sim[1]);
		person[1] = new Person("赵青海",'女',15,phone[1]);
	}
	//发短信
	static void ssm(){
		System.out.println("\n----------------- 发短信！-----------------\n");
		System.out.println("-------- 当前默认卡号：18669925665 --------");
		System.out.println("\n");
		System.out.print("收件人：");
		String str = sc.next();
		System.out.print("内容：");
		String str2 = sc.next();
		for(int i=0;i<sim2.inbox.length;i++){}
	}

	//菜单
	static void menu(){
		System.out.println("----------------------------");
		System.out.println("请选择：");
		System.out.println("1.选择手机");
		System.out.println("2.添加手机");
		System.out.println("3.更换手机卡");
	}
}