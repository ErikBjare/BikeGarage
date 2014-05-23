package db;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class DatabaseManager implements Serializable {
	private static DatabaseManager dbm = getDBM();
    private static boolean autosave = true;


	private static final String USERNAME = "ABCDEFGH";
	private static final String PASSWORD = "12345678";
	private static int loginAttempts = 0;
	private Calendar lockedTime;

	private HashMap<String, Table> tables;

	public DatabaseManager() {
        System.out.println("DB INIT");
        tables = new HashMap<String, Table>();
        for(String modelName : new String[]{BikeOwner.modelName, Bike.modelName}) {
            registerModel(modelName);
        }
	}

	public static DatabaseManager getDBM() {
        if(dbm == null) {
            boolean loaded = loadFromFile();
            if(!loaded) {
                dbm = new DatabaseManager();
            }
        }
		return dbm;
	}

    public static void saveToFile(String filename) {
        try {
            // Serialize data object to a file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(DatabaseManager.getDBM());
            out.close();
        } catch (IOException e) {
            System.out.println("There was an error");
            System.out.println(e);
        }
        System.out.println("DB SAVED");
        dbm.printTables();
    }

    public static void saveToFile() {
        saveToFile("db.ser");
    }

    public static void setAutosave(boolean val) {
        autosave = val;
    }

    public static boolean loadFromFile() {
        try {
            FileInputStream dbm = new FileInputStream("db.ser");
            ObjectInputStream reader = new ObjectInputStream(dbm);
            DatabaseManager.dbm = (DatabaseManager) reader.readObject();
            System.out.println(DatabaseManager.dbm.tables);
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("DB LOADED");
        dbm.printTables();
        return true;
    }

    public void printTables() {
        for(Table t : tables.values()) {
            System.out.println(" - " + t.modelName + " has " + t.size() + " entries");
        }
    }

    public void save(Model m) {
		tables.get(m.modelName).save(m);
        if(autosave) {
            saveToFile();
        }
	}

	public void remove(Model m) {
		tables.get(m.modelName).remove(m);
        if(autosave) {
            saveToFile();
        }
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

	public static int newID(String modelName) {
        System.out.println(DatabaseManager.getDBM().tables);
		int max_id = DatabaseManager.getDBM().tables.get(modelName).maxID();
		return max_id + 1;
	}

	public static String getPassword() {
		return PASSWORD;
	}

	public static String getUsername() {
		return USERNAME;
	}
	public void setLockedTime(Calendar cal){
		lockedTime = cal;
		saveToFile();
	}
	public Calendar getLockedTime(){
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

