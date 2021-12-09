package com.tj.java1129board;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DAO {
	//데이터베이스 연동에 필요한 속성을 선언
	//실제 사용은 하위 클래스에서하므로 protected로 선언
	protected static Connection con;
	protected static PreparedStatement pstmt;
	protected static ResultSet rs;

	//클래스가 처음 사용될 때 1번만 수행되는 코드
	//여기서는 instance 변수는 사용할 수 없습니다. 
	static {
		try {
			//파일 경로를 생성
			File f = new File("./db.properties");
			//System.out.println("1");
			//파일을 읽을 수 있는 InputStream 생성
			FileInputStream fis = new FileInputStream(f);
			//System.out.println("2");
			//프로퍼티스와 파일을 연결
			Properties properties = new Properties();
			//System.out.println("3");
			properties.load(fis);
			//System.out.println("4");

			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String id = properties.getProperty("id");
			String pw = properties.getProperty("pw");
			//System.out.println("5");

			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			//System.out.println("6");

		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	//인스턴스가 만들어 질 때마다 호출되는 코드
	//생성자에 작성해도 됩니다.
	//매개변수를 받아서 처리할 필요가 없을 때는 { } 에 작성
	//매개변수를 받아서 처리해야 할 때는 생성자를 이용
	//일반적으로 개발자들은 { } 을 잘 사용하지 않음 - 다른 언어에서 지원을 거의 
	{

	}
}
