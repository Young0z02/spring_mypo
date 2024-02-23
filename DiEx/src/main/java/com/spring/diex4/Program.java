package com.spring.diex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
	
//		ApplicationContext context = new ClassPathXmlApplicationContext("ano_setting.xml");
		
		//@ 기반의 지시서(설명서, 설정파일)를 실제 구현하기 위해서는 AnnotationConfigApplicationContext(ProgramConfig.class); 이용해서 구현함
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ProgramConfig.class);
	
		Exam exam = (Exam) context.getBean("exam");
		System.out.println(exam.toString());
		
		
//		Exam exam = context.getBean(Exam.class);
//		ExamConsole eConsole = context.getBean(ExamConsole.class);
//		ExamConsole eConsole = (ExamConsole) context.getBean("eConsoleOne");
		ExamConsole eConsole = (ExamConsole) context.getBean("MultpleLine");
		
		eConsole.print();
	
	
	}
}
