package LLD.DesignPatterns.chainofresponsibility.post;

public class Main {
    public static void main(String args[]) {
        int amt = 170;

        Note10Dispense note10Dispense = new Note10Dispense(10, 0);
        Note50Dispense note50Dispense = new Note50Dispense(50, 10);
        Dispense100Dispense dispense100Dispense = new Dispense100Dispense(100, 10);

        dispense100Dispense.setNext(note50Dispense);
        note50Dispense.setNext(note10Dispense);

        dispense100Dispense.dispense(amt);


    }
}
