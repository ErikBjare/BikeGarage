public class BicycleGarageManager {

    public void entryCharacter(char c) {
        System.out.print("Character entered: ");
        System.out.println(c);
    }

    public void entryBarcode(String code) {
        System.out.println("Bike with code " + code + " entered");
    }

    public void exitBarcode(String code) {
        System.out.println("Bike with code " + code + " exited");
    }

    public void registerHardwareDrivers(BarcodePrinter printer, ElectronicLock entryLock,
                                        ElectronicLock exitLock, PinCodeTerminal terminal) {

    }
}
