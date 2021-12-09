package templatemethodpattern;

public interface Service {
	//속성을 선언하면 자동적으로 final이 되기 때문에 반드시 선언할 때 초기화를 해야 합니다
	String NAME = "INTERFACE";
	
	//abstract를 붙이지 않아도 추상 메소드가 됨
	public void disp();

}
