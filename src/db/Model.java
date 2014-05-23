package db;

import javax.xml.crypto.Data;
import java.io.Serializable;

public abstract class Model implements Serializable {
	protected String id;
	public String modelName;

	public Model(String modelName) {
		this.modelName = modelName;
		this.id = Integer.toString(DatabaseManager.getDBM().newID(modelName));
		while(id.length() < 5){
			id = "0" + id;
		}
	}

	public void save() {
		DatabaseManager.getDBM().save(this);
	}

	public void remove() {
		DatabaseManager.getDBM().remove(this);
	}

}
