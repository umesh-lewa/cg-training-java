package collectionLabBook;

import java.util.HashMap;
import java.util.Map;

public class Q4 {

}


class AccountManager {
	
private Map accountTotals = new HashMap();
private int retirementFund;

public int getBalance(String accountName) {
	
Integer total = (Integer) accountTotals.get(accountName);

if (total == null)
total = Integer.valueOf(0);

return total.intValue();

}
public void setBalance(String accountName, int amount) {
	
accountTotals.put(accountName, Integer.valueOf(amount));

} 

}
