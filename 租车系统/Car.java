package Test01;
public class Car {
	private int id;//序号
	private String name;//名字
	private int zaiKe;//载客数（人）
	private int zaiHuo;//载货量（吨）
	private double rent;//租金（元/天）
	//构造方法
	public Car(){
		
	}
	public Car(int id,String name,int zaiKe,int zaiHuo,double rent){
		this.id=id;
		this.name=name;
		this.zaiKe=zaiKe;
		this.zaiHuo=zaiHuo;
		this.rent=rent;
	}
	/**
	 * 输出车辆信息
	 */
	public void printCarInfo(){
		String str = "不能载货";
		System.out.printf("| %s\t| %s\t| %s\t\t| %s\t\t| %s\t\t\n",id,name,zaiKe,zaiHuo==0?str:zaiHuo,rent);
	}
	//getter and setter
	/**
	 * 序号
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
