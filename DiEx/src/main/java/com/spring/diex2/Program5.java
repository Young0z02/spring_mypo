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
//      addrSet.add("全辨悼1 林家");
//      addrSet.add("全辨悼2 林家");
//      addrSet.add("全辨悼3 林家");
      
      CollectionSet collectionSet = (CollectionSet) context.getBean("collectionSet");
      Set<String> addrSet = collectionSet.getAddressSet();
      
      for(String address : addrSet) {
         System.out.println("address :" + address);
      }
      

   }
   

}