package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {

	private String sno;
	private String name;
	private PartType part;
	private Date date;

	public Sawon() {}

	public Sawon(String sno, String name, PartType part) {
		this.sno = sno;
		this.name = name;
		this.part = part;
		this.date = new Date();		
	}

	public Sawon(String sno, String name, PartType part, int year, int month, int day) {
		this.sno = sno;
		this.name = name;
		this.part = part;
		this.date = new GregorianCalendar(year, month-1, day).getTime();
	}
	
	public String infoString() {
		SimpleDateFormat sdf = new SimpleDateFormat("YY-M-dd");
		return String.format("사번]%s\t[이름]%s\t[부서]%-6s\t[입사일]%s", 
									sno,       name,      part.getName() , sdf.format(date)   );
		
	}
	
	@Override
	public String toString() {
		return infoString();
	}

	public String getSno() {
		return sno;
	}

	public String getName() {
		return name;
	}

	public PartType getPart() {
		return part;
	}

	public Date getDate() {
		return date;
	}
	
	
	
	
	
	
	
	
}
