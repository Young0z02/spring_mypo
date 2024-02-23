package com.spring.diex1;

public class LgTvi implements Tvi{

	@Override
	public void powerOn() {
		System.out.println("LgTvON ()");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTvOff ()");
	}

}
