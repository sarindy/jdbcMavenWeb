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

public class BusinessAccountWithSP {
	private List<Account> accountList;
	private String acctType;
	private Double balance;
	

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	

	public BusinessAccountWithSP(String acctType, Double balance) {
		
		String SPsql = "EXEC getBalanceEqu ?,?";
		
		Connection conn = DbConnectionManager.getConnection();

		PreparedStatement prepareStatement = null;
		
		try {

			prepareStatement = conn.prepareStatement(SPsql);
			 prepareStatement.setDouble(1, balance);// 1 is the index of the
			 prepareStatement.setString(2, acctType);
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
							.getDouble("BALANCES")));
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	
	

}
