package com.spring.boardex.impl;

public class BoardDo {
	//테이블 명이랑 같게 함
	private int seq;
	private String id;
	private String password;
	private String content;
	private String title;
	
	
	@Override
	public String toString() {
		return "BoardDo [seq=" + seq + ", id=" + id + ", password= " + password +",  content=" + content +",  title=" + title +"]";
	}
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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
