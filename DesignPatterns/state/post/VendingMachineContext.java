package DesignPatterns.state.post;

class VendingMachineContext {
    private VendingState state;

    public VendingMachineContext() {
        this.state = new IdleState(this); // initial state
    }

    public void setState(VendingState state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void selectItem() {
        state.selectItem();
    }

    public void dispenseItem() {
        state.dispenseItem();
    }
}
