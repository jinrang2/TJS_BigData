package com.lec.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DBConsolePrint {
	private HashMap<Integer, ArrayList<String>> rsList;
	private int maxColCnt;

	public DBConsolePrint() {
		super();
		rsList = new HashMap<Integer, ArrayList<String>>();
		
		maxColCnt=0;	
	}

	public void print() {
		HashMap<Integer, Integer> mapColWidth = new HashMap<Integer, Integer>();
		Iterator<Integer> keys = rsList.keySet().iterator();
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			ArrayList<String> temp = rsList.get(key);
			int maxColSize = 0;
			
			for(int i=0, len=temp.size() ;  i < len ; i++) {
				
				if (temp.get(i).getBytes().length > maxColSize)
					maxColSize = temp.get(i).getBytes().length; 
			}
			
			mapColWidth.put(key, maxColSize);
		}
		
		keys = rsList.keySet().iterator();
		String line = "+";
		String cols = "|";
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			int colMax = mapColWidth.get(key); 
			
			for(int i = 0 ; i < colMax+2 ; i++ ) {
				line += "-";
			}
			
			line += "+";
		}
		
		keys = rsList.keySet().iterator();
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			int colMax = mapColWidth.get(key); 
						
			cols += (" " + rpad(rsList.get(key).get(0),colMax+1,' ')+"|");
			
		}
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			int colMax = mapColWidth.get(key); 
			
			
			cols += (" " + rpad(rsList.get(key).get(0),colMax+1,' ')+"|");
		}
		
		//mapColMax.size();
		System.out.println();
		System.out.println();
		System.out.println(line);
		System.out.println(cols);
		System.out.println(line);
		
		HashMap<Integer, ArrayList<String>> pivot=new HashMap<Integer, ArrayList<String>>(); 
		keys = rsList.keySet().iterator();
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			ArrayList<String> temp = rsList.get(key);
			
			
			for (int i = 1, size= temp.size() ; i < size ; i++) {
				ArrayList<String> temp2 = new ArrayList<String>();
				
				if (pivot.get(i) == null) {
					temp2.add(temp.get(i));
					pivot.put(i, temp2);
					//System.out.println(temp.get(i));
				} else {
					temp2 = pivot.get(i);
					temp2.add(temp.get(i));
					
				}				
			}			
		}
		
		keys = pivot.keySet().iterator();
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			int curCol=0;
			
			ArrayList<String> rowResult = pivot.get(key);
			
			//mapColWidth.get(1);
			String rows="|";
								
			for (int i = 0, size= rowResult.size() ; i < size ; i++) {				
				curCol++;
				//System.out.println(i);
				//System.out.println(rowResult.get(i));
				rows += (" " + rpad(rowResult.get(i), mapColWidth.get(curCol) + 1 ,' ')+"|");
			}
			
			System.out.println(rows);
		}
		
		System.out.println(line);
		System.out.println();
		System.out.println();
	}
	
	public void add(int colKey, String colValue) {
		ArrayList<String> temp = new ArrayList<String>();
		Integer col = colKey;		
		
		if (rsList.get(colKey) == null) {
			temp.add(colValue);
			rsList.put(col, temp);
		} else {
			temp = rsList.get(colKey);
			temp.add(colValue);			
		}
	}
	
	public void add(int colKey, Integer colValue) {
		add(colKey,colValue.toString());
	}
	
	private String rpad(String strSource, int iLength, char cPadder){
		StringBuffer sbBuffer = null;
		if (!strSource.isEmpty()){
			int iByteSize = strSource.getBytes().length;
			if (iByteSize > iLength){
				return strSource.substring(0, iLength);
			}else if (iByteSize == iLength){
				return strSource;
			}else{
				int iPadLength = iLength - iByteSize;
				sbBuffer = new StringBuffer(strSource);
				for (int j = 0; j < iPadLength; j++){
					sbBuffer.append(cPadder);
				}
				return sbBuffer.toString();
			}
		}
		sbBuffer = new StringBuffer();
		for (int j = 0; j < iLength; j++){
			sbBuffer.append(cPadder);
		}
		return sbBuffer.toString();
	}
}
