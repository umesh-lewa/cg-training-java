package lab3;

public class Q46 {

	public static void main(String srga[]) {
		
		BankAccount1 acc = new BankAccount1(1002,"Savings",5000,"Surya");
	}
}

class BankAccount1{
	
	private String depositor = "default";
	private int accountNumber = 0;
	private String typeOfAcount = "default";
	private int balance = 0;
	
	BankAccount1(int accountNumber, String typeOfAccount, int balance, String depositor){
		
		this.accountNumber = accountNumber;
		this.typeOfAcount = typeOfAccount;
		this.balance = balance;
		this.depositor = depositor;
	}
	
	public void checkBalanceAndDeposit(int depositAmount) {
		
		int currentBalance = this.balance;
		
		this.balance = this.balance + depositAmount;
		
	}
	
	public void displayNameAndBalance() {
		
		System.out.println("Name : "+this.depositor);
		System.out.println("Balance : "+this.balance);
	}
	
}