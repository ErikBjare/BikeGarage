package db;

public class Bike extends Model {
    public static String modelName = "Bike";

    private String id;
	private BikeOwner owner;
	private String barcode;
	private boolean checkedIn;

	public Bike(BikeOwner owner, String id){
        super(modelName);
		this.owner = owner;
		this.checkedIn = false;
		this.id = id;
	}


	public String toString(){
		return id;
	}

    public String getBarcode() {
        return barcode;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public static Bike getByBarcode(String barcode) {
        for(Model b : dbm.getTable(modelName)) {
            Bike bike = (Bike)b;
            if(barcode.equals(bike.getBarcode())) {
                return bike;
            }
        }
        return null;
    }
	
	public BikeOwner getOwner(){
		return owner;
	}
}
