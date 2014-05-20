package db;

import java.util.HashMap;
import java.util.Iterator;

public class DatabaseManager {
    private static DatabaseManager dbm = new DatabaseManager();

    private HashMap<String, Table> tables;

    public DatabaseManager() {
        tables = new HashMap<String, Table>();
        // TODO: Load and save by serializing
    }

    public static DatabaseManager getDBM() {
        return dbm;
    }

    public void save(Model m) {
        tables.get(m.modelName).save(m);
    }

    public void remove(Model m) {
        tables.get(m.modelName).remove(m);
    }

    public boolean hasModel(Model m) {
        return tables.containsKey(m.modelName);
    }

    public Table getTable(String modelName) {
        return tables.get(modelName);
    }

    public Table getTable(Model m) {
        return getTable(m.modelName);

    }

    public void registerModel(Model m) {
        tables.put(m.modelName, new Table(m.modelName));
        System.out.println("Registered model: " + m.modelName);
    }

    public int newID(Model m) {
        int max_id = tables.get(m.modelName).maxID();
        return max_id+1;
    }
}

class Table implements Iterable<Model>{
    private String modelName;
    private HashMap<Integer, Model> rows;

    // TODO: Support indexing?

    public Table(String modelName) {
        this.modelName = modelName;
        rows = new HashMap<Integer, Model>();
    }

    public void save(Model m) {
        rows.put(m.id, m);
    }

    public void remove(Model m) {
        // TODO
    }

    public int maxID() {
        int max = Integer.MIN_VALUE;
        for(Integer i : rows.keySet()) if (i > max) max = i;
        return max;
    }

    @Override
    public Iterator<Model> iterator() {
        return rows.values().iterator();
    }
}
