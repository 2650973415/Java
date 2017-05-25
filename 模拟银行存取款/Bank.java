public class Bank{
	private String name;//账户名
	private int cardNo;//卡号
	private String code;//密码
	private int money;//存款
	//触发器（无参）
	public Bank(){
		
	}
	//触发器（有参）
	public Bank(String name,int cardNo,String code,int money){
		this.name=name;
		this.cardNo=cardNo;
		this.code=code;
		this.money=money;
	}
	//账户信息
	public void com(){
		System.out.println("-------------------------------------------");
		System.out.println("| 账户名: "+name+"\n| 卡号："+cardNo+"\n| 密码："+code+"\n| 存款："+money+"￥");
	}
	//账户名set
	public String setName(){
		return this.name;
	}
	//账户名get
	public void getName(String name){
		this.name=name;
	}
	//卡号set
	public int setCardNo(){
		return this.cardNo;
	}
	//卡号get
	public void getCardNo(int cardNo){
		this.cardNo=cardNo;
	}
	//密码set
	public String setCode(){
		return this.code;
	}
	//密码get
	public void getCode(String code){
		this.code=code;
	}
	//存款set
	public int setMoney(){
		return this.money;
	}
	//存款get
	public void getMoney(int money){
		this.money=money;
	}
	/*
	public void getMoney(int money,int SSnum,int k){

		this.money=money;
	}
	*/
}