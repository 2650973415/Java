import java.util.Scanner;
public class BankAdmin{
	//账户信息
	public static Bank[] bank = new Bank[100];
	static Scanner sc = new Scanner(System.in);
	static String adminCode = "admin";
	//初始化数组
	static void bankB(){
		bank[0] = new Bank("赵庆海",12345678,"123456",10000);
		bank[1] = new Bank("赵青海",110,"654321",20000);
	}
	//菜单
	static void menu(){
		System.out.println("-------------------------------------------");
		System.out.println("请选择操作：");
		System.out.println("    1.登录");
		System.out.println("    2.管理员");
		System.out.println("    3.退出");
		System.out.print("\n输入：");
		int num = sc.nextInt();
		switch(num){
			case 1://登录
				logger();
				break;
			case 2://管理员
				manager();
				break;
			case 3://退出
				System.exit(0);
				break;
			default:
				System.out.print("没有此选项，");
		}
		menu();
	}
	//登录
	static void logger(){
		System.out.println("-------------------------------------------");
		System.out.print("卡号：");
		int num = sc.nextInt();
		System.out.print("密码：");
		String str = sc.next();
		boolean cardNo=true;
		boolean code=true;
		for(int i=0;i<bank.length;i++){
			if(bank[i]!=null){
				cardNo = (bank[i].setCardNo()==num);
				if(cardNo){
					code = (bank[i].setCode().equals(str));
					if(code){
						System.out.println("登陆成功！");
						menuLogger(i);
					}else{
						System.out.println("密码错误！请重新输入：");
						logger();
					}
				}
			}
		}
		System.out.println("没有此卡信息！");
		logger();
	}
	//登录菜单
	static void menuLogger(int k){
		System.out.println("-------------------------------------------");
		System.out.println("请选择：");
		System.out.println("1.查看账户信息");
		System.out.println("2.存钱");
		System.out.println("3.取钱");
		System.out.println("4.转账");
		System.out.println("5.修改密码");
		System.out.println("6.退出登录");
		System.out.print("\n输入：");
		int num = sc.nextInt();
		switch(num){
			case 1://查看账户信息
				meinAccount(k);
				break;
			case 2://存钱
				System.out.println("-------------------------------------------");
				System.out.print("存款");
				moneySaveTake(k,1);
				break;
			case 3://取钱
				System.out.println("-------------------------------------------");
				System.out.print("取款");
				moneySaveTake(k,0);
				break;
			case 4://转账
				transferAccounts(k);
				break;
			case 5://修改密码
				changeCode(k,1);
				break;
			case 6://退出登录
				menu();
				break;
			default:

		}
	}
	//查看账户信息
	static void meinAccount(int k){
		bank[k].com();
		hint();
		menuLogger(k);
	}
	//存钱&取钱
	static void moneySaveTake(int k,int m){
		System.out.print("金额：");
		int num = sc.nextInt();
		if(m==1){
			bank[k].getMoney(bank[k].setMoney()+num);
		}else if(m==0){
			bank[k].getMoney(bank[k].setMoney()-num);
		}
		System.out.println("操作成功！是否继续？\n1.是\n2.其它任意值返回上级菜单");
		int num2 = sc.nextInt();
		if(num2==1){
			moneySaveTake(k,m);
		}else{
			menuLogger(k);
		}
	}
	//转账
	static void transferAccounts(int k){
		System.out.println("-------------------------------------------");
		System.out.print("请输入转入账户卡号：");
		int cardNo = sc.nextInt();
		System.out.print("转入金额：");
		int money = sc.nextInt();
		if(cardNo==bank[k].setCardNo()){
			System.out.println("请不要输入当前卡号！");
			transferAccounts(k);
		}
		for(int i=0;i<bank.length;i++){
			if(bank[i]!=null&&bank[i].setCardNo()==cardNo){
				bank[i].getMoney(bank[i].setMoney()+money);
				bank[k].getMoney(bank[k].setMoney()-money);
				System.out.println("-------------------------------------------");
				System.out.println("操作成功！是否继续？\n1.是\n2.其它任意值返回上级菜单");
				int num2 = sc.nextInt();
				if(num2==1){
					transferAccounts(k);
				}else{
					menuLogger(k);
				}
				break;
			}
		}
		System.out.println("没有此卡号信息！");
		transferAccounts(k);
	}
	//管理员
	static void manager(){
		System.out.println("-------------------------------------------");
		System.out.print("请输入管理员密码：");
		String str = sc.next();
		if(adminCode.equals(str)){
			menuManager();
		}else{
			System.out.println("密码错误！");
			manager();
		}
		
		
	}
	//管理员菜单
	static void menuManager(){
		System.out.println("-------------------------------------------");
		System.out.println("请选择：");
		System.out.println("1.查看银行所有账户");
		System.out.println("2.修改管理员密码");
		System.out.println("3.退出管理员");
		System.out.print("\n输入：");
		int num = sc.nextInt();
		switch(num){
			case 1://查看银行所有账户
				allAccount();
				hint();
				menuManager();
				break;
			case 2://修改管理员密码
				changeCode(0,0);
				break;
			case 3://退出管理员
				menu();
				break;
			default:
				System.out.println("没有此选项");
				menuManager();
		}
	}
	//所有账户信息
	static void allAccount(){
		for (int i = 0;i<bank.length;i++){
			if(bank[i]!=null){
				bank[i].com();
			}
		}
	}
	//修改密码 
	static void changeCode(int k,int m){
		System.out.println("-------------------------------------------");
		System.out.print("当前密码：");
		String str1 = sc.next();
		System.out.print("新的密码：");
		String str2 = sc.next();
		System.out.print("确认密码：");
		String str3 = sc.next();
		boolean bStr1=true;
		boolean bStr2=true;
		if(m==1){
			bStr1 = (str1.equals(bank[k].setCode()));
		}else if(m==0){
			bStr1 = (str1.equals(adminCode));
		}
		bStr2 = (str2.equals(str3));
		if(bStr1){
			if(bStr2){
				if(m==1){
					/**
					错误！！！
					
					*/
					bank[k].getCode(str2);
				}else if(m==0){
					adminCode = str2;
				}
			}
			else{
				System.out.println("新密码与确认密码不一致，请重新输入！");
				changeCode(k,m);
			}
		}else{
			System.out.println("当前密码错误，请重新输入!");
			changeCode(k,m);
		}
		System.out.println("修改成功!");
		hint();
		if(m==1){
			menuLogger(k);
		}else{
			menuManager();
		}
	}
	//返回上级菜单提示
	static void hint(){
		System.out.println("-------------------------------------------");
		System.out.println("任意值返回上级菜单！");
		String str = sc.next();
	}
}