package com.spring.diex1;

public class SamsungTvi implements Tvi{

	@Override
	public void powerOn() {
		System.out.println("SumsungTvOn ()");
	}

	@Override
	public void powerOff() {
		System.out.println("SumsungTvOff ()");	
	}
}
