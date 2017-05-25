package com.dazhi;
abstract class Car {
	private String name;//名字
	private int zaiKe;//载客数（人）
	private int zaiHuo;//载货量（吨）
	private double rent;//租金（元/天）
	//构造方法
	public Car(){
		
	}
	public Car(String name,int zaiKe,int zaiHuo,double rent){
		this.name=name;
		this.zaiKe=zaiKe;
		this.zaiHuo=zaiHuo;
		this.rent=rent;
	}
	/**
	 * 输出车辆信息
	 */
	public void printCarInfo(){
		System.out.printf("| %s\t| %s\t\t| %s\t\t| %s\t\t\n",name,zaiKe==0?" ":zaiKe,zaiHuo==0?"不能载货":zaiHuo,rent);
	}
	/**
	 * 输出车辆信息（字符串）
	 */
//	public String toString(){
//		System.out.println(zaiKe==0?" ":zaiKe);
//		return ""+this.name+"\t"+zaiKe==0?"":zaiKe+"\t";
//	}
	//getter and setter
	/**
	 * 名字
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 载客数（人）
	 * @return
	 */
	public int getZaiKe() {
		return zaiKe;
	}
	public void setZaiKe(int getzaiKe) {
		this.zaiKe = getzaiKe;
	}
	/**
	 * 载货量（吨）
	 * @return
	 */
	public int getZaiHuo() {
		return zaiHuo;
	}
	public void setZaiHuo(int zaiHuo) {
		this.zaiHuo = zaiHuo;
	}
	/**
	 * 租金（元/天）
	 * @return
	 */
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	

}
