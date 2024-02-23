package com.spring.diex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("setting.xml");
		
		Exam exam = context.getBean(Exam.class);
//		ExamConsole eConsole = context.getBean(ExamConsole.class);
		ExamConsole eConsole = (ExamConsole) context.getBean("eConsoleMulti");
		
		eConsole.print();
	
	
	}
}
