package com.shinhan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String userid = "hr", password = "hr";
		Connection conn = null;
		Statement st = null;	//SQL문 보내기 통로
		ResultSet rs = null;	//select 결과 받기
		String sql = "select * "
				+ "from jobs "
				+ "where min_salary >= 10000 "
				+ "order by 1 asc";
		
		try {
			//1.driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.driver load");

			//2.connection
			conn = DriverManager.getConnection(url, userid, password);
			System.out.println("2.connection");
			
			//3.statement
			st = conn.createStatement();
			System.out.println("3.통로생성");
			
			//4.resultSet
			rs = st.executeQuery(sql);
			System.out.println("4.resultSet");
			
			while(rs.next()) {
				String jobId = rs.getString("JOB_ID");
				String jobTitle =rs.getString("JOB_TITLE"); 
				int maxSalary = rs.getInt("MIN_SALARY");
				int minSalary = rs.getInt("MAX_SALARY");
				System.out.println(jobId + "\t" + jobTitle + "\t" + maxSalary + "\t" + minSalary);
				//System.out.printf("%s --- %s --- %d --- %d\n",jobId, jobTitle, maxSalary, minSalary);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("---자원반납---");
		}
		
		
	}
	
	public static void f2(String[] args) {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String userid="hr", password="hr";
		Connection conn = null;	//연결
		Statement st = null;	//SQL문 보내기 통로
		ResultSet rs = null;	//select 결과 받기
		String sql = "select * from departments";
		try {
			//1.Driver Load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.Driver Load 성공");

			//2.Connection
			conn = DriverManager.getConnection(url, userid, password);
			System.out.println("2.Connection 성공");
			
			//3.Statement : 대화통로
			 st = conn.createStatement();
			System.out.println("3.Statement : 대화통로 생성 성공");
			
			//4.ResultSet
			 rs = st.executeQuery(sql);
			System.out.println("4.SQL문 실행 성공");
			
			while(rs.next()) {
				int a = rs.getInt(1);
				String b =rs.getString(2); 
				int c = rs.getInt(3);
				int d = rs.getInt(4);
				System.out.println(a+b+c+d);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("=========자원반납================================");
		}
	}
	
	public static void f1(String[] args) throws ClassNotFoundException, SQLException {
		//**실행시 DB연결하기
		//C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar
		//0.Library classpath에 추가
		//1.Driver Load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1.Driver Load 성공");
		//2.Connection
		//@localhost == @127.0.0.1
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String userid="hr", password="hr";
		Connection conn = DriverManager.getConnection(url, userid, password);
		System.out.println("2.Connection 성공");
		//3.Statement : 대화통로
		Statement st = conn.createStatement();
		System.out.println("3.Statement : 대화통로 만들기 성공");
		//4.ResultSet
		String sql = "select * from employees";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			int empid = rs.getInt(1);
			String fname = rs.getString("first_name");
			int salary = rs.getInt("salary");
			System.out.printf("%d --- %s --- %d\n",empid, fname, salary);
		}
		System.out.println("4.ResultSet의 data를 모두 출력하고 비움");		
		//5.자원반납
		rs.close();
		st.close();
		conn.close();
		System.out.println("5.자원반납 성공");
		

	}

}
