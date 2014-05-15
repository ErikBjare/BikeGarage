package db;

public abstract class Model {
    private static DatabaseManager dbm = DatabaseManager.getDBM();
    private int id;


    public Model() {
        this.id = dbm.newID(this);
        if(dbm.hasModel(this)) {
            dbm.registerModel(this);
        }
    }

    public void save() {
        dbm.save(this);
    }

    public void remove(){
        dbm.remove(this);
    }

    public String getModelName() {
        return this.getClass().getName();
    }

}
