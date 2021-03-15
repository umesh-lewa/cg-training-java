package lab6;

public class Q45 {

}

class BankAccount{
	
	private String depositor = "default";
	private int accountNumber = 0;
	private String typeOfAcount = "default";
	private int balance = 0;
	
	public void checkBalanceAndDeposit(int depositAmount) {
		
		int currentBalance = this.balance;
		
		this.balance = this.balance + depositAmount;
		
	}
	
	public void displayNameAndBalance() {
		
		System.out.println("Name : "+this.depositor);
		System.out.println("Balance : "+this.balance);
	}
	
}
