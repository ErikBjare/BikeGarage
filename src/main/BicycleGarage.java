package main;

import bomsGUI.BikeOwnerManagementSystem;

public class BicycleGarage {
	
    public BicycleGarage() {
        BicycleGarageManager manager = new BicycleGarageManager();
        ElectronicLock entryLock = new ElectronicLockTestDriver("Entry lock");
        ElectronicLock exitLock = new ElectronicLockTestDriver("Exit lock");
        PinCodeTerminal terminal = new PinCodeTerminalTestDriver();
        manager.registerHardwareDrivers(entryLock, exitLock, terminal);
        BarcodeReader readerEntry = new BarcodeReaderEntryTestDriver();
        BarcodeReader readerExit = new BarcodeReaderExitTestDriver();
        readerEntry.register(manager);
        readerExit.register(manager);
    }
    public static void main(String[] args) {
        new BicycleGarage();
        new BikeOwnerManagementSystem();
    }
}