package com.scjp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class deserializeWorkgroup {
	
	static HashMap<String, List> avail_b_not_a = new HashMap<String, List>();
	static HashMap<String, List> avail_a_not_b = new HashMap<String, List>();
	
	public static void main(String[] args) {
		
		
		WorkGroup window_B_Securities = new WorkGroup ();
		window_B_Securities.setWorkGroupName("Securities");
		window_B_Securities.setFolder("Verification");
		window_B_Securities.setTradeId("1");
		ArrayList<Integer> tradeid= new ArrayList<Integer>();
		
		for( int i=2;i<12;i++)
		{
			tradeid.add(i);
			
		}
		window_B_Securities.setTradeReference(tradeid);
		
		
		WorkGroup window_B_fxgroup = new WorkGroup ();
		window_B_fxgroup.setWorkGroupName("FX");
		window_B_fxgroup.setFolder("ACK Pending");
		
		ArrayList<Integer> fxids= new ArrayList<Integer>();
		
		for( int i=5;i<28;i=i+2)
		{
			fxids.add(i);
			
		}
		window_B_fxgroup.setTradeReference(fxids);
		
		
	
	try
	{
		File file= new File("d://Books//Tradflow_Work_Group.dat");
		
		FileInputStream fs= new FileInputStream(file);
		ObjectInputStream os = new ObjectInputStream(fs);
		HashMap<String, WorkGroup> workgroupHash=(HashMap<String, WorkGroup>)os.readObject();
		os.close();
		
		WorkGroup  window_A_Securities= workgroupHash.get(window_B_Securities.getWorkGroupName() + window_B_Securities.getFolder());
		
		WorkGroup  window_A_fxgroup= workgroupHash.get(window_B_fxgroup.getWorkGroupName() + window_B_fxgroup.getFolder());
		
		System.out.println(window_A_Securities.getWorkGroupName() + " " + window_A_Securities.getFolder() + " " + window_A_Securities.getTradeReference());
		
		System.out.println(window_A_fxgroup.getWorkGroupName() + " " + window_A_fxgroup.getFolder() + " " + window_A_fxgroup.getTradeReference());
	 
		Compare_windows(window_A_Securities,window_B_Securities);
		Compare_windows(window_A_fxgroup, window_B_fxgroup);
		
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
	
	}
	
      
	static int  Compare_windows ( WorkGroup windowA, WorkGroup windowB)
	{
		
		ArrayList<Integer> windowA_TradeReference = windowA.getTradeReference();
		
		ArrayList<Integer> windowB_TradeReference = windowB.getTradeReference();
		
		System.out.println(" window A size " + windowA_TradeReference.size() + " " +windowA_TradeReference );
		
		System.out.println(" window B size " + windowB_TradeReference.size()  + " " +windowB_TradeReference);
		/*  A=1,2,3
            B= 1,2,3,4
          */
		if( windowB_TradeReference.size() > windowA_TradeReference.size() && windowB_TradeReference.containsAll(windowA_TradeReference)   )
		
		{
			System.out.println("Window B has more data");
			
			windowB_TradeReference.removeAll(windowA_TradeReference);
			
			avail_b_not_a.put(windowB.getWorkGroupName()+windowB.getFolder(), windowB_TradeReference);
			
		}
		/*
		 A=1,2,3,4
		  B=1,2,3
		 */
		
		else if( windowA_TradeReference.size() > windowB_TradeReference.size() && windowA_TradeReference.containsAll(windowB_TradeReference)    )
			
		{
			System.out.println("Window A has more data");
			
			windowA_TradeReference.removeAll(windowB_TradeReference);
			avail_a_not_b.put(windowA.getWorkGroupName()+windowA.getFolder(), windowA_TradeReference);
			
		}
		
        		
         /*
          * A=1,2,3
          * B=1,2,3
          */
		else if( (windowA_TradeReference.size() == windowB_TradeReference.size() &&  windowA_TradeReference.containsAll(windowB_TradeReference))  )
 			
 		{
 			System.out.println("Both Window has same data");
 		}

        /*
         * A=1,2,3
         * B=2,3,4
         * ----------
         * A= 1,2,3
         * B= 2,3,4,5
         * ------------
         * A=1,2,3,4
         * B=3,4,5
         */
		else if(( windowA_TradeReference.size() == windowB_TradeReference.size() &&
        		    ! windowA_TradeReference.containsAll(windowB_TradeReference)) ||  windowA_TradeReference.size() !=windowB_TradeReference.size()       )
  			
  		{
  			System.out.println("There is difference between window A and Window B");
  
  			  ArrayList<Integer> tmp=(ArrayList<Integer>)(windowA_TradeReference.clone());
  			  tmp.removeAll(windowB_TradeReference);
  			
  			  if(!tmp.isEmpty())
  			  {
  				  avail_a_not_b.put(windowA.getWorkGroupName() + windowA.getFolder(),tmp);
  			  }
  			
  			 tmp =(ArrayList<Integer>)(windowB_TradeReference.clone());
  			 tmp.removeAll(windowA_TradeReference);
  			 
  		     if(!tmp.isEmpty())
  		     {
  		    	 avail_b_not_a.put(windowB.getWorkGroupName() + windowB.getFolder(),tmp);
  			
  		     }
  		}

		 System.out.println(" Avail a not b " + avail_a_not_b.get(windowA.getWorkGroupName() + windowA.getFolder()));
			
			System.out.println(" Avail b not a " + avail_b_not_a.get(windowB.getWorkGroupName() + windowB.getFolder()));
			 
		return 0;
		
	}
	
}
