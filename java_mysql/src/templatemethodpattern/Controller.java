package templatemethodpattern;

public class Controller {

	public static void main(String[] args) {
		//템플릿 메소드 패턴에서 인터페이스를 구현한 클래스의 인스턴스 생성
		//변수는 인터페이스나 추상클래스 이름으로 만들고 
		//대입되는 인스턴스는 하위 클래스를 가지고 생성
		Service service = new ServiceImpl();

		service.disp();

		final int ONE = 1;
		//final 변수의 값은 변경할 수 없음
		//ONE =2; - 에러

		int menu = 2;
		
		final int X = 1;
		final int Y = 2;
		switch(menu) {
		case X:
			break;
		case Y:
			break;
		}
	}

}
