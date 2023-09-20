package com.shinhan.model;

import java.util.List;

import com.shinhan.dto.DeptVO;

//Service : 비지니스로직 담당
public class DeptService {
	DeptDAO dao = new DeptDAO();
	//특정Location
	public List<DeptVO> selectByLocation(int loc) {
		return dao.selectByLocation(loc);		
	}
	//특정Manager
	public List<DeptVO> selectByManager() {
		return dao.selectByManager();		
	}
	//특정부서
	public DeptVO selectById(int deptid) {
		return dao.selectById(deptid);
	}
	//all
	public List<DeptVO> selectAll() {
		return dao.selectAll();	
	}
}
