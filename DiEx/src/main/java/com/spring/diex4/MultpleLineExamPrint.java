package com.spring.diex4;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*<bean id="eConsoleMulti" class="com.spring.diex2.MultpleLineExamPrint">
<property name="exam" ref="exam"></property>
</bean>*/

@Component("MultpleLine")
public class MultpleLineExamPrint implements ExamConsole{
	@Autowired
	@Resource(name="exam")
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
