package com.spring.diex2;

public class MultpleLineExamPrint implements ExamConsole{

	private Exam exam;
	

	public MultpleLineExamPrint(Exam exam) {
		super();
		this.exam = exam;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("total : " + exam.total());
		System.out.println("--> avg : " + exam.avg());

	}

	
	public MultpleLineExamPrint() {
		System.out.println("MultpleLineExamPrint() »ý¼ºÀÚ");
	}
		

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
}
