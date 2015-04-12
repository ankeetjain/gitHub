package com.scjp;

import java.io.Serializable;
import java.util.ArrayList;

public class WorkGroup implements Serializable {

	public String workGroupName;
	public String folder;
	public String tradeId;
	public ArrayList<Integer> tradeReference;
	
	public ArrayList<Integer> getTradeReference() {
		return tradeReference;
	}
	public void setTradeReference(ArrayList<Integer> tradeReference) {
		this.tradeReference = tradeReference;
	}
	public String getWorkGroupName() {
		return workGroupName;
	}
	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
}
