package dbConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dbConfig.DbConfig;



public class DbConnectionManager {
private static final String CONFIG_FILENAME = "DbConfig.xml";
	
	DbConfig config=new DbConfig(CONFIG_FILENAME);
	
	public static Connection getConnection(){
		DbConnectionManager connection=new DbConnectionManager();
		return connection.getDataSource();
	}
	
	private Connection getDataSource(){
        try{
        	Class.forName(config.getDbDriverName());
            try{
                Connection conn = DriverManager.getConnection(config.getDbUri(), config.getDbUserName(), config.getDbPassword());
                if (conn != null){
                    return conn;   
                }
            }catch(SQLException sqlEx){
                System.out.println(sqlEx);
            }
        }catch(ClassNotFoundException cnfEx){
            System.out.println(cnfEx);
        }
        return null;
    }

}
