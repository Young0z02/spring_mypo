package com.spring.diex4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*<context:component-scan base-package="com.spring.diex4" />

<!--  다른 객체에 부품이 되는 객체생성은 xml 기반 지시서에서 만드는 것이 유리 (xml과 @을 병행해서 사용하는 측명) -->
<bean id="exam" class="com.spring.diex4.LecExam"
	p:kor="10" p:eng="20" p:math="30" />*/


@ComponentScan("com.spring.diex4")
@Configuration //해당 클래스를 지시서로 사용하다는 @
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
		
		//setter() 이용하여 주입코드가 없는 이유는 OneLineExamPrint() @AutoWired를 이용하여 주입하고 있기 때문에여기에서 코드 구현은 필요 없음
	}
	
	@Bean
	public ExamConsole MultpleLine() {
		return new MultpleLineExamPrint();
		
		//setter() 이용하여 주입코드가 없는 이유는 OneLineExamPrint() @AutoWired를 이용하여 주입하고 있기 때문에여기에서 코드 구현은 필요 없음
	}
}
