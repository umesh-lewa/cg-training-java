package day14;

import java.util.HashMap;
import java.util.Map;

public class WeakHashdemo {

	
	public static void main(String args[]) {
		
		Emp e1 = new Emp(1);
		Emp e2 = new Emp(2);
		Emp e3 = new Emp(3);
		
		Map<Emp,String> map = new HashMap<Emp,String>();
		map.put(e1, "Ramesh");
		map.put(e2, "Suresh");
		map.put(e3, "Dinesh");
	}
	
}

class Emp implements Comparable<Emp>{

	Integer eid;
	
	Emp(Integer eid){
		this.eid = eid;
	}
	
	@Override
	public int compareTo(Emp o) {
		// TODO Auto-generated method stub
		return eid.compareTo(o.eid);
	}
	
}
