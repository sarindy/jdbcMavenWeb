package dbConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtilities {
	public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    /**
     * Close Statement
     * @param Statement st
     * @return
     */
    public static void closeStatment(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Close Connection
     * @param Connection conn
     * @return
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
