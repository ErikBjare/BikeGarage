package db;

public abstract class Model {
	protected static DatabaseManager dbm = DatabaseManager.getDBM();
	protected String id;
	public String modelName;

	public Model(String modelName) {
		this.modelName = modelName;
		if (!dbm.hasModel(this)) {
			dbm.registerModel(this);
		}
		this.id = Integer.toString(dbm.newID(this));
	}

	public void save() {
		dbm.save(this);
	}

	public void remove() {
		dbm.remove(this);
	}
}
