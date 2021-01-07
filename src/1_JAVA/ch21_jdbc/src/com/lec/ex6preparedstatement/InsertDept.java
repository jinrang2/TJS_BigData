package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.lec.db.DBInfo;

public class InsertDept {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		System.out.println("추가할 부서 번호는?");
		int deptno  = scanner.nextInt();
		System.out.println("추가할 부서 이름은?");
		String dname  = scanner.next();
		System.out.println("추가할 부서 번호는?");
		scanner.nextLine();
		String loc   = scanner.nextLine();
		
		String sql = "INSERT INTO DEPT VALUES (?,?,?)";
		
		Connection			conn = null;
		PreparedStatement	pstmt = null;
		
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID, DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
