package com.spring.diex2;

public class OnelineExamPrint implements ExamConsole {
	private Exam exam;
	
	public OnelineExamPrint(Exam exam) {
		super();
		this.exam = exam;
	}
	
	
	@Override
	public void print() {
	 System.out.println("total: " + exam.total() + " avg : " + exam.avg());	
	}
	
	
	public OnelineExamPrint() {
		System.out.println("OnelineExamPrint() »ý¼ºÀÚ");
	}
		

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
