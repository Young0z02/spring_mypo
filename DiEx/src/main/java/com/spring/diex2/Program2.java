package com.spring.diex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program2 {

	public static void main(String[] args) {
	
//		Exam exam = new LecExam(100, 100, 100);
		
		//setting.xml에 있는 설명서(지시서)를 해석해서 객체 생성 및 주입을 해주는 클래스 :
		//ClassPathXml~~ ()
		ApplicationContext context = new ClassPathXmlApplicationContext("setting.xml");
		
		// 만들어진 객체중에서 필요한 객체를 가져오는 메소드 : getBean();
		Exam exam = context.getBean(Exam.class);
		
		//외부에서 exam 객체를 생성하고, 생성자를 이용하여 주입함 (DI)
		//1. 생성자 이용 DI 구현
		//ExamConsole eConsole = new OnelineExamPrint(exam);
		//ExamConsole eConsole = new MultleLineExamPrint(exam);
		
		
		//2.  setting 이용 DI 구현
//		ExamConsole eConsole = new OnelineExamPrint();
//		eConsole.setExam(exam);
		
		ExamConsole eConsole = context.getBean(ExamConsole.class);
		eConsole.print();
	
	
	}
}
