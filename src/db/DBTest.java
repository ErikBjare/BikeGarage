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
        BikeOwner bikeowner = new BikeOwner("Erik", "94XXXX-XXXX", "erik@example.com");
        bikeowner.addBike();
        bikeowner.save();
        assertNotNull(BikeOwner.getByName("Erik"));
    }

    public void testSave() {
        DatabaseManager.saveToFile();
        //assertNotNull(BikeOwner);
        DatabaseManager.loadFromFile();
    }

    public void testAddMany() {
        BikeOwner bikeowner1 = new BikeOwner("Erik", "94XXXX-XXXX", "erik@example.com");
        bikeowner1.save();

        assertNull(BikeOwner.getBySSN("92XXXX-XXXX"));

        BikeOwner bikeowner2 = new BikeOwner("Olof", "92XXXX-XXXX", "olof@example.com");
        bikeowner2.save();
        BikeOwner bikeowner3 = new BikeOwner("Filip", "92XXXX-XXX1", "filip@example.com");
        bikeowner3.save();
        bikeowner3.addBike();

        BikeOwner boBySSN = BikeOwner.getBySSN("92XXXX-XXX1");
        assertNotNull(boBySSN);
        assertTrue(boBySSN.getBikes().size() > 0);
    }
}
