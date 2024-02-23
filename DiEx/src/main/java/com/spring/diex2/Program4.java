package com.spring.diex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program4 {
   
   public static void main(String[] args) {
      
      ApplicationContext context = 
            new ClassPathXmlApplicationContext("map_setting.xml");
      
      
      //Map 컬렉션을 자바로 구현하고, xml 지시서로도 구현해보자..
//      Map<String, String> addrMap = new HashMap<String, String>();
//      addrMap.put("홍길동1", "홍길동1 주소");
//      addrMap.put("홍길동2", "홍길동2 주소");
      
      CollectionMap collectionMap = (CollectionMap) context.getBean("collectionMap");
      Map<String, String> addrMap = collectionMap.getAddressMap();
      
      for(Map.Entry<String, String> address : addrMap.entrySet()) {
         System.out.println("name : " + address.getKey()+ 
               ", address : " + address.getValue());
      }
      
      
      
   }
   

}
