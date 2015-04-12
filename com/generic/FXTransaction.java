package com.generic;

public class FXTransaction implements Transaction {

	@Override
	public void process() {
		System.out.println("processing FX transaction");

	}

}
