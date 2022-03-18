package com.example.demo.singleton;

public class SingletonService {
	// static 영역에 객체를 딱 1개만 생성해둔다.
	private static final SingletonService instance = new SingletonService();
	
	// public으로 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용
	public static SingletonService getInstance() {
		return instance;
	}
	
	// 생성자를 private으로 선언해서 외부에서 객체 생성을 막는다
	private SingletonService() {
		
	}
	
	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
	}
}
