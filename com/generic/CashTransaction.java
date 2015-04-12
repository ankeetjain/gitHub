package com.generic;

public class CashTransaction implements Transaction {

	@Override
	public void process() {
		
		System.out.println("processing cash transaction");
	}

}
