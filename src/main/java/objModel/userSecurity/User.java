package objModel.userSecurity;

public class User {
	private String userName;
	private String pwd;
	private String loginName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public User(String userName, String pwd, String loginName) {

		this.userName = userName;
		this.pwd = pwd;
		this.loginName = loginName;
	}
	
	

}
