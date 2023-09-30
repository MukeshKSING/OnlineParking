  package com.example.parking.config;
  
  import org.glassfish.jersey.server.ResourceConfig;
  import org.springframework.stereotype.Component;
  
  import com.example.parking.components.ParkingController;
  
  @Component
  public class ParkingConfig extends ResourceConfig {
  
  	public ParkingConfig() {
  		register(ParkingController.class);
  	}
  }
