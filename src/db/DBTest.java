package db;

import junit.framework.TestCase;

public class DBTest extends TestCase {

    @org.junit.Before
    public void setUp() throws Exception {
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

    public void testSaveLoad() {
        BikeOwner bo = new BikeOwner("Saver Loader", "123", "asd@asd.com");
        bo.addBike();
        bo.addBike();
        bo.addBike();
        bo.addBike();
        DatabaseManager.loadFromFile();

        bo = BikeOwner.getBySSN("123");
        assertNotNull(bo);
    }

    public void testMax() {
        BikeOwner bikeOwner;
        for(int i=0; i<5001; i++) {
            bikeOwner = new BikeOwner("User "+i, Integer.toString(i), "someone@example.com");
            //bikeOwner.addBike();
        }
        DatabaseManager.saveToFile();
    }
}
