package com.shinhan.controller;

import java.util.List;
import java.util.Scanner;

import com.shinhan.dto.DeptVO;
import com.shinhan.model.DeptService;
import com.shinhan.view.DeptView;

//프로그램 전체 제어 : Web(JSP + Spring포함)에서는 Servlet으로 작성할 예정
//JAVA로 UI 만든다면, swing, awt 이용... 현업에서 활용도 없음
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
			case 5: {
				System.out.print("입력할 부서번호 이름 매니저 부서위치>>");
				DeptVO dept = new DeptVO(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt());
				int count = service.insertDept(dept);
				DeptView.print(count>0?"insert성공":"insert실패");
				break;
			}
			case 6: {
				System.out.print("수정할 부서번호 이름 매니저 부서위치>>");
				DeptVO dept = new DeptVO(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt());
				int count = service.updateDept(dept);
				DeptView.print(count>0?"update성공":"update실패");
				break;
			}
			case 7: {
				System.out.print("삭제할 부서번호>>");
				int count = service.deleteDept(sc.nextInt());
				DeptView.print(count>0?"delete성공":"delete실패");
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
		System.out.println("5.입력");
		System.out.println("6.수정");
		System.out.println("7.삭제");
		System.out.println("9.exit");
		System.out.print("작업선택>>");
	}

}
