package LLD.DesignPatterns.chainofresponsibility.post;

public interface DispenseChange {
    void setNext(DispenseChange next);
    void dispense(int amt);
}
