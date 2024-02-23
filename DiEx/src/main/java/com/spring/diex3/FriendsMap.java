package com.spring.diex3;

import java.util.Map;

public class FriendsMap {

   public Map<String, String> getKakaoMap() {
		return kakaoMap;
	}

	public void setKakaoMap(Map<String, String> kakaoMap) {
		this.kakaoMap = kakaoMap;
	}

private Map<String, String> kakaoMap;

   public Map<String, String> getkakaoMap() {
      return kakaoMap;
   }

   public void setkakaoMap(Map<String, String> kakaoMap) {
      this.kakaoMap = kakaoMap;
   }

}