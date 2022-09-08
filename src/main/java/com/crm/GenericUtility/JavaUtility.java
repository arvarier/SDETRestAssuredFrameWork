package com.crm.GenericUtility;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random=new Random();
		int randNum=random.nextInt();
		return randNum;
	}

}
