package db;

import java.util.HashMap;
import java.util.Iterator;

public class Table implements Iterable<Model> {
    private String modelName;
    private HashMap<String, Model> rows;

    // TODO: Support indexing?

    public Table(String modelName) {
        this.modelName = modelName;
        rows = new HashMap<String, Model>();
    }

    public void save(Model m) {
        rows.put(m.id, m);
    }

    public void remove(Model m) {
        // TODO
    }

    public int maxID() {
        int max = 0;
        for (String is : rows.keySet()) {
            int i = Integer.getInteger(is);
            if (i > max) max = i;
        }
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
