package DesignPatterns.state.post;

public class Main {
    public static void main(String[] args) {
        VendingMachineContext machine = new VendingMachineContext();

        machine.selectItem();      // Insert coin first
        machine.insertCoin();      // Coin inserted
        machine.selectItem();      // Item selected
        machine.dispenseItem();    // Dispensing
        machine.insertCoin();      // Ready again for new cycle
    }
}

/*
✅ Advantages of State Pattern

Removes if-else/switch clutter.

Follows Open/Closed Principle (easy to add new states).

Each state encapsulates its own behavior → clean & modular.

Models real-world workflows naturally (Vending machine, TCP, Orders).

States can be tested independently.

❌ Disadvantages of State Pattern

More classes → increases code size.

State explosion if too many states.

Harder to see overall flow (spread across classes).

Overkill for simple cases with few states.
 */

