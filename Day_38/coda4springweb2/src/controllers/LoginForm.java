package controllers;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
	
	@NotEmpty
	private String uname;
	
	@Size(min=1, max = 8)
	private String upass;

	public final String getUname() {
		return uname;
	}

	public final void setUname(String uname) {
		this.uname = uname;
	}

	public final String getUpass() {
		return upass;
	}

	public final void setUpass(String upass) {
		this.upass = upass;
	}
	
}
