
public class Bike {
	private String id;
	private BikeOwner owner;
	private String barcode;
	private boolean checked_in;
	
	public Bike(BikeOwner owner, String id){
		
		this.owner = owner;
		checked_in = false;
		this.id = id;
		
	}
	public void remove(){
		//TODO	
	}	
	
	public String toString(){
		return id;
	}
	
	public BikeOwner getOwner(){
		return owner;
	}
}
