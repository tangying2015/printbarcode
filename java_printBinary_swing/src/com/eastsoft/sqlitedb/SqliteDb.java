package com.eastsoft.sqlitedb;
/**
 * 编码修改为UTF-8
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteDb {
	private static final String DB_NAME = "AidPasswd.db";
	private static final String connectionUrl = "jdbc:sqlite:"+DB_NAME;
	private static final String TABLE_NAME = "Table_AidPasswd";
	
	public Connection conn = null;
	private Statement stat = null;
	private ResultSet rs = null;

	public SqliteDb() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");    
        conn = DriverManager.getConnection(connectionUrl);    
        //建立事务机制,禁止自动提交，设置回滚点    
        conn.setAutoCommit(false);  
        stat = conn.createStatement();   
        ResultSet rsTables = conn.getMetaData().getTables(null,null,TABLE_NAME,null);
        if(rsTables.next()){  
            System.out.println("表存在,创建表的事情不要做了");  
        } else {  
        	stat.executeUpdate("create table "+TABLE_NAME+"(aid TEXT primary key, passwd TEXT);"); 
        	conn.commit();
        }  
        close();
	}

	public boolean connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(connectionUrl);
			conn.setAutoCommit(false);  
			stat = conn.createStatement();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (stat != null)
			try {
				stat.close();
			} catch (Exception e) {
			}
		
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
			}
	}

	
	public  void insert(String aid,String passwd) throws SQLException {
			String sql = "insert into "+TABLE_NAME+" values ("+aid+","+passwd+");";
			stat.executeUpdate(sql);
			conn.commit();  
	}
	public  String getPasswdFromAid(String aid) throws SQLException{
			String sql = "select * from "+TABLE_NAME+" where aid="+aid;
			ResultSet rsTables = stat.executeQuery(sql);
			while(rsTables.next()){
				String passwd = rsTables.getString("passwd");
				return passwd;
			}
			return null;
	}
	public  boolean isAidExist(String aid) throws SQLException{
			String sql = "select * from "+TABLE_NAME+" where aid="+aid;
			ResultSet rsTables = stat.executeQuery(sql);
			while(rsTables.next()){
				return true;
			}
			return false;
	}
	
	public static void main(String[] args) throws SQLException {
		SqliteDb db = null;
		try {
			db = new SqliteDb();
			db.connect();
			//db.insert("3388991234", "1234");
			if(!db.isAidExist("3388991234")){
				db.insert("3388991234","1234");
			}
			if(!db.isAidExist("3388991235")){
				db.insert("3388991235", "1235");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			db.close();
			e.printStackTrace();
		}
		
		//db.insert("3388991236", "1236");
		//db.insert("3388991237", "1237");
	}
}
