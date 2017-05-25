import java.util.Scanner;
public class SupAdmin{
	//商品信息
	public static Sup[] sup = new Sup[100];
	static Scanner sc = new Scanner(System.in);
	//保存下架后商品留下的空位
	//static int[] nullValue = new int[100];
	//static int n = 0;
	//菜单
	static void menu(){
		System.out.println("-------------------------------------------");
		System.out.println("请选择操作：");
		System.out.println("    1.上架新商品");
		System.out.println("    2.进货");
		System.out.println("    3.销售");
		System.out.println("    4.库存");
		System.out.println("    5.下架");
		System.out.println("    6.退出");
		System.out.print("\n输入：");
		int num = sc.nextInt();
		switch(num){
			case 1://上架新商品
				shangJia();
				break;
			case 2://进货
				supStock();
				break;
			case 3://销售
				supMarket();
				break;
			case 4://库存
				supRepert();
				break;
			case 5://下架
				xiaJia();
				break;
			case 6://退出
				System.exit(0);
				break;
			default:
				System.out.print("没有此选项，");
		}
		menu();
	}
	//上架商品
	static int i = 0;
	static void shangJia(){
		System.out.println("-------------------------------------------");
		System.out.println("请输入新上架的：");
		//输入商品名
		System.out.print("商品名：");
		String supName = sc.next();
		//输入库存量
		System.out.print("库存量：");
		int supRepert = sc.nextInt();
		//new地址
		//将上架的商品存入数组
		for(int i=0;i<sup.length;i++){
			if(sup[i]==null){
				Sup sup2 = new Sup(i+1,supName,supRepert);
				sup[i]=sup2;
				break;
			}
		}
		//sup[i++]=sup2;
		//sup[i].com();
		System.out.println("成功添加1条记录！\n");
		//是否继续操作
		if(textPanDuan()){
			shangJia();
		}
	}
	//查看库存
	static void supRepert(){
		//选择所需商品文本调用
		textSelGoods(1);
		//是否继续操作
		if(textPanDuan()){
			supRepert();
		}
	}
	//进销数量
	static int SSNum(int k){
		if(k==2){
			System.out.print("进货数量：");
		}else if(k==3){
			System.out.print("销售数量：");
		}else{
			return 0;
		}
		return sc.nextInt();
	}
	//k=1; --->查看库存
	//k=2; --->进货
	//k=3; --->销售
	//k=4; --->下架
	//s; ----->商品地址
	static boolean kuCun = true;
	static boolean kuCun2 = true;
	static void SSS(int s,int k,int SSnum){
		switch(k){
			case 1://查看库存
				sup[s].com();
				break;
			case 2://进货
				sup[s].getRepert(sup[s].setRepert()+SSnum);
				break;
			case 3://销售
				kuCun = (sup[s].setRepert()-SSnum<0);
				kuCun2 = (sup[s].setRepert()==0);
				if(kuCun){
					System.out.println("商品"+sup[s].setName()+"没有足够库存！");
				}else if(kuCun2){
					System.out.println("商品"+sup[s].setName()+"库存为0请及时进货！");
				}else{
					sup[s].getRepert(sup[s].setRepert()-SSnum);
				}
				break;
			case 4://下架
				sup[s]=null;
				break;
		}
	}
	//计数
	static int count;
	static void count(int count,int k){
		System.out.println("-------------------------------------------");
		if(count==0){
			System.out.println("没有商品或已经下架！！");
		}else if(k==1){
			System.out.println("操作成功！");
			System.out.println("共"+count+"条记录！");
		}else if(kuCun&&k==3||kuCun2&&k==3){
			System.out.println("共0条记录受影响！");
		}else{
			System.out.println("操作成功！");
			System.out.println("共"+count+"条记录受影响！");
		}
		System.out.println("\n");
	}
	//库存1
	static void repert1(int k){
		count=0;
		int SSnum2=SSNum(k);
		for(int s=0;s<sup.length;s++){
			if(sup[s]!=null){
				count++;
				SSS(s,k,SSnum2);
			}
		}
		count(count,k);
	}
	//库存2
	static void repert2(int k){
		System.out.println("-------------------------------------------");
		System.out.println("请输入商品名称：");
		System.out.print("\n输入：");
		String supName = sc.next();
		int SSnum2=SSNum(k);
		boolean bSup=true;
		count=0;
		for(int s=0;s<sup.length;s++){
			if(sup[s]!=null){
				bSup = (sup[s].setName().equals(supName));
				if(bSup){
					count++;
					SSS(s,k,SSnum2);
				}
			}
		}
		count(count,k);
	}
	//进货
	static void supStock(){
		System.out.println("进货↓");
		//选择所需商品文本调用
		textSelGoods(2);
		//是否继续操作
		if(textPanDuan()){
			supStock();
		}
	}
	//销售
	static void supMarket(){
		System.out.println("销售↓");
		//选择所需商品文本调用
		textSelGoods(3);
		//是否继续操作
		if(textPanDuan()){
			supMarket();
		}
	}
	//下架
	static void xiaJia(){
		System.out.println("下架↓");
		//选择所需商品文本调用
		textSelGoods(4);
		//是否继续操作
		if(textPanDuan()){
			xiaJia();
		}
	}
	//输出选择所需商品文本
	static void textSelGoods(int k){
		System.out.println("-------------------------------------------");
		System.out.println("请选择所需商品：");
		System.out.println("    1.所有商品");
		System.out.println("    2.指定商品");
		System.out.println("    3.其他任意键返回上级菜单");
		System.out.print("\n输入：");
		int num = sc.nextInt();
		System.out.print("\n\n");
		if(num==1){
			repert1(k);
		}else if(num==2){
			repert2(k);
		}else{
			menu();
		}
	}
	//输出是否继续操作文本（返回值true）
	static boolean textPanDuan(){
		System.out.println("-------------------------------------------");
		System.out.println("是否继续操作：");
		System.out.println("    1.是");
		System.out.println("    2.否(返回上级菜单)");
		System.out.println("    3.其他任意键返回上级菜单");
		System.out.print("\n输入：");
		//是否继续上架商品
		int num = sc.nextInt();
		System.out.print("\n\n");
		if(num==1){
			return true;//继续
		}else{
			menu();//返回上级菜单
			return false;
		}
	}
}