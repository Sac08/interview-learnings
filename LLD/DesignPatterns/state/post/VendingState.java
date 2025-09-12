package LLD.DesignPatterns.state.post;

abstract class VendingState {
    VendingMachineContext context;
    VendingState(VendingMachineContext vendingMachineContext) {
        this.context = vendingMachineContext;
    }
    abstract void insertCoin();
    abstract void selectItem();
    abstract void dispenseItem();
}

class IdleState extends VendingState {


    IdleState(VendingMachineContext vendingMachineContext) {
        super(vendingMachineContext);
    }

    public void insertCoin() {
        System.out.println("Coin inserted. Please select an item.");
        context.setState(new ItemSelectedState(context));
    }

    public void selectItem() {
        System.out.println("Insert coin first.");
    }

    public void dispenseItem() {
        System.out.println("Insert coin and select item first.");
    }
}

class ItemSelectedState extends VendingState {
    ItemSelectedState(VendingMachineContext vendingMachineContext) {
        super(vendingMachineContext);
    }

    public void insertCoin() {
        System.out.println("Coin already inserted. Select an item.");
    }

    public void selectItem() {
        System.out.println("Item selected. Ready to dispense.");
        context.setState(new DispenseState(context));
    }

    public void dispenseItem() {
        System.out.println("Please select an item first.");
    }
}

class DispenseState extends VendingState {
    DispenseState(VendingMachineContext vendingMachineContext) {
        super(vendingMachineContext);
    }

    public void insertCoin() {
        System.out.println("Please wait, dispensing item.");
    }

    public void selectItem() {
        System.out.println("Already dispensing. Please wait.");
    }

    public void dispenseItem() {
        System.out.println("Dispensing item...");
        context.setState(new IdleState(context)); // Back to idle after dispensing
    }
}
