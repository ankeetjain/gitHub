package com.scjp;

public class ArgTest {

	/**
	 * @param args
	 */
	public static void main(String... args) {
		// TODO Auto-generated method stub

		System.out.println(args.length);
		String[] s =new String[2];
		System.out.println("S length " +s.length);
		s=args;
		for (int i=0;i < 3 ;i++)
			System.out.println(s[i]);
	}

}
