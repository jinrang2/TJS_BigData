package com.lec.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import com.lec.att.DBInfo;

public class StudentDao {
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	
	private static StudentDao INSTANCE;		
	public static StudentDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao(); 
		}
		
		return INSTANCE;
	}
	
	private StudentDao() {
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
	
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		
		String sql = "INSERT INTO STUDENT VALUES (?,?," +
				" (SELECT MNO FROM MAJOR WHERE MNAME=?),?,?)";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSno());
			pstmt.setString(2, dto.getSname());
			pstmt.setString(3, dto.getMname());
			pstmt.setInt(4, dto.getScore());
			pstmt.setInt(5, dto.getSexpel());
			
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
		
	public ArrayList<StudentDto> selectTopnByMname(String mname){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT ROWNUM||'µî' RANK, A.* " + 
				"FROM (" + 
				"    SELECT SNAME||'('||SNO||')' AS NAMENO, MNAME, SCORE" + 
				"    FROM STUDENT S, MAJOR M" + 
				"    WHERE S.MNO = M.MNO AND M.MNO=(SELECT MNO FROM MAJOR WHERE MNAME=?) " + 
				"    ORDER BY SCORE DESC" + 
				") A";
		
		//System.out.println(sql);
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String rank = rs.getString("rank");
				String nameno = rs.getString("nameno");
				int score = rs.getInt("score");
				
				student.add(new StudentDto(rank, nameno, mname, score));
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
		
		return student;
	}
	
	public ArrayList<StudentDto> selectTopnByEx(int sExpel){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT ROWNUM||'µî' RANK, A.* " + 
					"FROM ( " + 
					"    SELECT SNAME||'('||SNO||')' AS NAMENO, MNAME, SCORE " + 
					"    FROM STUDENT S, MAJOR M " + 
					"    WHERE S.MNO = M.MNO " + 
					"      AND SEXPEL=? " + 
					"    ORDER BY SCORE DESC " + 
					") A";
		
		//System.out.println(sql);
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sExpel);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String rank = rs.getString("rank");
				String nameno = rs.getString("nameno");
				String mname = rs.getString("mname");				
				int score = rs.getInt("score");
				
				student.add(new StudentDto(rank, nameno, mname, score));
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
		
		return student;
	}
	
	public ArrayList<StudentDto> selectStudentBySno(String sno){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT SNO, SNAME, MNAME, SCORE, SEXPEL " + 
				"    FROM STUDENT S, MAJOR M " + 
				"    WHERE S.MNO = M.MNO AND SNO=?" ;
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");				
				int score = rs.getInt("score");
				int sexpel = rs.getInt("sexpel");
				
				student.add(new StudentDto(sno, sname , mname, score, sexpel));
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
		
		return student;
	}
	
	public ArrayList<StudentDto> selectStudentBySname(String sname){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT SNO, SNAME, MNAME, SCORE, SEXPEL " + 
				"    FROM STUDENT S, MAJOR M " + 
				"    WHERE S.MNO = M.MNO AND SNAME=?" ;
		
		System.out.println(sql);
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sno = rs.getString("sno");
				String mname = rs.getString("mname");				
				int score = rs.getInt("score");
				int sexpel = rs.getInt("sexpel");
				
				student.add(new StudentDto(sno, sname , mname, score, sexpel));
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
		
		return student;
	}
	
	public ArrayList<StudentDto> selectStudentByMname(String mname){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT SNO, SNAME, MNAME, SCORE, SEXPEL " + 
				"    FROM STUDENT S, MAJOR M " + 
				"    WHERE S.MNO = M.MNO AND MNAME=?" ;		
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				int score = rs.getInt("score");
				int sexpel = rs.getInt("sexpel");
				
				student.add(new StudentDto(sno, sname , mname, score, sexpel));
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
		
		return student;
	}
	
	public int updateStudent(StudentDto dto) {
		int result = FAIL;
	
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		
		String sql = "UPDATE STUDENT " + 
				"   SET SNAME=? , MNO=(SELECT MNO FROM MAJOR WHERE MNAME=?), " + 
				"                   SCORE=?, SEXPEL=? " + 
				" WHERE SNO=? ";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setInt(4, dto.getSexpel());
			pstmt.setString(5, dto.getSno());
			
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
	
	public int updateExpel(String sno) {
		int result = FAIL;
	
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		
		String sql = "UPDATE STUDENT " + 
				"   SET SEXPEL=1 " +
				" WHERE SNO=? ";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			
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
	
	public ArrayList<StudentDto> selectStudentAll(){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT SNO, SNAME, MNAME, SCORE, SEXPEL " + 
				"    FROM STUDENT S, MAJOR M " +
				"   WHERE S.MNO = M.MNO " +
				"    ORDER BY SCORE DESC" ;		
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				int sexpel = rs.getInt("sexpel");
				
				student.add(new StudentDto(sno, sname , mname, score, sexpel));
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
		
		return student;
	}
	
	public Vector<String> selectMname(){
		Vector<String> mnames = new Vector<String>();
		
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		
		String sql = "SELECT MNAME FROM MAJOR";
		
		try {
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
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
		
		return mnames;	
	}
}
