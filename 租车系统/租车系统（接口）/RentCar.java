package com.dazhi;
import java.util.*;
public class RentCar {
	public static Car[] car= {
								new ManCar("奥迪A4",4,500),
								new ManCar("马自达6",4,400),
								new ConvertibleCar("皮卡雪6",4,2,450),
								new ManCar("金龙",20,800),
								new Truck("松花江",4,400),
								new Truck("依维柯",20,1000)
							};// = new Car[100];
	private static Scanner sc = new Scanner(System.in);
	/**
	 * 入口 
	 */
	public static void Entrance(){
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
	 * 输出车辆信息
	 */
	public static void AllCarInfo(){
		System.out.println("|--------------------------------------------------------------");
		System.out.println("| 序号:\t| 车名:\t| 载客数（人）:\t| 载货量（吨）:\t| 日租金（元/天）:");
		System.out.println("|--------------------------------------------------------------");
		for(int i = 0;i<car.length;i++){
			if(car[i]!=null){
				System.out.print("| "+(i+1)+"\t");
				car[i].printCarInfo();
			}
		}
		System.out.println(car.length);
	}
	/**
	 * 选择车辆
	 */
	
	public static Car[] selCar = new Car[100];
	public static double money;
	public static void OptionCar(){
		System.out.println("请输入租车数量：");
		int carNum = Number();
		int carId = 0;
		int dayNum = 0;
		for(int i=0;i<carNum;i++){
			System.out.println("请输入第"+(i+1)+"辆车序号：");
			while(true){
				carId = Number();
				if(carId<=car.length&&carId>0){
					break;
				}
				System.out.println("没有该车！请重新输入：");
			}
			selCar[i] = car[carId-1];
			System.out.println("请输入租用该车天数(最多30天)：");
			while(true){
				dayNum = Number();
				if(dayNum<=30){
					break;
				}
				System.out.println("请输入有效天数：");
			}
			money = money+selCar[i].getRent()*(double)dayNum;
		}
	}
	/**
	 * 账单
	 */
	public static void RentBill(){
		System.out.println("\n***** 您的账单： *****\n");
		int sumMan = 0;
		int sumTon = 0;
		System.out.println("已选载人车：");
		for(int i = 0;i<selCar.length;i++){
			if(selCar[i] != null && selCar[i].getZaiHuo()==0){
				System.out.println(selCar[i].getName());
				sumMan = sumMan +selCar[i].getZaiKe();
			}
		}
		System.out.println("\n\n已选载货车：");
		for(int i = 0;i<selCar.length;i++){
			if(selCar[i] != null && selCar[i].getZaiHuo()!=0){
				System.out.println(selCar[i].getName());
				sumTon = sumTon +selCar[i].getZaiHuo();
			}
		}
		System.out.println("\n\n共载客："+sumMan+"人\n共载货："+sumTon+"吨\n租车总价格："+money);
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
