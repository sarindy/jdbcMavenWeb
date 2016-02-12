package businessLogicAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnectionManager.DbConnectionManager;
import dbConnectionManager.DbUtilities;
import objModelAccount.Account;

public class businessAccount {
	private List<Account> accountList;

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public businessAccount() {
		Connection conn = DbConnectionManager.getConnection();

		PreparedStatement prepareStatement = null;
		String selectSQL = "SELECT * FROM ACCOUNT";

		try {

			prepareStatement = conn.prepareStatement(selectSQL);
			// prepareStatement.setString(1, loginName);// 1 is the index of the
			// parameter and
			// custAcctid is the
			// parameter
			// prepareStatement.setString(2, password);
			ResultSet rs = prepareStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				System.out.println("No data");
				DbUtilities.closeResultSet(rs);
				DbUtilities.closeStatment(prepareStatement);
				DbUtilities.closeConnection(conn);
			} else {

				List<Account> accountList = new ArrayList<Account>();
				while (rs.next()) {
					accountList.add(new Account(rs.getString("ACCOUNT_NO"), rs
							.getString("NAME"), rs.getString("ACCT_TYPE"), rs
							.getDouble("BALANCE")));
				}

				this.accountList = accountList;

				DbUtilities.closeResultSet(rs);
				DbUtilities.closeStatment(prepareStatement);
				DbUtilities.closeConnection(conn);

			}

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}
	
	
	

}
