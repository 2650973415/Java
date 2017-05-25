import java.util.*;
public class CaiPiao{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		new CaiPiao().caiPiao();
	}
	public void caiPiao(){
		System.out.println("\n*****彩票小游戏*****\n");//
		System.out.println("说明：最多下10注，且下注号码最大为两位数，最小为1！");//
		System.out.println("\n    例：客户A下注3注，分别为“12”，“88”，“66”，\n\t且本期彩票号码为：“01”，“19”，“20”，“76”，“88”，“91”，“36”，“53”，“78”，“10”，\n\t那么客户A此次购买彩票中了一注：“88”；并获得相应奖品！");//
		System.out.println("\n奖品：");//
		System.out.println("中  一  注：酱油一瓶");//
		System.out.println("中二到四注：酱油三瓶");//
		System.out.println("中五到七注：酱油一箱");//
		System.out.println("中八到九注：酱油两箱");//
		System.out.println("十 注全 中：超市一个！！\n");//
		int num = 0;
		while(true){
			System.out.println("请输入注数(1~10)：");//
			num = num();
			if(num>0&&num<11){
				break;
			}
		}
		int[] zhu = new int[num];
		int[] piaoId = new int[10];
		int count = 0;
		System.out.println("请输入（1~99）:");
		for(int i = 0;i<num;i++){
			System.out.println("第"+(i+1)+"注：");
			zhu[i] = num();
			if(zhu[i]<1||zhu[i]>99){
				i--;
				continue;
			}
			for(int j = 0;j<i;j++){
				if(zhu[i] == zhu[j]){
					System.out.println("此注已下！");
					i--;
					break;
				}
			}
		}
		for(int i = 0;i<piaoId.length;i++){
			piaoId[i] = (int)(Math.random()*10+1);
			for(int j = 0;j<i;j++){
				if(piaoId[i] == piaoId[j]){
					i--;
					break;
				}
			}
		}
		System.out.println("本次号码为：");
		for(int a:piaoId){
			System.out.print(a+"\t");//
			for(int j=0;j<zhu.length;j++){
				if(a==zhu[j]){
					count++;
				}
			}
		}
		System.out.println("\n\n您中了"+count+"注！获得奖品："+(count==1?"酱油一瓶！":count>1&&count<5?"酱油三瓶！":count>4&&count<8?"酱油一箱！":count>7&&count<10?"酱油两箱！":count==10?"超市一个！！":""));//
	}
	public int num(){
		String str = sc.next();
		try{
			return Integer.parseInt(str);
		}catch (Exception e) {
			System.out.println("请输入整数：");
		}
		return num();
	}
}