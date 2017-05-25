public class Sup{
	private int id;//商品id
	private String name;//商品名
	private int repert;//库存
	//触发器（无参）
	public Sup(){
		
	}
	//触发器（有参）
	public Sup(int id,String name,int repert){
		this.id=id;
		this.name=name;
		this.repert=repert;
	}
	//商品信息
	public void com(){
		System.out.println("-------------------------------------------");
		System.out.println("| 编号: "+id+"   | 商品名："+name+"   | 库存:"+repert);
	}
	//商品set
	public String setName(){
		return this.name;
	}
	//商品get
	public void getName(String name){
		this.name=name;
	}
	//库存set
	public int setRepert(){
		return this.repert;
	}
	//库存get
	public void getRepert(int repert){
		this.repert=repert;
	}
	public void getRepert(int repert,int SSnum,int k){

		this.repert=repert;
	}
}