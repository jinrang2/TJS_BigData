package com.lec.ex02phone;

public class TestMain {

	public static void main(String[] args) {
		IAcor[] phones = {new AModel(),new BModel(),new CModel()	};
		
		
		for (IAcor phone : phones) {
			phone.dmbReceive();
			phone.lte();
			phone.tvRemoteControl();
			System.out.println();
			//System.out.println(phone.getClass());
			System.out.println(phone.getClass().getName());
			System.out.println();
		}
		
	}
}