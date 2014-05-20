package db;

import junit.framework.TestCase;

public class DBTest extends TestCase {
    public DatabaseManager dbm;

    @org.junit.Before
    public void setUp() throws Exception {
        this.dbm = new DatabaseManager();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    public void testBikeOwner() {
        BikeOwner bikeowner = new BikeOwner("Erik", "94XXXX-XXXX", "erik@example.com");
        bikeowner.addBike(new Bike(bikeowner, "bArC0d3"));

        bikeowner.save();
        assertNotNull(BikeOwner.getByName("Erik"));
    }

}
