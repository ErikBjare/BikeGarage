package db;

import db.Bike;

import java.util.ArrayList;


public class BikeOwner extends Model {
	String name;
	String ssn;
	String email;
	ArrayList<Bike> bikes;
	String pin;
	
	public BikeOwner(String name, String ssn, String email){
        super();
		this.name = name;
		this.ssn = ssn;
		this.email = email;
		bikes = new ArrayList<>();
		//pin = boms.generatePIN();
		
	}
	
	public void addBike(Bike bike){
		bikes.add(bike);
	}
	
	public void removeBike(Bike bike){
		bikes.remove(bike);
	}
	public void removeAllBikes(){
		bikes = null;
	}
	
	public String toString(){
		return ssn;
	}
	
}
