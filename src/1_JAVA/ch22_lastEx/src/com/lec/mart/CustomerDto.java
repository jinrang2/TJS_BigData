package com.lec.mart;

import java.util.ArrayList;

public class CustomerDto {
	public static int FAIL=0;
	public static int SUCCESS=1;
	
	
	private String cid;
	private String cTel;
	private String cName;
	private String cPoint;
	private String cAmount;
	private String levelName;
	private String next;
	
	public CustomerDto(String cid, String cTel, String cName, String cPoint, String cAmount, String levelName, String next) {
		super();
		this.cid = cid;
		this.cTel = cTel;
		this.cName = cName;
		this.cPoint = cPoint;
		this.cAmount = cAmount;
		this.levelName = levelName;
		this.next = next;
	}
	
	public CustomerDto(ArrayList<String> arr) {
		this.cid = arr.get(0);
		this.cTel = arr.get(1);
		this.cName = arr.get(2);
		this.cPoint = arr.get(3);
		this.cAmount = arr.get(4);
		this.levelName = arr.get(5);
		this.next = arr.get(6);
	}
	
	
	@Override
	public String toString() {
		return "CustomerDto [cid=" + cid + ", cTel=" + cTel + ", cName=" + cName + ", cPoint=" + cPoint + ", cAmount="
				+ cAmount + ", levelName=" + levelName + ", next=" + next + "]";
	}

	public String getCid() {			return cid;			}
	public String getcTel() {			return cTel;		}
	public String getcName() {			return cName;		}
	public String getcPoint() {			return cPoint;		}
	public String getcAmount() {		return cAmount;		}
	public String getLevelName() {		return levelName;	}
	public String getNext() {			return next;		}	
}
