public class Phone{
	private String name;//手机名称
	private String color;//颜色
	private String brand;//品牌
	SIM sim;//卡
	public Phone(){
	
	}
	public Phone(String name,String color,String brand,SIM sim){
		this.name=name;
		this.color=color;
		this.brand=brand;
		this.sim=sim;
	}
	//手机名称
	public String setName(){
		return this.name;
	}
	public void getName(String name){
		this.name=name;
	}
	//颜色
	public String setColor(){
		return this.color;
	}
	public void getColor(String color){
		this.color=color;
	}
	//品牌
	public String setBrand(){
		return this.brand;
	}
	public void getBrand(String brand){
		this.brand=brand;
	}
}