package db;

import java.io.Serializable;
import java.util.ArrayList;

public class Bike extends Model implements Serializable {
    public static String modelName = "Bike";

	private BikeOwner owner;
	private String barcode;
	private boolean checkedIn;

	public Bike(BikeOwner owner){
        super(modelName);
		this.owner = owner;
		this.checkedIn = false;
        save();
	}

	public String toString(){
		return "{BIKE | id: " + id + ", owner: " + owner.toString() + "}";
	}

    public String getBarcode() {
        return barcode;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public static Bike getByBarcode(String barcode) {
        for(Model b : getTable()) {
            Bike bike = (Bike)b;
            if(barcode.equals(bike.getBarcode())) {
                return bike;
            }
        }
        return null;
    }
    
    public static ArrayList<Bike> getCheckedIn(){
    	ArrayList<Bike> checkedInBikes = new ArrayList<Bike>();
    	
        for(Model b : getTable()) {
        	Bike bike = (Bike)b;
            if(bike.checkedIn) {
            	checkedInBikes.add(bike);
            }
        }
        return checkedInBikes;
    }
	
	public BikeOwner getOwner(){
		return owner;
	}

    public String getID() {
        return id;
    }
    
    public void setCheckedIn(){
    	checkedIn = true;
        save();
    }

    public static Table getTable() {
        return DatabaseManager.dbm.getTable(modelName);
    }
}
