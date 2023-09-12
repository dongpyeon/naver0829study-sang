package afterclass;

public class Account {
	String accountNo;
	String accountName;
	int money;
	
	public Account(String accountNo, String accountName, int money) {
		this.accountNo=accountNo;
		this.accountName=accountName;
		this.money=money;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public String getAccountName() {
		return accountNo;
	}
	public int getMoney() {
		return money;
	}
	
	//계좌가 정확한지 안한지에 대한 메소드 만들기
	public boolean isAccount(String accountNo)
	{
		if (accountNo.equals(this.accountNo))
		{
			return true;
		}else {
			return false;
		}
	}
	
	//예금
	public void AddMoney(int money) {
//		money+=this.money;
		this.money+=money;
	}
	//출금
	public void SubMoeny(int money) {
//		money-=this.money;
		this.money-=money;
	}
	
	//목록
	public void accountInfo() {
		System.out.println(accountNo+"\t"+accountName+"\t"+money);
	}
	
}
