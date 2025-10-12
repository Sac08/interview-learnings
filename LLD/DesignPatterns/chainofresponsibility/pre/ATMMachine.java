package LLD.DesignPatterns.chainofresponsibility.pre;

public class ATMMachine {

    public void dispense(int amount) {
        if (amount >= 100) {
            int num = amount / 100;
            int remainder = amount % 100;
            System.out.println("Dispensing " + num + " notes of ₹100");
            amount = remainder;
        }

        if (amount >= 50) {
            int num = amount / 50;
            int remainder = amount % 50;
            System.out.println("Dispensing " + num + " notes of ₹50");
            amount = remainder;
        }

        if (amount >= 20) {
            int num = amount / 20;
            int remainder = amount % 20;
            System.out.println("Dispensing " + num + " notes of ₹20");
            amount = remainder;
        }

        if (amount != 0) {
            System.out.println("Cannot dispense remaining ₹" + amount);
        }
    }

    public static void main(String[] args) {
        ATMMachine atm = new ATMMachine();
        atm.dispense(370);
    }
}
/*
Problems

Adding new denomination → edit existing logic.
Violates Open/Closed Principle (OCP).
Repeated structure → low cohesion, poor scalability.
Not flexible for configuration.
 */