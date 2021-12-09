package com.tj.java1129board;

public interface MemberDAO {
	//아이디 중복 확인
	//아이디를 매개변수로 받아서 존재 여부를 리턴
	//데이터가 존재하면 자기 자신의 데이터를 리턴하고 존재하지 않으면 null을 리턴
	public String idcheck(String id);
	
	//별명 중복 확인
	//데이터가 존재하면 자기 자신의 데이터를 리턴하고 존재하지 않으면 null을 리턴
	public String nicknamecheck(String nickname);
	
	//회원 가입 - 데이터 추가 
	//추가하기 위해서는 DTO나 Map을 매개변수로 주고 리턴은 void, boolean, int가 가능
	//실패 가능성이 전혀 없다면(유효성 검사를 철저히 해서 삽입) void
	//성공과 실패 여부만을 리턴 boolean
	//영향받은 행의 개수를 알려주고자 하면 int - 데이터베이스 리턴값 
	public int memberregister(Member member);
	
	//로그인
	//아이디와 비밀번호를 입력받아서 구별되는 정보를 리턴
	//별명을 리턴하기도 하거 아이디를 리턴하기도 함
	//여기서 리턴받은 데이터를 메모리에 저장해서 로그인 여부를 판단하고 자신의 데이터를 가져옴
	public String login(String id, String pw);
	
	//회원 정보가져오기
	public Member getMember(String nickname);
	
	//회원정보 수정: 데이터 수정은 추가와 같음
	//전체 데이터 정보를 받아서 기본키나 unique 한 속성을 가지고 나머지를 수정 
	public int membermodify(Member member);
	
	//회원 탈퇴
	//삭제는 삽입, 수정 작업과 리턴 타입은 동일한데 매개변수는 DTO를 사용하기도 하고
	//primary key나 unique한 속성을 이용하기도 함 
	public int memberdelete(Member member);

}
