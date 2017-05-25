public class LoL{
	String name;
	String dingWei;
	String faBuShiJian;
	LoLJiNeng[] jiNeng = new LoLJiNeng[4];
	public void yingXiong(){
		System.out.println("英雄："+name+"\n位置："+dingWei+"\n发布日期："+faBuShiJian+"\n技能说明：");
		for(int i=0;i<jiNeng.length;i++){
			jiNeng[i].jiNeng();
		}
	}
}