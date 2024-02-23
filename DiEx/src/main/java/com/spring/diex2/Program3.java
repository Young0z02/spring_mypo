package com.spring.diex2;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program3 {
   
   public static void main(String[] args) {
      
      ApplicationContext context = 
            new ClassPathXmlApplicationContext("array_setting.xml");
      
      
//      배열 리스트를 이용하여 데이터 처리
//      ArrayList<Exam> exams = new ArrayList<Exam>();
//      Exam exam1 = new LecExam(80,90,100);
//      exams.add(new LecExam(100,80,90));
//      exams.add(exam1);
      
      ArrayList<Exam> exams = (ArrayList<Exam>) context.getBean("exams");
      
      for(Exam e : exams) {
         System.out.println(" -->"+ e.toString());
      }

      
      
      
   }
   

}