package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lec.db.DBInfo;

// 삭제할 부서번호을 입력받기
// 2-1 입력한 부서 번호가 있을 경우 진짜 xx번 부서를 삭제하시겟습니까
// 2-1-1 Y:삭제 -> 삭제 완료 메세지
// 그외 삭제 안하고 종료
// 2-2 입력한 부서번호가 없으면 없다고 하고 종료
public class DeleteDept2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 부서 번호는 ?");
		int deptno = sc.nextInt();
		
		String sql= "SELECT DEPTNO FROM DEPT WHERE DEPTNO=?";
		String sql2= "DELETE FROM DEPT WHERE DEPTNO=?";
		
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID, DBInfo.ORACLE_PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				System.out.printf("진짜 %d번 부서를 삭제하시겠습니까? (Y:삭제 / 그 외: 취소)",deptno);
				String yn = sc.next();
				
				if (yn.equalsIgnoreCase("y")) {
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(sql2);
					pstmt.setInt(1, deptno);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "부서 삭제 성공" : "부서 삭제 실패");
				}
				
				
			} else {
				System.out.println("입력한 부서가 없습니다 입력이 불가합니다.");
			}
			
			

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}  catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)			rs.close();
				if (pstmt != null)		pstmt.close();
				if (conn != null)		conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
}
