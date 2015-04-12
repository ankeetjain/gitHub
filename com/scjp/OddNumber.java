package com.scjp;

import java.util.Arrays;
import java.util.List;

public class OddNumber implements Runnable {
	
	Integer a[] = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29};

	List<Integer> intList = Arrays.asList(a);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (Integer num: intList)
		{
			System.out.println("Number is " + num);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
