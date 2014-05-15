package db;

import java.util.HashMap;

public class DatabaseManager {
    private static DatabaseManager dbm = new DatabaseManager();

    private HashMap<String, Table> tables;

    public DatabaseManager() {
        tables = new HashMap<>();
        // ToDo: Load and save by serializing
    }

    public static DatabaseManager getDBM() {
        return dbm;
    }

    public void save(Model m) {
        tables.get(m.getModelName()).save(m);
    }

    public void remove(Model m) {
        tables.get(m.getModelName()).remove(m);
    }

    public boolean hasModel(Model m) {
        return tables.containsKey(m.getModelName());
    }

    public void registerModel(Model m) {
        tables.put(m.getModelName(), new Table(m.getModelName()));
    }

    public int newID(Model m) {
        int max_id = tables.get(m.getModelName()).maxID();
        return max_id+1;
    }
}

class Table {
    private String modelName;
    private HashMap<Integer, Model> rows = new HashMap<>();

    // ToDo: Support indexing?

    public Table(String modelName) {
        this.modelName = modelName;
    }

    public void save(Model m) {
        // ToDo
    }

    public void remove(Model m) {
        // ToDo
    }

    public int maxID() {
        int max = Integer.MIN_VALUE;
        for(Integer i : rows.keySet()) if (i > max) max = i;
        return max;
    }
}
