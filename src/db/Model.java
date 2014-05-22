package db;

import javax.xml.crypto.Data;

public abstract class Model {
	protected String id;
	public String modelName;

	public Model(String modelName) {
        System.out.println(DatabaseManager.dbm);
		this.modelName = modelName;
        System.out.println(DatabaseManager.dbm.newID(modelName));
		this.id = Integer.toString(DatabaseManager.dbm.newID(modelName));
	}

	public void save() {
		DatabaseManager.dbm.save(this);
	}

	public void remove() {
		DatabaseManager.dbm.remove(this);
	}

}
