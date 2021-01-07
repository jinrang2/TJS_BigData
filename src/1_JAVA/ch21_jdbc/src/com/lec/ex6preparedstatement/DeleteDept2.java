package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lec.db.DBInfo;

// ������ �μ���ȣ�� �Է¹ޱ�
// 2-1 �Է��� �μ� ��ȣ�� ���� ��� ��¥ xx�� �μ��� �����Ͻðٽ��ϱ�
// 2-1-1 Y:���� -> ���� �Ϸ� �޼���
// �׿� ���� ���ϰ� ����
// 2-2 �Է��� �μ���ȣ�� ������ ���ٰ� �ϰ� ����
public class DeleteDept2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� �μ� ��ȣ�� ?");
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
				
				System.out.printf("��¥ %d�� �μ��� �����Ͻðڽ��ϱ�? (Y:���� / �� ��: ���)",deptno);
				String yn = sc.next();
				
				if (yn.equalsIgnoreCase("y")) {
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(sql2);
					pstmt.setInt(1, deptno);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "�μ� ���� ����" : "�μ� ���� ����");
				}
				
				
			} else {
				System.out.println("�Է��� �μ��� �����ϴ� �Է��� �Ұ��մϴ�.");
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
