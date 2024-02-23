package com.spring.diex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*<bean id="eConsoleOne" class="com.spring.diex2.OnelineExamPrint">
<property name="exam" ref="exam"></property>
</bean>
*/

@Component("eConsoleOne")
public class OnelineExamPrint implements ExamConsole {
	@Autowired
//	@Qualifier("exam2")
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
