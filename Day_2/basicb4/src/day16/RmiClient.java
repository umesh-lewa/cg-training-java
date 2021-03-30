package day16;

import java.rmi.Naming;

public class RmiClient {
	
	public static void main(String[] args) throws Exception{
		
		Stock stock=(Stock)Naming.lookup("rmi://localhost:1099/rmiservice/stockService");
		
		int price=stock.getStockPrice("coda");
		
		System.out.println("The stock price of coda is...:"+price);
		
	}
	
}
