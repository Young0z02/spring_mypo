package com.spring.diex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program5 {
   
   public static void main(String[] args) {
      
      ApplicationContext context = 
            new ClassPathXmlApplicationContext("set_setting.xml");
      
//      Set<String> addrSet = new HashSet<String>();
//      addrSet.add("ȫ�浿1 �ּ�");
//      addrSet.add("ȫ�浿2 �ּ�");
//      addrSet.add("ȫ�浿3 �ּ�");
      
      CollectionSet collectionSet = (CollectionSet) context.getBean("collectionSet");
      Set<String> addrSet = collectionSet.getAddressSet();
      
      for(String address : addrSet) {
         System.out.println("address :" + address);
      }
      

   }
   

}