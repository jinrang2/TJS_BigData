package com.lec.ex03actor;

public class TestMain {

	public static void main(String[] args) {
		
		Actor park =  new Actor("박보검");
		
		park.catCatchCriminal();
		park.canSearch();
		park.makePizza();
		park.makeSpaghetti();
		park.outFire();
		park.saveMan();

		System.out.println();
		
		FireFighter firePark = park;
		
		firePark.outFire();
		firePark.saveMan();
		
		PoliceMan policePark = park;
		
		policePark.canSearch();
		policePark.catCatchCriminal();
		
		Chef chefPark = park;
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		
	}

}
