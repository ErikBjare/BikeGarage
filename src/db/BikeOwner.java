package db;

import db.Bike;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class BikeOwner extends Model implements Serializable {
    public static String modelName = "BikeOwner";

    private String name;
	private String ssn;
	private String email;
	private static ArrayList<Bike> bikes;
	private String pin;


	public BikeOwner(String name, String ssn, String email){
        super(modelName);
		this.name = name;
		this.ssn = ssn;
		this.email = email;
		this.bikes = new ArrayList<Bike>();
		this.pin = newPIN();
		save();
	}

    public void addBike(Bike bike){
        bikes.add(bike);
        save();
    }

    public void addBike(){
        Bike bike = new Bike(this);
        addBike(bike);
        save();
    }

	public void removeBike(Bike bike){
        bike.remove();
		bikes.remove(bike);
        save();
	}

	public void removeAllBikes(){
        for(Bike bike : bikes) {
            bike.remove();
        }
		bikes.clear();
        save();
	}

    public static String newPIN() {
        String pin;
        Random r = new Random();
        do {
            pin = Integer.toString(r.nextInt(10000));
            while(pin.length() < 4){
                pin = "0" + pin;
            }
        } while(getByPIN(pin) != null);
        return pin;
    }

    public String getName() {
        return name;
    }

    public String getPIN() {
        return pin;
    }

    public String getSSN() {
        return ssn;
    }

    public ArrayList<Bike> getBikes(){
    	return bikes;
    }

    public static BikeOwner getBySSN(String ssn) {
        for(Model b : DatabaseManager.getDBM().getTable(modelName)) {
            BikeOwner bikeowner = (BikeOwner)b;
            if(ssn.equals(bikeowner.getSSN())) {
                return bikeowner;
            }
        }
        return null;
    }

    public static BikeOwner getByPIN(String pin) {
        for(Model b : DatabaseManager.getDBM().getTable(modelName)) {
            BikeOwner bikeowner = (BikeOwner)b;
            if(pin.equals(bikeowner.getPIN())) {
                return bikeowner;
            }
        }
        return null;
    }

    public static BikeOwner getByName(String name) {
        for(Model b : DatabaseManager.getDBM().getTable(modelName)) {
            BikeOwner bikeowner = (BikeOwner)b;
            if(name.equals(bikeowner.getName())) {
                return bikeowner;
            }
        }
        return null;
    }

	public String toString(){
		return "{BIKEOWNER | name: " + name + ", ssn: " + ssn + ", email:" + email + "}";
	}

    public static Table getTable() {
        return DatabaseManager.getDBM().getTable(modelName);
    }
    
    public static boolean hasCheckedInBikes(){
    	boolean hasCheckedInBikes;
    	for(Bike b : bikes){
    		if (b.isCheckedIn()){
    			return true;
    		}
    	}
    	return false;
    }

}
