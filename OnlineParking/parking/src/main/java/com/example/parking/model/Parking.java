  package com.example.parking.model;
  
  import java.util.HashSet;
  import java.util.Set;
  
  import javax.persistence.CascadeType;
  import javax.persistence.Entity;
  import javax.persistence.FetchType;
  import javax.persistence.GeneratedValue;
  import javax.persistence.Id;
  import javax.persistence.OneToMany;
  
  import io.swagger.annotations.ApiModel;
  import io.swagger.annotations.ApiModelProperty;
  
  @Entity
  @ApiModel(description="All details about the parking. ")
  public class Parking {
  	@Id
  	@GeneratedValue
  	private Long id;
  	
  	@ApiModelProperty
  	private Integer size;
  	
  	@OneToMany(mappedBy = "parking", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  	private Set<ParkingBay> bays = new HashSet<ParkingBay>();
  	
  	public Parking() {
  		super();
  	}
  
  	public Parking(Integer size) {
  		super();
  		this.size = size;
  	}
  
  	public Long getId() {
  		return id;
  	}
  
  	public void setId(Long id) {
  		this.id = id;
  	}
  
  	public Integer getSize() {
  		return size;
  	}
  
  	public void setSize(Integer size) {
  		this.size = size;
  	}
  
  	public void addBay(ParkingBay bay) {
  		this.getBays().add(bay);
  	}
  
  	public Set<ParkingBay> getBays() {
  		return bays;
  	}
  
  	public void setBays(Set<ParkingBay> bays) {
  		this.bays = bays;
  	}
  	
  	
  		
  }
