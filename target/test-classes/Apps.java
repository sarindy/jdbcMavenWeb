

import businessLogic.UserSecurity.LoginLogic;

public class Apps {

	public static void main(String[] args) {
		LoginLogic loginLogic = new LoginLogic("dy", "ouk sarindy");
		System.out.println(loginLogic.isLoginSucess());

	}

}
