package DesignPatterns.strategy.pre;

class PaymentService {
    public void pay(String type, double amount) {
        if (type.equals("credit")) {
            System.out.println("Paid " + amount + " using Credit Card");
        } else if (type.equals("paypal")) {
            System.out.println("Paid " + amount + " using PayPal");
        } else if (type.equals("upi")) {
            System.out.println("Paid " + amount + " using UPI");
        }
    }
}
/*
Problems:
Violates Open/Closed Principle (every new payment method → modify code).
Too many if-else → messy.
Hard to test each payment flow separately.
 */

