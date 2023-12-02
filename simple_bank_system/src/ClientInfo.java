

public class ClientInfo {
	private String client_name;
	private String client_job;
	private double account_balance;
	public ClientInfo() {}
	public ClientInfo(String client_name, String client_job, double account_balance) {
		super();
		this.client_name = client_name;
		this.client_job = client_job;
		this.account_balance = account_balance;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_job() {
		return client_job;
	}
	public void setClient_job(String client_job) {
		this.client_job = client_job;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	
	//deposit function
	public void deposit(double amount) {
		account_balance += amount;
	}
	
	//withdrawal function
	public void withdrawal(double amount) {
		if(amount > account_balance) {
			System.out.println("Withdrawal amount exceeds account_balance");
			return;
		}else {
			account_balance -= amount;
		}
	}
	
	//balance inquiry
	public void balance_inquiry() {
		System.out.println("your balance inquiry is:  -->"+this.account_balance);
	}
	
	
	
	
	
}
