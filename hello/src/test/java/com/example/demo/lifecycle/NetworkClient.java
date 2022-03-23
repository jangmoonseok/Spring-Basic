package com.example.demo.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
	private String url;

	public NetworkClient() {
		super();
		System.out.println("������ ȣ��, url = " + url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	//���� ���۽� ȣ��
	public void connect() {
		System.out.println("connect : " + url);
	}
	
	public void call(String message) {
		System.out.println("call: " + url + " message : " + message);
	}
	
	//���� ����� ȣ��
	public void disconnect() {
		System.out.println("close " + url);
	}

	@PreDestroy
	public void close() {
		disconnect();
	}

	@PostConstruct
	public void init() {
		connect();
		call("�ʱ�ȭ ���� �޽���");
	}
	
	
}
