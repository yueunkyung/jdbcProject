package com.shinhan.test;

import java.sql.*;

import com.shinhan.util.DBUtil;

public class DBConnectionTest2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st =null;
		ResultSet rs = null;
		String sql = "select employee_id, first_name, salary "
				+ "from employees "
				+ "where salary > 10000 "
				+ "order by 1";

		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int empid = rs.getInt(1);
				String fname = rs.getString(2);
				int sal = rs.getInt(3);
				System.out.println(empid + "\t" + fname + "\t" + sal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnection(conn, st, rs);
		}
	}

}
