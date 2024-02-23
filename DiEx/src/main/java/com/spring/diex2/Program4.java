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
      
      
      //Map �÷����� �ڹٷ� �����ϰ�, xml ���ü��ε� �����غ���..
//      Map<String, String> addrMap = new HashMap<String, String>();
//      addrMap.put("ȫ�浿1", "ȫ�浿1 �ּ�");
//      addrMap.put("ȫ�浿2", "ȫ�浿2 �ּ�");
      
      CollectionMap collectionMap = (CollectionMap) context.getBean("collectionMap");
      Map<String, String> addrMap = collectionMap.getAddressMap();
      
      for(Map.Entry<String, String> address : addrMap.entrySet()) {
         System.out.println("name : " + address.getKey()+ 
               ", address : " + address.getValue());
      }
      
      
      
   }
   

}
