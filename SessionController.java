package shuben;

import java.awt.List;

public class SessionController{
	private String systemPassword="123456";
	Session session = new Session();
	public Session adminLogin(String passWord) {
		if(systemPassword.equals(passWord)) {
		return session;
		}
		else {
			return null;
		}
	}
}
