  package com.example.parking.model;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.stereotype.Repository;
  
  @Repository
  public interface ParkingBayRepository extends JpaRepository<ParkingBay, Long>{
  	
  	int countByParkingIdAndPedestrianExitFalseAndParkedCarNull(Long id);
  	ParkingBay findByParkingIdAndIndex(Long id, Integer index);
  
  }
