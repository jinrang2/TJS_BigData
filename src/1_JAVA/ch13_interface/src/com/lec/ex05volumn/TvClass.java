package com.lec.ex05volumn;

public class TvClass implements IVolume {
	private int vol;
	
	TvClass(){
		vol = VolConst.TV_VOL_DEFAULT;
		printInfo();
	}
	
	@Override
	public void volumnUp() {
		volumnSet(VolConst.TV_VOL_UNIT);
	}

	@Override
	public void volumnUp(int level) {
		volumnSet(level);
	}

	@Override
	public void volumnDown() {
		volumnSet(-VolConst.TV_VOL_UNIT);
	}

	@Override
	public void volumnDown(int level) {
		volumnSet(-level);
	}
	
	private void volumnSet(int level) {
		vol += level;
		
		if (vol >= VolConst.TV_VOL_MAX) {
			vol = VolConst.TV_VOL_MAX;
		} else if (vol <= 0){
			vol = 0;
		}
		
		printInfo();
		
	}
	
	public void printInfo() {
		System.out.println("현재 티비 볼륨은 : "+ vol);
	}

}
