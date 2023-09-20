package com.shinhan.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.DeptVO;
import com.shinhan.util.DBUtil;

//DAO(Data Access Object)
public class DeptDAO {
	Connection conn;
	Statement st;
	ResultSet rs;
	
	//특정 Location 조회
	public List<DeptVO> selectByLocation(int loc) {
		List<DeptVO> deptlist = new ArrayList<>();
		String sql = "select * from departments "
				+ " where location_id = " + loc;
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptVO dept = makeDept(rs);//reset에서 읽어서 VO만들기
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return deptlist;
	}
	
	//Manager가 있는 부서조회
	public List<DeptVO> selectByManager() {
		List<DeptVO> deptlist = new ArrayList<>();
		String sql = "select * from departments where manager_id is not null";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptVO dept = makeDept(rs);//reset에서 읽어서 VO만들기
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return deptlist;
	}

	//특정부서조회
	public DeptVO selectById(int deptid) {
		DeptVO dept = null;
		String sql = "select * from departments "
				+ " where department_id = " + deptid;
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				dept = makeDept(rs);//reset에서 읽어서 VO만들기				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return dept;
	}
	
	//모두조회
	public List<DeptVO> selectAll() {
		List<DeptVO> deptlist = new ArrayList<>();
		String sql = "select * from departments";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptVO dept = makeDept(rs);//reset에서 읽어서 VO만들기
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return deptlist;
	}
	
	private DeptVO makeDept(ResultSet rs) throws SQLException {
		DeptVO dept = new DeptVO();
		dept.setDepartment_id( rs.getInt(1));
		dept.setDepartment_name(rs.getString(2));
		dept.setLocation_id(rs.getInt(3));
		dept.setManager_id(rs.getInt(4));
		return dept;
	}
}