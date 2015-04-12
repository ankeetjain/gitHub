package com.scjp;

import java.util.Arrays;
import java.util.List;

public class EvenNumber implements Runnable {
	
	Integer a[] = {2,4,6};

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