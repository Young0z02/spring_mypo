package com.spring.diex1;

public class AppleTvi implements Tvi {

	@Override
	public void powerOn() {
		System.out.println("AppleTvOn ()");
	}

	@Override
	public void powerOff() {
		System.out.println("AppleTvOff ()");
	}	
	
}
