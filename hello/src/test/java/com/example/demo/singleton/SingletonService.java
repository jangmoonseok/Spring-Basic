package com.example.demo.singleton;

public class SingletonService {
	// static ������ ��ü�� �� 1���� �����صд�.
	private static final SingletonService instance = new SingletonService();
	
	// public���� ��ü �ν��Ͻ��� �ʿ��ϸ� �� static �޼��带 ���ؼ��� ��ȸ�ϵ��� ���
	public static SingletonService getInstance() {
		return instance;
	}
	
	// �����ڸ� private���� �����ؼ� �ܺο��� ��ü ������ ���´�
	private SingletonService() {
		
	}
	
	public void logic() {
		System.out.println("�̱��� ��ü ���� ȣ��");
	}
}
