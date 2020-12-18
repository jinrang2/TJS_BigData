package com.lec.ex1_list;

public class AClass implements GeneClass {
	private String strA = "A";
	
	@Override
	public String toString() {
		return "strA = " + strA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((strA == null) ? 0 : strA.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AClass other = (AClass) obj;
		if (strA == null) {
			if (other.strA != null)
				return false;
		} else if (!strA.equals(other.strA))
			return false;
		return true;
	}
	
	
}
