package com.lec.mart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.Vector;

import javax.security.auth.login.FailedLoginException;

import com.lec.att.DBInfo;
import com.lec.student.StudentDto;

public class CustomerDao {
	private Connection conn			= null;
	private PreparedStatement pstmt	= null; 
	private ResultSet rs			= null;
	
	private static CustomerDao INSTANCE;
	
	public static CustomerDao getInstance() {
		if( INSTANCE == null) {
			INSTANCE = new CustomerDao();
		}
		
		return INSTANCE;
	}
		
	private CustomerDao() {
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public Vector<String> selectLevelNames() {
		Vector<String> levelNames = new Vector<String>();
		
		Connection conn			= null;
		PreparedStatement pstmt	= null; 
		ResultSet rs			= null;
		
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL ORDER BY LEVELNO";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String levelName = rs.getString("levelname");
				
				levelNames.add(levelName);
			}
			
		}  catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return levelNames;
	}
		
	private void doSelect(String sql, ArrayList<String> wheres, ArrayList<CustomerDto> customers){
		ArrayList<String> results = new ArrayList<String>();
		
		sql.replace("\r\n", "");
		int select = sql.indexOf("SELECT");
		int from = sql.indexOf("FROM");
		int colCnt = 0;
		
		String[] arr = sql.substring(select+7,from).split(",");
				
		colCnt = arr.length;		
				
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			
			//System.out.println(wheres.size());
			
			for(int i=0 ; i < wheres.size() ; i++) {
				pstmt.setString(i+1, wheres.get(i));
			}
						
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				results.clear();
				
				for (int i=0; i<colCnt ; i++) {
					//System.out.println(rs.getString(i+1));
					results.add(rs.getString(i+1));
				}
				
				customers.add(new CustomerDto(results));
			}
		}  catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	private int doInsertUpdate(String sql, ArrayList<String> wheres){
		int result = CustomerDto.FAIL;
		ArrayList<String> results = new ArrayList<String>();
						
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0 ; i < wheres.size() ; i++) {
				pstmt.setString(i+1, wheres.get(i));
			}
						
			result = pstmt.executeUpdate();
		
		}  catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
	}
	
	public ArrayList<CustomerDto> selectById(String cID){
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		ArrayList<String> sqlArgs = new ArrayList<String>();
		
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, NEXT \r\n" + 
				"  FROM VW_PRINT WHERE CID=?";
		
		sqlArgs.add(cID);
		
		doSelect(sql,sqlArgs, customers);
		
		return customers;
	}
	
	public ArrayList<CustomerDto> selectByTel(String cTel){
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		ArrayList<String> sqlArgs = new ArrayList<String>();
		
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, NEXT \r\n" + 
				"  FROM VW_PRINT WHERE CTEL LIKE '%'||?";
		
		sqlArgs.add(cTel);
		
		doSelect(sql,sqlArgs, customers);
		
		return customers;
	}
	
	public ArrayList<CustomerDto> selectByName(String cName){
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		ArrayList<String> sqlArgs = new ArrayList<String>();
		
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, NEXT \r\n" + 
				"  FROM VW_PRINT WHERE CNAME = ?";
		
		sqlArgs.add(cName);
		
		doSelect(sql,sqlArgs, customers);
		
		return customers;
	}
	
	public ArrayList<CustomerDto> selectByLevelName(String levelName){
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		ArrayList<String> sqlArgs = new ArrayList<String>();
		
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, NEXT  \r\n" + 
				"  FROM VW_PRINT WHERE LEVELNAME=?";
		
		sqlArgs.add(levelName);
		
		doSelect(sql,sqlArgs, customers);
		
		return customers;
	}
	
	public ArrayList<CustomerDto> selectByAll(){
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		ArrayList<String> sqlArgs = new ArrayList<String>();
		
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, NEXT  \r\n" + 
				"  FROM VW_PRINT";
				
		doSelect(sql,sqlArgs, customers);
		
		return customers;
	}
	
	public int buyPoint(String price, String cid) {
		ArrayList<String> sqlArgs = new ArrayList<String>();		
		
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT - ? WHERE CID=?";
		
		sqlArgs.add(price);
		sqlArgs.add(cid);
		
		return doInsertUpdate(sql, sqlArgs);		
	}
	
	public int buyCache(String price, String cid) {
		ArrayList<String> sqlArgs = new ArrayList<String>();		
		
		String sql = "UPDATE CUSTOMER A\r\n" + 
				"   SET CPOINT = CPOINT + ?*0.05, \r\n" + 
				"       CAMOUNT = CAMOUNT + ?,\r\n" + 
				"       LEVELNO = (SELECT LEVELNO \r\n" + 
				"                  FROM CUS_LEVEL \r\n" + 
				"                 WHERE A.CAMOUNT+? \r\n" + 
				"               BETWEEN LOW AND HIGH)\r\n" + 
				" WHERE CID=?";
		
		sqlArgs.add(price);
		sqlArgs.add(price);
		sqlArgs.add(price);
		sqlArgs.add(cid);
		
		return doInsertUpdate(sql, sqlArgs);		
	}
	
	public int joinCustomer(String cTel, String cName) {
		ArrayList<String> where = new ArrayList<String>();		
		
		String sql = "INSERT INTO CUSTOMER (CID,CTEL, CNAME ) " +
					 "VALUES (SEQ_CUSTOMER_CID.NEXTVAL, ?, ?) ";
		
		where.add(cTel);
		where.add(cName);		
		
		return doInsertUpdate(sql, where);		
	}
	
	public int updateTel(String cTel, String cid) {
		ArrayList<String> sqlArgs = new ArrayList<String>();		
		
		String sql = "UPDATE CUSTOMER SET CTEL=? WHERE CID=?";
		
		sqlArgs.add(cTel);
		sqlArgs.add(cid);		
		
		return doInsertUpdate(sql, sqlArgs);		
	}
	
	public int deleteCustomer(String cTel) {
		ArrayList<String> sqlArgs = new ArrayList<String>();		
		
		String sql = "DELETE CUSTOMER WHERE CTEL=?";
		
		sqlArgs.add(cTel);		
		
		return doInsertUpdate(sql, sqlArgs);		
	}
	
	
	
	
}
