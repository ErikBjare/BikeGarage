package db;

import javax.xml.crypto.Data;
import java.io.Serializable;

public abstract class Model implements Serializable {
	protected String id;
	public String modelName;

	public Model(String modelName) {
		this.modelName = modelName;
		this.id = Integer.toString(DatabaseManager.dbm.newID(modelName));
	}

	public void save() {
		DatabaseManager.dbm.save(this);
	}

	public void remove() {
		DatabaseManager.dbm.remove(this);
	}

}
