import java.util.Scanner;

public class BankSystemApplication {

	public static void main(String[] args) {
		ClientInfo client = new ClientInfo();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name of the client: ");
		String name= scan.nextLine();
		client.setClient_name(name);
		System.out.println("Enter the job of the client: ");
		String job= scan.nextLine();
		client.setClient_job(job);
		
		System.out.println("Enter your account balance of the client: ");
		double account_balance= scan.nextDouble();
		client.setAccount_balance(account_balance);
		
		System.out.println("Client Information is: "+"Client name is: "+client.getClient_name()+" ,and his job is: "+client.getClient_job()+" ,account balance  : "+client.getAccount_balance());
		
		System.out.println();
		System.out.println("to deposit enter amount: ");
		double amount= scan.nextDouble();
		client.deposit(amount);
		
		System.out.println("to withdrawal enter amount: ");
		double amountWithdawal= scan.nextDouble();
		client.withdrawal(amountWithdawal);
		client.balance_inquiry();

		System.out.println("to calculate the interest of amount of money in specific time: ");
		
		System.out.println("enter amount to calculate interest: ");
		double amountOfInterest= scan.nextDouble();
		
		System.out.println("enter time to calculate interest: ");
		double time= scan.nextDouble();
		
		System.out.println("enter rate to calculate interest: ");
		float rate= scan.nextFloat();
		InterestImplementation interest = new InterestImplementation();
		interest.interestCalculations(rate, time, amountOfInterest);
	}

}
