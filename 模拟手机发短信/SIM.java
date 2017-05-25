public class SIM{
	private String name;//厂商
	private String cardNo;//卡号
	private String[] inbox;//收件箱
	public SIM(){
	
	}
	public SIM(String name,String cardNo){
		this.name=name;
		this.cardNo=cardNo;
	}
	public void SIMcom(){
		System.out.println(cardNo);
	}
	//厂商
	public String setName(){
		return this.name;
	}
	public void getName(String name){
		this.name=name;
	}
	//卡号
	public String setCardNo(){
		return this.cardNo;
	}
	public void getCardNo(String cardNo){
		this.cardNo=cardNo;
	}
	//收件箱
	public void setInbox(int k){
		System.out.println(inbox[k]);
	}
	public void setInbox(){
		for(int i=0;i<inbox.length;i++){
			if(inbox[i]!=null){
				System.out.println(inbox[i]);
			}
		}
	}
	public void getInbox(int k,String inbox){
		this.inbox[k]=inbox;
	}
}