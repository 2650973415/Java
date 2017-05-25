package Test01;
import java.util.*;
public class RentCar {
	public static Car[] car = new Car[100];
	private static Scanner sc = new Scanner(System.in);
	/**
	 *初始化车辆信息 
	 */
	public static void carInfo(){
		car[0] = new Car(1,"奥迪A4",4,0,500);
		car[1] = new Car(2,"马自达6",4,0,400);
		car[2] = new Car(3,"皮卡雪6",4,2,450);
		car[3] = new Car(4,"金龙",20,0,800);
		car[4] = new Car(5,"松花江",2,4,400);
		car[5] = new Car(6,"依维柯",2,20,1000);
	}
	/**
	 * 入口 
	 */
	public static void Entrance(){
		carInfo();
		System.out.println("****** 欢迎使用租车系统！ *****");
		System.out.println("******  您确认租车吗？   ******");
		boolean yesNo = Judge();
		if(yesNo){
			AllCarInfo();
			OptionCar();
			RentBill();
		}else{
			System.out.println("****感谢您的惠顾，欢迎再次光临！****");
			System.exit(0);
		}
	}
	/**
	 * yes||no
	 * @return
	 */
	public static boolean Judge(){
		System.out.print("请输入（YES：Y/NO：N）：");
		while(true){
			String str = sc.next();
			if(str.equals("Y")||str.equals("y")){
				return true;
			}else if(str.equals("N")||str.equals("n")){
				return false;
			}
			System.out.print("没有此选项，请输入（Y/N）：");
		}
	}
	/**
	 * 输出所有车辆信息
	 */
	public static void AllCarInfo(){
		System.out.println("|--------------------------------------------------------------");
		System.out.println("| 序号:\t| 车名:\t| 载客数（人）:\t| 载货量（吨）:\t| 日租金（元/天）:");
		System.out.println("|--------------------------------------------------------------");
		for(Car c:car){
			if(c!=null){
				c.printCarInfo();
			}
		}
	}
	/**
	 * 选择车辆
	 */
	public static int[] carId = new int[100];
	public static void OptionCar(){
		System.out.println("请输入租车数量：");
		int num = Number();
		for(int i=0;i<num;i++){
			System.out.println("请输入第"+(i+1)+"辆车序号：");
			carId[i] = Number();
		}
	}
	/**
	 * 账单
	 */
	public static void RentBill(){
		System.out.println("\n***** 您的账单： *****\n");
		double money = 0d;
		int num = 0;
		int num2 = 0;
		System.out.println("已选载人车：");
		for(int i = 0;i<car.length;i++){
			for(int j = 0;j<carId.length;j++){
				if(car[i] != null&&car[i].getId()==carId[j]&&car[i].getZaiHuo()==0){
					System.out.println(car[i].getName());
					money = money + car[i].getRent();
					num = num + car[i].getZaiKe();
				}
			}
		}
		System.out.println("\n\n已选载货车：");
		for(int i = 0;i<car.length;i++){
			for(int j = 0;j<carId.length;j++){
				if(car[i] != null&&car[i].getId()==carId[j]&&car[i].getZaiHuo()!=0){
					System.out.println(car[i].getName());
					money = money + car[i].getRent();
					num2 = num2 +car[i].getZaiHuo();
				}
			}
		}
		System.out.println("共载客："+num+"人\n共载货："+num2+"吨\n租车总价格："+money);
	}
	/**
	 * 输入整数
	 */
	public static int Number(){
		String str = sc.next();
		try{
			return Integer.parseInt(str);
		}catch (Exception e) {
			System.out.println("请输入整数：");
		}
		return Number();
	}
}
