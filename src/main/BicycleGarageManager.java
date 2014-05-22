package main;
import java.util.Date;

public class BicycleGarageManager {

    ElectronicLock entryLock;
    ElectronicLock exitLock;
    PinCodeTerminal terminal;

    String enteredPin = "";
    Date beganEntering = null;
    

    /* Will be called when a user has pressed a key at the
     * keypad at the entry door. The following characters could be
     * pressed: '0', '1',... '9', '*', '#'. */
    public void entryCharacter(char c) {
        if (beganEntering == null) {
            beganEntering = new Date();
        } else if (beganEntering.getTime()+1000*60 < new Date().getTime()) {
            // If began entering more than 60 seconds ago
            terminal.lightLED(PinCodeTerminal.RED_LED, 3);
            beganEntering = null;
            enteredPin = "";
            return;
        }

        enteredPin += c;
        if (enteredPin.length() == 4) {
            beganEntering = null;
            authenticateBikeOwner(enteredPin);
            enteredPin = "";
        }
    }

    public void authenticateBikeOwner(String pin) {
        System.out.println("Someone ran authenticateBikeOwner! pin: " + pin);
       // TODO: Authenticate bike owner from DB
    }

    /* Will be called when a user has used the bar code
     * reader at the entry door. Bicycle ID should be a
     * string of 5 characters, where every character
     * can be '0', '1',... '9'. */
    public void entryBarcode(String code) {
        System.out.println("Bike with code " + code + " entered");

       // TODO: If barcode belongs to bike which has access to the garage open entry lock
    }

    /* Will be called when a user has used the bar code
     * reader at the exit door. Bicycle ID should be a
     * string of 5 characters, where every
     * character can be '0', '1',... '9'. */
    public void exitBarcode(String code) {
        System.out.println("Bike with code " + code + " exited");

       // TODO: If barcode belongs to bike in garage open exit lock
    }

    /* Register hardware so that BicycleGarageManager
     * knows which drivers to access.
     */
    public void registerHardwareDrivers(ElectronicLock entryLock, ElectronicLock exitLock,
                                        PinCodeTerminal terminal) {
        this.entryLock = entryLock;
        this.exitLock = exitLock;
        this.terminal = terminal;
        terminal.register(this);
    }
}
