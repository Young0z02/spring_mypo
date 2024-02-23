package com.spring.diex4;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*<bean id="exam" class="com.spring.diex2.LecExam">
<property name="kor" value="100"></property>
<property name="eng" value="100"></property>
<property name="math" value="100"></property>
</bean>
*/


//@Component("exam")
public class LecExam2 implements Exam {
//	@Value("80")
	private int kor;
//	@Value("90")
	private int eng;
//	@Value("100")
	private int math;

	
	
	public LecExam2(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public LecExam2() {
		System.out.println("LecExam() »ý¼ºÀÚ");
	}

	@Override
	public int total() {
		return kor + eng + math;
	}

	@Override
	public float avg() {
		return total()/3.0f;
	}
	
	
	
	

	@Override
	public String toString() {
		return "LecExam [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
	
	

}
