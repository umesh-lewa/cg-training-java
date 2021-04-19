package hellopack;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private int eid;
	private String ename;
	private String epass;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int eid, String ename, String epass) {
		this.eid = eid;
		this.ename = ename;
		this.epass = epass;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpass() {
		return epass;
	}
	public void setEpass(String epass) {
		this.epass = epass;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", epass=" + epass + "]";
	}
	
}
