package com.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Instruction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
       
       List<Transaction> transList = new ArrayList<Transaction>();
       transList.add(new FXTransaction());
       transList.add( new CashTransaction());
       transList.add ( new TradeTransaction());
           
       
       for(Transaction ob : transList)
       {
    	   ob.process();
       }
	}

}
