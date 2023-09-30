  package com.example.parking.components.data;
  
  import java.util.ArrayList;
  
  public class ParkingData {
  
  	private Integer size;
  	private ArrayList<Integer> pedestrianExits = new ArrayList<Integer>();
  	private ArrayList<Integer> disabledBays = new ArrayList<Integer>();
  	
  	public ParkingData() {
  		super();
  	}
  
  	public Integer getSize() {
  		return size;
  	}
  
  	public void setSize(Integer size) {
  		this.size = size;
  	}
  
  	public ArrayList<Integer> getPedestrianExits() {
  		return pedestrianExits;
  	}
  
  	public void setPedestrianExits(ArrayList<Integer> pedestrianExits) {
  		this.pedestrianExits = pedestrianExits;
  	}
  
  	public ArrayList<Integer> getDisabledBays() {
  		return disabledBays;
  	}
  
  	public void setDisabledBays(ArrayList<Integer> disabledBays) {
  		this.disabledBays = disabledBays;
  	}
  	
  	
  }
