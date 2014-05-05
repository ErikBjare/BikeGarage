public class BicycleGarageManager {

    BarcodePrinter printer;
    ElectronicLock entryLock;
    ElectronicLock exitLock;
    PinCodeTerminal terminal;

    /* Will be called when a user has pressed a key at the
     * keypad at the entry door. The following characters could be
     * pressed: '0', '1',... '9', '*', '#'. */
    public void entryCharacter(char c) {
        System.out.print("Character entered: ");
        System.out.println(c);
    }

    /* Will be called when a user has used the bar code
     * reader at the entry door. Bicycle ID should be a
     * string of 5 characters, where every character
     * can be '0', '1',... '9'. */
    public void entryBarcode(String code) {
        System.out.println("Bike with code " + code + " entered");
    }

    /* Will be called when a user has used the bar code
     * reader at the exit door. Bicycle ID should be a
     * string of 5 characters, where every
     * character can be '0', '1',... '9'. */
    public void exitBarcode(String code) {
        System.out.println("Bike with code " + code + " exited");
    }

    /* Register hardware so that BicycleGarageManager
     * knows which drivers to access.
     */
    public void registerHardwareDrivers(BarcodePrinter printer, ElectronicLock entryLock,
                                        ElectronicLock exitLock, PinCodeTerminal terminal) {
        this.printer = printer;
        this.entryLock = entryLock;
        this.exitLock = exitLock;
        this.terminal = terminal;
        terminal.register(this);
    }
}
