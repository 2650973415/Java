import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//寒冰射手
		LoL yx1 = new LoL();
		LoL[] lols = new LoL[2];
		LoLJiNeng lolJN_Q = new LoLJiNeng();
		LoLJiNeng lolJN_W = new LoLJiNeng();
		LoLJiNeng lolJN_E = new LoLJiNeng();
		LoLJiNeng lolJN_R = new LoLJiNeng();
		yx1.name="寒冰射手";
		yx1.dingWei="射手";
		yx1.faBuShiJian="2005-10-02";
		//技能Q
		lolJN_Q.name="射手的专注（Q）";
		lolJN_Q.shangHai=200;
		lolJN_Q.CD=10;
		lolJN_Q.haoLan=60;
		lolJN_Q.shuoMing="获得攻击速度，普攻造成额外物理伤害，并且。。。。。。";
		yx1.jiNeng[0]=lolJN_Q;
		//技能W
		lolJN_W.name="射手的专注（W）";
		lolJN_W.shangHai=200;
		lolJN_W.CD=10;
		lolJN_W.haoLan=60;
		lolJN_W.shuoMing="获得攻击速度，普攻造成额外物理伤害，并且。。。。。。";
		yx1.jiNeng[1]=lolJN_W;
		//技能E
		lolJN_E.name="射手的专注（W）";
		lolJN_E.shangHai=200;
		lolJN_E.CD=10;
		lolJN_E.haoLan=60;
		lolJN_E.shuoMing="获得攻击速度，普攻造成额外物理伤害，并且。。。。。。";
		yx1.jiNeng[2]=lolJN_E;
		//技能Q
		lolJN_R.name="射手的专注（R）";
		lolJN_R.shangHai=200;
		lolJN_R.CD=10;
		lolJN_R.haoLan=60;
		lolJN_R.shuoMing="获得攻击速度，普攻造成额外物理伤害，并且。。。。。。";
		yx1.jiNeng[3]=lolJN_R;
		//传递yx1的地址给数组；
		lols[0]=yx1;
		lols[0].yingXiong();
		
		System.out.println("\n\n------------------------------------------------------\n\n");

		//德玛西亚之力
		LoL yx2 = new LoL();
		yx2.name="德玛西亚之力";
		yx2.dingWei="战士";
		yx2.faBuShiJian="2015-10-02";
		//技能Q
		lolJN_Q.name="射手的专注（Q）";
		lolJN_Q.shangHai=200;
		lolJN_Q.CD=10;
		lolJN_Q.haoLan=60;
		lolJN_Q.shuoMing="获得攻击速度，普攻造成额外物理伤害，并且。。。。。。";
		yx2.jiNeng[0]=lolJN_Q;
		//技能W
		lolJN_W.name="射手的专注（W）";
		lolJN_W.shangHai=200;
		lolJN_W.CD=10;
		lolJN_W.haoLan=60;
		lolJN_W.shuoMing="获得攻击速度，普攻造成额外物理伤害，并且。。。。。。";
		yx2.jiNeng[1]=lolJN_W;
		//技能E
		lolJN_E.name="射手的专注（W）";
		lolJN_E.shangHai=200;
		lolJN_E.CD=10;
		lolJN_E.haoLan=60;
		lolJN_E.shuoMing="获得攻击速度，普攻造成额外物理伤害，并且。。。。。。";
		yx2.jiNeng[2]=lolJN_E;
		//技能Q
		lolJN_R.name="射手的专注（R）";
		lolJN_R.shangHai=200;
		lolJN_R.CD=10;
		lolJN_R.haoLan=60;
		lolJN_R.shuoMing="获得攻击速度，普攻造成额外物理伤害，并且。。。。。。";
		yx2.jiNeng[3]=lolJN_R;
		//传递yx1的地址给数组；
		lols[1]=yx2;
		lols[1].yingXiong();
	}
}