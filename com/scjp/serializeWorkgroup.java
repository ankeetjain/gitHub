package com.scjp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class serializeWorkgroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WorkGroup ob = new WorkGroup ();
		ob.setWorkGroupName("Securities");
		ob.setFolder("Verification");
		//ob.setTradeId("1");
		ArrayList<Integer> tradeid= new ArrayList<Integer>();
		
		for( int i=0;i<10;i++)
		{
			tradeid.add(i);
			
		}
		ob.setTradeReference(tradeid);
		
		
		WorkGroup fxgroup = new WorkGroup ();
		fxgroup.setWorkGroupName("FX");
		fxgroup.setFolder("ACK Pending");
		
		ArrayList<Integer> fxids= new ArrayList<Integer>();
		
		for( int i=5;i<23;i=i+2)
		{
			fxids.add(i);
			
		}
		fxgroup.setTradeReference(fxids);
		
		HashMap<String, WorkGroup> workgroupHash = new HashMap<String, WorkGroup>();
		
		
		workgroupHash.put(ob.getWorkGroupName()+ob.getFolder(), ob);
		workgroupHash.put(fxgroup.getWorkGroupName()+fxgroup.getFolder(),fxgroup);
		
		
		try
		{
			File file= new File("d://Books//Tradflow_Work_Group.dat");
			if (!file.exists())
			{
				file.createNewFile();
			}
			FileOutputStream fs= new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(workgroupHash);
			os.close();
		}
		catch (Exception ex)
		{ex.printStackTrace();
		}

	}

}
