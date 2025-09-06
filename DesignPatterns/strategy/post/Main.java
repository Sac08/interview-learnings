package DesignPatterns.strategy.post;

public class Main {
    public static void main(String[] args) {
        PaymentService service1 = new PaymentService(new CreditCardPayment());
        service1.processPayment(100);

        PaymentService service2 = new PaymentService(new PayPalPayment());
        service2.processPayment(200);

        PaymentService service3 = new PaymentService(new UpiPayment());
        service3.processPayment(50);
    }
}
