package com.scjp;

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OddNumber ob = new OddNumber();
		EvenNumber ob1 = new EvenNumber();
		   Thread t1= new Thread(ob);
		   //Thread t2= new Thread(ob1);
		   
		    //t2.start();
		    t1.start();
		    try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("Finishing the work");
		    
		   
		   
	}

}
