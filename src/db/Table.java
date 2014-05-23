package db;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

public class Table implements Iterable<Model>, Serializable {
    public String modelName;
    private HashMap<String, Model> rows;
    private int counter = 0;

    public Table(String modelName) {
        this.modelName = modelName;
        rows = new HashMap<String, Model>();
    }

    public void save(Model m) {
        rows.put(m.id, m);
        System.out.println("Saved: " + m.toString());
    }

    public void remove(Model m) {
        rows.remove(m.id);
        System.out.println("Removed: " + m.toString());
    }

    public int maxID() {
        int max = -1;
        for (String is : rows.keySet()) {
            int i = Integer.parseInt(is);
            if (i > max) {
                max = i;
            }
        }
        System.out.println("Max " + modelName + ": " + max);
        return max;
    }

    public int size() {
        return rows.size();
    }

    @Override
    public Iterator<Model> iterator() {
        return rows.values().iterator();
    }
}
