package com.tj.java1129board;

//서버에서 작업을 처리하는 클래스틑 인스턴스가 1개만 필요하기 때문에
//singletonpattern으로 디자인
public class MemberDAOImpl extends DAO implements MemberDAO {
	//Singleton 패턴을 위한 코드
	//프레임워크를 이용하면 자동으로 처리됩니다.
	private static MemberDAO memberDAO;
	
	private MemberDAOImpl() {}
	
	public static MemberDAO sharedInstance() {
		if(memberDAO ==null) {
			memberDAO = new MemberDAOImpl();
		}
		return memberDAO;
		}
	

	
	@Override
	public String idcheck(String id) {
		//null이 리턴되면 존재하지 않는 아이디이고 null이 아닌 데이터가 리턴되면 존재하는 id
		String result = null;
		try {
			//실행할 SQL 생성 - 중복검사는 매개변수가 존재하는지 확인할 수 있는 SQL을 생성
		pstmt = con.prepareStatement("select memberid from member where memberid=?");
		//데이터 바인딩
		pstmt.setString(1, id);
		
		//select 구문 실행
		rs = pstmt.executeQuery();
		
		//검색된 내용이 0개 이상이면 while 1개 또는 0개이면 if를 이용
		if(rs.next()) {
			result = rs.getString("memberid");
		}
		rs.close();
		pstmt.close();
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return result;
	}

	@Override
	public String nicknamecheck(String nickname) {
		//리턴할 데이터 생성
		String result = null;
		try {
			pstmt = con.prepareStatement("select membernickname from memebr where membernickname=?");
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("membernickname");
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return result;
	}

	@Override
	public int memberregister(Member member) {
		int result = -1;
		try {
			pstmt = con.prepareStatement("insert into member(memberid, memberpw, membername, membertel, memberemail, membernickname, memberimage) values(?,?,?,?,?,?,?)");
			
			pstmt.setString(1, member.getMemberid());
			pstmt.setString(2, member.getMemberpw());
			pstmt.setString(3, member.getMembername());
			pstmt.setString(4, member.getMembertel());
			pstmt.setString(5, member.getMemberemail());
			pstmt.setString(6, member.getMembernickname());
			pstmt.setString(7, member.getMemberimage());
			
			//select이외의 구문 실행
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return result;
	}

	@Override
	//아이디와 비밀번호를 매개변수로 해서 자신의 정보를 찾아올 수 있는 무엇인가를 리턴
	//아이디는 primary key 이므로 절대로 2개 이상의 정보가 있을 수 없음
	public String login(String id, String pw) {
		//리턴할 정보 - 로그인 실패하면 null이 리턴되고 성공하면 nickname을 리턴
		String result = null;
		try {
			//sql 생성
			//id와 password가 일치하는 nickname을 찾아오는 SQL
			pstmt = con.prepareStatement("select membernickname from member where memberid=? and memberpw=?");
			//물음표에 데이터 바인딩
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			//SQL 실행
			rs = pstmt.executeQuery();
			//리턴되는 데이터가 있으면 읽어서 result에 저장
			if(rs.next()) {
				result = rs.getString("membernickname");
			}
			rs.close();
			pstmt.close();
			}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return result;
	}

	@Override
	public Member getMember(String nickname) {
		Member member = null;
		try {
			//nickname을 가지고 모든 정보를 찾아오는 SQL
			pstmt = con.prepareStatement("select* from member where nickname=?");
			pstmt.setString(1, nickname);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberid(rs.getString("memberid"));
				member.setMemberpw(rs.getString("memberpw"));
				member.setMembername(rs.getString("membername"));
				member.setMembertel(rs.getString("membertel"));
				member.setMemberemail(rs.getString("memberemail"));
				member.setMembernickname(rs.getString("membernickname"));
				member.setMemberimage(rs.getString("memberimage"));
			}
			rs.close();
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return member;
		
	}

	@Override
	public int membermodify(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberdelete(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
