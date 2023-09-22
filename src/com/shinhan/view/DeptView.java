package com.shinhan.view;

import java.util.List;

import com.shinhan.dto.DeptVO;

//View : client 보여주는 역할, 웹에서 JSP로 작성(JSP/Servlet, Spring), 
//				SpringBoot(Backend) + ReactJS(Frontend)
public class DeptView {
	public static void print(String message) {
		System.out.println("--------------------");
		System.out.println(message);
		System.out.println("--------------------");
	}

	public static void print(DeptVO dept) {
		System.out.println("-----dept(1건)------");
		System.out.println(dept);
		System.out.println("--------------------");
	}

	public static void print(List<DeptVO> deptlist) {
		System.out.println("-----dept(여러건)------");
		deptlist.stream().forEach(dept -> {
			System.out.println(dept);
		});
		System.out.println("--------------------");
	}
}
