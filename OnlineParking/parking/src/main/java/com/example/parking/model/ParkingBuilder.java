  package com.example.parking.model;
  
  import java.util.ArrayList;
  
  /**
   * Builder class to get a parking instance
   */
  public class ParkingBuilder {
  	
  	private Integer size;
  	private ArrayList<Integer> pedestrianExits = new ArrayList<Integer>();
  	private ArrayList<Integer> disabledBays = new ArrayList<Integer>();
  
      public ParkingBuilder withSquareSize(final int size) {
         this.size = size;
         return this;
      }
  
      public ParkingBuilder withPedestrianExit(final int pedestrianExitIndex) {
          this.pedestrianExits.add(pedestrianExitIndex);
          return this;
      }
  
      public ParkingBuilder withDisabledBay(final int disabledBayIndex) {
      	 this.disabledBays.add(disabledBayIndex);
           return this;
      }
  
      public Parking build() {
          Parking parking =  new Parking(this.size);
          ParkingBay bay = null;
          
          for(int i=0; i<(this.size*this.size); i++) {
          	bay = new ParkingBay(i, pedestrianExits.contains(i), disabledBays.contains(i), parking);
           	parking.addBay(bay);
          }
                 
          pedestrianExits.stream().forEach(peIndex -> parking.getBays().stream().forEach(p -> p.setDistanceToExit(Integer.min(p.getDistanceToExit(), Math.abs(peIndex -p.getIndex())))));
          
          return parking;
      }
  }
