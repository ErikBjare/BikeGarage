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
        assertNotNull(BikeOwner.getByName("Erik"));
    }

    public void testSave() {
        DatabaseManager.saveToFile();
        //assertNotNull(BikeOwner);
        DatabaseManager.loadFromFile();
    }

    public void testAddMany() {
        new BikeOwner("Erik", "94XXXX-XXXX", "erik@example.com");

        assertNull(BikeOwner.getBySSN("92XXXX-XXXX"));

        new BikeOwner("Olof", "92XXXX-XXXX", "olof@example.com");
        new BikeOwner("Filip", "92XXXX-XXX1", "filip@example.com");

        BikeOwner boBySSN = BikeOwner.getBySSN("92XXXX-XXX1");
        assertNotNull(boBySSN);
    }

    public void testAddBikes() {
        BikeOwner bikeOwner = new BikeOwner("Bikeswagger", "666666-1337", "bikeguy@example.com");
        for(int i=0; i<10; i++) {
            bikeOwner.addBike();
        }
        assertTrue(bikeOwner.getBikes().size() == 10);
    }
}
