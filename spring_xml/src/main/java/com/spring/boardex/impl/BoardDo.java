package com.spring.boardex.impl;

public class BoardDo {
	//���̺� ���̶� ���� ��
	private int seq;
	private String id;
	private String password;
	
	@Override
	public String toString() {
		return "BoardDo [seq=" + seq + ", id=" + id + ", password= " + password +"]";
	}
	
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
