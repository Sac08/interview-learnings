package LLD.DesignPatterns.chainofresponsibility.post;

public class Dispense100Dispense extends DispenseChainImpl{
    Dispense100Dispense(int noteValue, int noteQty) {
        super(noteValue, noteQty);
    }
}
