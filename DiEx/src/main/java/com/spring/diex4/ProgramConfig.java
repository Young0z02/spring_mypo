package com.spring.diex4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*<context:component-scan base-package="com.spring.diex4" />

<!--  �ٸ� ��ü�� ��ǰ�� �Ǵ� ��ü������ xml ��� ���ü����� ����� ���� ���� (xml�� @�� �����ؼ� ����ϴ� ����) -->
<bean id="exam" class="com.spring.diex4.LecExam"
	p:kor="10" p:eng="20" p:math="30" />*/


@ComponentScan("com.spring.diex4")
@Configuration //�ش� Ŭ������ ���ü��� ����ϴٴ� @
public class ProgramConfig {
	/*
	<bean id="exam" class="com.spring.diex4.LecExam"
			p:kor="10" p:eng="20" p:math="30" />*/
	@Bean
	public Exam exam() {
		return new LecExam(30, 20, 30);
	}

	/* 
	  <bean id="eConsoleOne" class="com.spring.diex2.OnelineExamPrint">
	<property name="exam" ref="exam"></property>
	</bean>
	
	 */
	
	@Bean
	public ExamConsole eConsoleOne() {
		return new OnelineExamPrint();
		
		//setter() �̿��Ͽ� �����ڵ尡 ���� ������ OneLineExamPrint() @AutoWired�� �̿��Ͽ� �����ϰ� �ֱ� ���������⿡�� �ڵ� ������ �ʿ� ����
	}
	
	@Bean
	public ExamConsole MultpleLine() {
		return new MultpleLineExamPrint();
		
		//setter() �̿��Ͽ� �����ڵ尡 ���� ������ OneLineExamPrint() @AutoWired�� �̿��Ͽ� �����ϰ� �ֱ� ���������⿡�� �ڵ� ������ �ʿ� ����
	}
}
