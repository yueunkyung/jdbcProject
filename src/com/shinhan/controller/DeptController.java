package com.shinhan.controller;

import java.util.List;
import java.util.Scanner;

import com.shinhan.dto.DeptVO;
import com.shinhan.model.DeptService;
import com.shinhan.view.DeptView;

public class DeptController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DeptService service = new DeptService();
		boolean isRun = true;
		while (isRun) {
			menu();
			int job = sc.nextInt();
			switch (job) {
			case 1: {
				List<DeptVO> dlist = service.selectAll();
				DeptView.print(dlist);
				break;
			}
			case 2: {
				System.out.print("deptid>>");
				int deptid = sc.nextInt();
				DeptVO dept = service.selectById(deptid);
				DeptView.print(dept);
				break;
			}
			case 3: {
				List<DeptVO> dlist = service.selectByManager();
				DeptView.print(dlist);
				break;
			}
			case 4: {
				System.out.print("loc>>");
				int loc = sc.nextInt();
				List<DeptVO> dlist = service.selectByLocation(loc);
				DeptView.print(dlist);
				break;
			}
			case 9:
				isRun = false;
				break;
			default:
				break;
			}

		}
		DeptView.print("프로그램종료");

	}

	private static void menu() {
		System.out.println("1.모두조회");
		System.out.println("2.특정부서 상세조회");
		System.out.println("3.manager가 있는 부서조회");
		System.out.println("4.특정Location 있는 부서조회");
		System.out.println("9.exit");
		System.out.print("작업선택>>");

	}

}
