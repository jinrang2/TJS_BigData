package com.lec.att;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * DB의 값이 아래와 같은 형태로 이쁘게 출력되게 한다
 * +------+------+------+
 * | col1 | col2 | col3 |
 * +------+------+------+
 * | val1 | val2 | val3 |
 * | val4 | val5 | val6 |
 * +------+------+------+
 */
public class DBConsolePrint {
	private HashMap<Integer, ArrayList<String>> rsList;
	
	public DBConsolePrint() {
		super();
		rsList = new HashMap<Integer, ArrayList<String>>();	
	}

	public String getPrintStr() {
		HashMap<Integer, Integer> mapColWidth = new HashMap<Integer, Integer>();
		Iterator<Integer> keys = rsList.keySet().iterator();
		String printStr = "";
		
		// 1. 칼럼들의 가장 큰 글자 길이를 찾는다 
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
		
		
		// 2. 1에서 구한 길이 단위로 표의 가장자리를 그린다
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
		
		// 2. 칼럼의 목차를 쓴다
		keys = rsList.keySet().iterator();
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			int colMax = mapColWidth.get(key); 
						
			cols += (" " + rpad(rsList.get(key).get(0),colMax+1,' ')+"|");
			
		}		
		
		/* 여기까지 그린다	 
		 * +------+------+------+
		 * | col1 | col2 | col3 |
		 * +------+------+------+
		 */
		
		printStr += "\n";
		printStr += (line+"\n");
		printStr += (cols+"\n");
		printStr += (line+"\n");
		
		// 3. rsList의 열기준 맵을 행기준 맵으로 바꾼다
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
		
		
		// 4. 피벗맵을 통해 다시 그린다.
		keys = pivot.keySet().iterator();		
		while(keys.hasNext()) {
			Integer key = keys.next();
			int curCol=0;
			
			ArrayList<String> rowResult = pivot.get(key);
			
			String rows="|";
								
			for (int i = 0, size= rowResult.size() ; i < size ; i++) {				
				curCol++;
				rows += (" " + rpad(rowResult.get(i), mapColWidth.get(curCol) + 1 ,' ')+"|");
			}
			
			printStr += (rows+"\n");
		}
		
		printStr += (line+"\n");
		printStr += "\n";
		
		// 5. 표의 아래쪽 가장자리를 그리고 마친다.
		
		return printStr;
	}
	
	public void print() {
		System.out.println(getPrintStr());
	}
	
	public void add(int colKey, String colValue) {
		ArrayList<String> temp; 
		Integer col = colKey;		
		
		if (rsList.get(colKey) == null) {
			temp = new ArrayList<String>();
			rsList.put(col, temp);
		} else {
			temp = rsList.get(colKey);						
		}

		temp.add(colValue);
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
