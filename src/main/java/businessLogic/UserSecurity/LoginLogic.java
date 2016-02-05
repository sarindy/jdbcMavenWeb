package businessLogic.UserSecurity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnectionManager.DbConnectionManager;
import dbConnectionManager.DbUtilities;

public class LoginLogic {

	private String loginName;
	private String password;
	private boolean loginSucess;

	public LoginLogic(String loginName, String password) {

		this.loginName = loginName;
		this.password = password;
		Process();
	}

	public boolean isLoginSucess() {
		return loginSucess;
	}

	private void Process() {
		Connection conn = DbConnectionManager.getConnection();

		PreparedStatement prepareStatement = null;
		String selectSQL = "SELECT USER_ID,USER_NAME FROM USERS WHERE USER_ID= ? AND USER_NAME=?";

		try {

			prepareStatement = conn.prepareStatement(selectSQL);
			prepareStatement.setString(1, loginName);// 1 is the index of the
														// parameter and
														// custAcctid is the
														// parameter
			prepareStatement.setString(2, password);
			ResultSet rs = prepareStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				System.out.println("No data");
				DbUtilities.closeResultSet(rs);
				DbUtilities.closeStatment(prepareStatement);
				DbUtilities.closeConnection(conn);
			} else {
				DbUtilities.closeResultSet(rs);
				DbUtilities.closeStatment(prepareStatement);
				DbUtilities.closeConnection(conn);

				loginSucess = true;
			}

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}
}
