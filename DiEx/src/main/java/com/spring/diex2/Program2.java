package com.spring.diex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program2 {

	public static void main(String[] args) {
	
//		Exam exam = new LecExam(100, 100, 100);
		
		//setting.xml�� �ִ� ����(���ü�)�� �ؼ��ؼ� ��ü ���� �� ������ ���ִ� Ŭ���� :
		//ClassPathXml~~ ()
		ApplicationContext context = new ClassPathXmlApplicationContext("setting.xml");
		
		// ������� ��ü�߿��� �ʿ��� ��ü�� �������� �޼ҵ� : getBean();
		Exam exam = context.getBean(Exam.class);
		
		//�ܺο��� exam ��ü�� �����ϰ�, �����ڸ� �̿��Ͽ� ������ (DI)
		//1. ������ �̿� DI ����
		//ExamConsole eConsole = new OnelineExamPrint(exam);
		//ExamConsole eConsole = new MultleLineExamPrint(exam);
		
		
		//2.  setting �̿� DI ����
//		ExamConsole eConsole = new OnelineExamPrint();
//		eConsole.setExam(exam);
		
		ExamConsole eConsole = context.getBean(ExamConsole.class);
		eConsole.print();
	
	
	}
}
