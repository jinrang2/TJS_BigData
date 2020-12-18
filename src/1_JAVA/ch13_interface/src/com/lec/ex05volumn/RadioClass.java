package com.lec.ex05volumn;

public class RadioClass implements IVolume {
	private int vol;
	
	RadioClass(){
		vol = VolConst.RADIO_VOL_DEFAULT;
		printInfo();
	}
	
	@Override
	public void volumnUp() {
		volumnSet(VolConst.RADIO_VOL_UNIT);
	}

	@Override
	public void volumnUp(int level) {
		volumnSet(level);
	}

	@Override
	public void volumnDown() {
		volumnSet(-VolConst.RADIO_VOL_UNIT);

	}

	@Override
	public void volumnDown(int level) {
		volumnSet(-level);
	}
	
	private void volumnSet(int level) {
		vol += level;
		
		if (vol >= VolConst.RADIO_VOL_MAX) {
			vol = VolConst.RADIO_VOL_MAX;
		} else if (vol <= 0){
			vol = 0;
		}
		
		printInfo();
		
	}
	
	public void printInfo() {
		System.out.println("현재 라디오 볼륨은 : "+ vol);
	}

}
