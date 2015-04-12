package com.scjp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss ");
		Date date = new Date();
		
		//String dateString=dateFormat.format(date);
		
		String dateString=dateFormat.format(date).replace(' ', '_').replace(':','_');
		
		System.out.println(dateString.substring(0,dateString.length()-1));
		
	}

}
