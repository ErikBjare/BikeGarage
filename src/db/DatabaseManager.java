package db;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class DatabaseManager {
	private static DatabaseManager dbm;

	private static final String USERNAME = "OLOF";
	private static final String PASSWORD = "YOLOF";
	private static int loginAttempts = 0;
	private static Calendar cal;

	private HashMap<String, Table> tables;

	public DatabaseManager() {
		tables = new HashMap<String, Table>();
        for(String modelName : new String[]{BikeOwner.modelName, Bike.modelName}) {
            registerModel(modelName);
        }
		// TODO: Load and save by serializing
	}

	public static DatabaseManager getDBM() {
        if(dbm == null) dbm = new DatabaseManager();
		return dbm;
	}

	public void save(Model m) {
		tables.get(m.modelName).save(m);
	}

	public void remove(Model m) {
		tables.get(m.modelName).remove(m);
	}

    public boolean hasModel(String modelName) {
        return tables.containsKey(modelName);
    }

    public boolean hasModel(Model m) {
        return hasModel(m.modelName);
    }

	public Table getTable(String modelName) {
		return tables.get(modelName);
	}

	public Table getTable(Model m) {
		return getTable(m.modelName);

	}

    public void registerModel(String modelName) {
        if(!hasModel(modelName)) {
            tables.put(modelName, new Table(modelName));
            System.out.println("Registered model: " + modelName);
        }
    }

    public void registerModel(Model m) {
        registerModel(m.modelName);
    }

	public int newID(Model m) {
		int max_id = tables.get(m.modelName).maxID();
		return max_id + 1;
	}

	public static String getPassword() {
		return PASSWORD;
	}

	public static String getUsername() {
		return USERNAME;
	}
	public static void setLockedTime(Calendar cal){
		DatabaseManager.cal = cal;
	}
	public static Calendar getLockedTime(){
		return cal;
	}

	/**
	 * @return current failed login attempts
	 */
	
	public static int wrongLogin() {
		return loginAttempts++;
	}
	
	public static void correctLogin(){
		loginAttempts = 0;
	}

}

