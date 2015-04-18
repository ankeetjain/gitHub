package com.ankit.im.apparch;


import com.ankit.im.util.InterestCalculator;
/**
 * Hello world!
 *
 */
public class App 
{
    public void displayHello ()
    {
    	System.out.println("Hello to the world");
    	InterestCalculator ob = new InterestCalculator();
    	int interest = ob.calculateInterest();
    	System.out.println("interest is " + interest);
    }
    
    
}
