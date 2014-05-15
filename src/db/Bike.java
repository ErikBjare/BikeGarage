package db;

public class Bike extends Model {
	private String id;
	private BikeOwner owner;
	private String barcode;
	private boolean checked_in;
	
	public Bike(BikeOwner owner, String id){
        super();
		this.owner = owner;
		checked_in = false;
		this.id = id;
	}


	public String toString(){
		return id;
	}
	
	public BikeOwner getOwner(){
		return owner;
	}
}
