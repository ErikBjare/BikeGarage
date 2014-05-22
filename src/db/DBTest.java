package db;

import junit.framework.TestCase;

public class DBTest extends TestCase {
    public DatabaseManager dbm;

    @org.junit.Before
    public void setUp() throws Exception {
        this.dbm = DatabaseManager.getDBM();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    public void testBikeOwner() {
        System.out.println(dbm.getTable("BikeOwner"));

        BikeOwner bikeowner = new BikeOwner("Erik", "94XXXX-XXXX", "erik@example.com");
        bikeowner.addBike(new Bike(bikeowner));

        bikeowner.save();
        assertNotNull(BikeOwner.getByName("Erik"));

        for(Model m : dbm.getTable("BikeOwner")) {
            System.out.println(m);
        }
    }
}
