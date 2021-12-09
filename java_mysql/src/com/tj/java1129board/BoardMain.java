package com.tj.java1129board;

public class BoardMain {

	public static void main(String[] args) {
		MemberDAO dao = MemberDAOImpl.sharedInstance();
		/*
		//회원가입 테스트
		Member member = new Member();
		member.setMemberid("luna");
		member.setMemberpw("1106");
		member.setMembername("희진");
		member.setMembernickname("루나");
		member.setMemberemail("hijnshp@naver.com");
		member.setMembertel("01026061812");
		member.setMemberimage("image.png");
		
		//데이터 삽입 메소드 호출
		int r = dao.memberregister(member);
		if(r > 0) {
			System.out.println("회원 가입 성공");
		}else {
			System.out.println("회원 가입 실패");
		}
*/
		/*
		//id가 존재하는지 확인
		String result = dao.idcheck("luna");
		System.out.println(result);
		
		result = dao.idcheck("solar");
		System.out.println(result);
		*/
		//nickname이 존재하는지 확인
		/*
		String result = dao.nicknamecheck("루나");
		System.out.println(result);
		*/
		/*
		String result = dao.login("luna","1106");
		System.out.println(result);
		
		result = dao.login("luna","0000");
		System.out.println(result);
		*/
		
		Member result = dao.getMember("루나");
		System.out.println(result);
	}

}
