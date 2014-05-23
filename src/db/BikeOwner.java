package db;

import db.Bike;

import javax.xml.crypto.Data;
import java.util.ArrayList;


public class BikeOwner extends Model {
    public static String modelName = "BikeOwner";

    private String name;
	private String ssn;
	private String email;
	private ArrayList<Bike> bikes;
	private String pin;


	public BikeOwner(String name, String ssn, String email){
        super(modelName);
		this.name = name;
		this.ssn = ssn;
		this.email = email;
		bikes = new ArrayList<Bike>();
		//pin = boms.generatePIN();
		save();
	}

    public void addBike(Bike bike){
        bikes.add(bike);
        save();
    }

    public void addBike(){
        Bike bike = new Bike(this);
        addBike(bike);
    }

	public void removeBike(Bike bike){
		bikes.remove(bike);
	}

	public void removeAllBikes(){
		bikes.clear();
	}

    public String getName() {
        return name;
    }

    public String getSSN() {
        return ssn;
    }

    public ArrayList<Bike> getBikes(){
    	return bikes;
    }

    public static BikeOwner getBySSN(String ssn) {
        for(Model b : DatabaseManager.dbm.getTable(modelName)) {
            BikeOwner bikeowner = (BikeOwner)b;
            if(ssn.equals(bikeowner.getSSN())) {
                return bikeowner;
            }
        }
        return null;
    }

    public static BikeOwner getByName(String name) {
        for(Model b : DatabaseManager.dbm.getTable(modelName)) {
            BikeOwner bikeowner = (BikeOwner)b;
            if(name.equals(bikeowner.getName())) {
                return bikeowner;
            }
        }
        return null;
    }

	public String toString(){
		return "{BIKEOWNER | name: " + name + ", ssn: " + ssn + "}";
	}

    public static Table getTable() {
        return DatabaseManager.dbm.getTable(modelName);
    }

}
