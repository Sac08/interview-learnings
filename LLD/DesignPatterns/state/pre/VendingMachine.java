package LLD.DesignPatterns.state.pre;
class VendingMachine {
    private String state = "IDLE";

    public void insertCoin() {
        if (state.equals("IDLE")) {
            System.out.println("Coin inserted. Please select an item.");
            state = "HAS_COIN";
        } else if (state.equals("HAS_COIN")) {
            System.out.println("Coin already inserted.");
        } else if (state.equals("DISPENSE")) {
            System.out.println("Wait, dispensing in progress.");
        }
    }

    public void selectItem() {
        if (state.equals("HAS_COIN")) {
            System.out.println("Item selected. Ready to dispense.");
            state = "DISPENSE";
        } else {
            System.out.println("Insert coin first.");
        }
    }

    public void dispenseItem() {
        if (state.equals("DISPENSE")) {
            System.out.println("Dispensing item...");
            state = "IDLE";
        } else {
            System.out.println("Cannot dispense item now.");
        }
    }
}

