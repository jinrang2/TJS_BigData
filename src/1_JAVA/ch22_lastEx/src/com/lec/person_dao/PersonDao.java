package com.lec.person_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import com.lec.att.DBInfo;

public class PersonDao {
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	
	private static PersonDao INSTANCE;		
	public static PersonDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonDao(); 
		}
		
		return INSTANCE;
	}
	
	private PersonDao() {
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1¹ø insertPerson(PersonDto dto)
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		
		String sql = "INSERT INTO PERSON VALUES " +
				" (SEQ_PERSON_NO.NEXTVAL, ?, " +
				" (SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}	
		
		return  result;
	}
	
	public ArrayList<PersonDto> selectJname(String jname){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT ROWNUM AS RANK, A.* " + 
				"FROM " + 
				"( " + 
				"    SELECT NAME ||'(' || NO || '¹ø)' AS NAME ,  " + 
				"           JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
				"      FROM PERSON P, JOB J " + 
				"     WHERE P.JNO = J.JNO AND JNAME=?" + 
				"     ORDER BY SUM DESC" + 
				") A";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				
				dtos.add(new PersonDto(rank, name, jname, kor, eng, mat, sum));
			}
			
		} catch (Exception e) {
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
		
		return dtos;	
	}
	
	public ArrayList<PersonDto> selectAll(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT ROWNUM AS RANK, A.* " + 
				"FROM " + 
				"( " + 
				"    SELECT NAME ||'(' || NO || '¹ø)' AS NAME ,  " + 
				"           JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
				"      FROM PERSON P, JOB J " + 
				"     WHERE P.JNO = J.JNO " + 
				"     ORDER BY SUM DESC" + 
				") A";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				
				dtos.add(new PersonDto(rank, name, jname, kor, eng, mat, sum));
			}
			
		} catch (Exception e) {
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
		
		return dtos;	
	}
	
	public Vector<String> selectJname(){
		Vector<String> jnames = new Vector<String>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT JNAME FROM JOB";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
			
		} catch (Exception e) {
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
		
		return jnames;	
	}
}
