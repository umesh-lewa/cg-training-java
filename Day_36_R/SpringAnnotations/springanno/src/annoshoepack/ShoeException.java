package annoshoepack;

public class ShoeException extends Exception{
	String msg;
	public ShoeException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception is...:"+msg;
	}
}
