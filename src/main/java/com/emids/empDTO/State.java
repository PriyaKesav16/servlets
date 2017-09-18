package com.emids.empDTO;

public class State {
	
	private int stateId;
	private String stateName;
	
	
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + "]";
	}
	
	public State(int stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}
	

}
