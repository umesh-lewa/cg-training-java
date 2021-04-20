package compkeypack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class CompClient {
	public static void main(String[] args) {
		ItemTrans it=new ItemTrans();
		
		CompKey ck=new CompKey();
		ck.setInv_id(1001);
		ck.setItem_id(200);
		
		it.setCompKey(ck);
		it.setQty(20);
		
		Session session=HibernateUtility.getSession();
		session.save(it);
		HibernateUtility.closeSession(null);
	}
}
