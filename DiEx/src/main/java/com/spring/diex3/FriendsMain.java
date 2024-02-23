package com.spring.diex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FriendsMain {
   
   public static void main(String[] args) {
      
      ApplicationContext context = 
            new ClassPathXmlApplicationContext("FriendsSetting.xml");
      
      
      FriendsMap friendsMap = (FriendsMap) context.getBean("FriendsMap");
      Map<String, String> kakaoMap = friendsMap.getkakaoMap();
      
      for(Map.Entry<String, String> kakao : kakaoMap.entrySet()) {
         System.out.println("name : " + kakao.getKey()+ 
               ", kakao : " + kakao.getValue());
      }
      
      
      
   }
   

}

