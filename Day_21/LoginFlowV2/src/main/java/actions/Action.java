package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Action {
	
	abstract String execute(HttpServletRequest request, HttpServletResponse response);
}
