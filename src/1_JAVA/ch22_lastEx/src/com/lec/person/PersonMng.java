package com.lec.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.lec.att.DBConsolePrint;
import com.lec.att.DBInfo;

public class PersonMng {
	public static void main(String[] args) {
		Connection			conn	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rs		= null;
		String fn;
		Scanner scanner = new Scanner(System.in);

		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		do {
			System.out.print("1:입력 | 2: 직업별 출력 | 3: 전체출력 | 그외:종료> ");

			fn = scanner.next();

			switch (fn) {
			case "1" :		// 이름, 직업명, 국어, 영어, 수학을 입력받아 insert
				System.out.print("입력할 이름은 ?");
				String name = scanner.next();
				System.out.print("직업명은 ? (배우 | 가수)");
				String jname = scanner.next();
				System.out.print("국어 ?");
				int kor = scanner.nextInt();
				System.out.print("영어 ?");
				int eng = scanner.nextInt();
				System.out.print("수학 ?");
				int mat = scanner.nextInt();

				String sql1 = "INSERT INTO PERSON VALUES " +
						" (SEQ_PERSON_NO.NEXTVAL, ?, " +
						" (SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";

				try {
					conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, name);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
										
					int result = pstmt.executeUpdate();
					System.out.println(result >0 ? "입력 성공" : "입력 실패");

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
				break;
			case "2" :		// 이름, 직업명, 국어, 영어, 수학을 입력받아 insert
				System.out.print("조회할 직업은 ?");
				jname = scanner.next();
				String sql2 = "SELECT ROWNUM AS RANK, A.*\r\n" + 
						"FROM\r\n" + 
						"(\r\n" + 
						"    SELECT NAME ||'(' || NO || '번)' AS NAME , \r\n" + 
						"           JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM\r\n" + 
						"      FROM PERSON P, JOB J\r\n" + 
						"     WHERE P.JNO = J.JNO AND JNAME=?\r\n" + 
						"     ORDER BY SUM DESC\r\n" + 
						") A";
				
				try {
					conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1,  jname);
					rs = pstmt.executeQuery();
					
					DBConsolePrint dbcp = new DBConsolePrint();
					
					
					if(rs.next()) {
						dbcp.add(1, "등수");
						dbcp.add(2, "이름");
						dbcp.add(3, "직업");
						dbcp.add(4, "국어");
						dbcp.add(5, "영어");
						dbcp.add(6, "수학");
						dbcp.add(7, "총점");
						
						do {
							dbcp.add(1, rs.getInt("rank"));
							dbcp.add(2, rs.getString("name"));
							dbcp.add(3, rs.getString("jname"));
							dbcp.add(4, rs.getInt("kor"));
							dbcp.add(5, rs.getInt("eng"));
							dbcp.add(6, rs.getInt("mat"));
							dbcp.add(7, rs.getInt("sum"));
						} while (rs.next());
						
						dbcp.print();
						
					} else {
						System.out.println("해당 직업명의 사람이 없습니다");
					}					
				} catch (Exception e) {
					// TODO: handle exception
				}  finally {
					try {
						if(rs != null)		rs.close();
						if(pstmt != null)	pstmt.close();
						if(conn != null)	conn.close();
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
				}

				break;					
			case "3" :		// 이름, 직업명, 국어, 영어, 수학을 입력받아 insert
				String sql3 = "SELECT ROWNUM AS RANK, A.*\r\n" + 
						"FROM\r\n" + 
						"(\r\n" + 
						"    SELECT NAME ||'(' || NO || '번)' AS NAME , \r\n" + 
						"           JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM\r\n" + 
						"      FROM PERSON P, JOB J\r\n" + 
						"     WHERE P.JNO = J.JNO \r\n" + 
						"     ORDER BY SUM DESC\r\n" + 
						") A";
				
				try {
					conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
					pstmt = conn.prepareStatement(sql3);
					rs = pstmt.executeQuery();
					
					DBConsolePrint dbcp = new DBConsolePrint();
					
					if(rs.next()) {
						dbcp.add(1, "등수");
						dbcp.add(2, "이름");
						dbcp.add(3, "직업");
						dbcp.add(4, "국어");
						dbcp.add(5, "영어");
						dbcp.add(6, "수학");
						dbcp.add(7, "총점");
						
						do {
							dbcp.add(1, rs.getInt("rank"));
							dbcp.add(2, rs.getString("name"));
							dbcp.add(3, rs.getString("jname"));
							dbcp.add(4, rs.getInt("kor"));
							dbcp.add(5, rs.getInt("eng"));
							dbcp.add(6, rs.getInt("mat"));
							dbcp.add(7, rs.getInt("sum"));
						} while (rs.next());
						
						dbcp.print();
					} else {
						System.out.println("해당 직업명의 사람이 없습니다");
					}					
				} catch (Exception e) {
					// TODO: handle exception
				}  finally {
					try {
						if(rs != null)		rs.close();
						if(pstmt != null)	pstmt.close();
						if(conn != null)	conn.close();
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
				}
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("바이");

	}
}
