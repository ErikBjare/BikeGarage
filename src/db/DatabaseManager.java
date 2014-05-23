package db;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class DatabaseManager implements Serializable {
	public static DatabaseManager dbm = new DatabaseManager();

	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	private static int loginAttempts = 0;
	private static Calendar lockedTime;

	private HashMap<String, Table> tables;

	public DatabaseManager() {
		tables = new HashMap<String, Table>();
        System.out.println("DB INIT");
        for(String modelName : new String[]{BikeOwner.modelName, Bike.modelName}) {
            registerModel(modelName);
        }
		// TODO: Load and save by serializing
	}

	public static DatabaseManager getDBM() {
		return dbm;
	}

    public static void saveToFile() {
        try {
            // Serialize data object to a file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("db.ser"));
            out.writeObject(DatabaseManager.getDBM());
            out.close();
        } catch (IOException e) {
            System.out.println("There was an error");
            System.out.println(e);
        }
        //System.out.println("Saved database to file");
        //dbm.printTables();
    }

    public static void loadFromFile() {
        try{
            FileInputStream dbm = new FileInputStream("db.ser");
            ObjectInputStream reader = new ObjectInputStream(dbm);
            DatabaseManager.dbm = (DatabaseManager) reader.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded database from file");
        //dbm.printTables();
    }

    public void printTables() {
        for(Table t : tables.values()) {
            System.out.println(t.modelName + " has " + t.size() + " entries");
        }
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

	public int newID(String modelName) {
		int max_id = tables.get(modelName).maxID();
		return max_id + 1;
	}

	public static String getPassword() {
		return PASSWORD;
	}

	public static String getUsername() {
		return USERNAME;
	}
	public static void setLockedTime(Calendar cal){
		DatabaseManager.lockedTime = cal;
	}
	public static Calendar getLockedTime(){
		return lockedTime;
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

