package LLD.DesignPatterns.chainofresponsibility.post;

public class DispenseChainImpl implements  DispenseChange {

    private int noteValue;
    private int numNotes;
    private DispenseChange nextChain;

    DispenseChainImpl(int noteValue, int noteQty) {
        this.numNotes= noteQty;
        this.noteValue = noteValue;

    }

    @Override
    public void dispense(int amount) {

        if (amount >= noteValue) {
            int numToDispense = Math.min(amount / noteValue, this.numNotes);
            int remainingAmount = amount - (numToDispense * noteValue);

            if (numToDispense > 0) {
                System.out.println("Dispensing " + numToDispense + " x $" + noteValue + " note(s)");
                this.numNotes -= numToDispense;
            }

            if (remainingAmount > 0 && this.nextChain != null) {
                this.nextChain.dispense(remainingAmount);
            }
        } else if (this.nextChain != null) {
            this.nextChain.dispense(amount);
        }

    }

    @Override
    public void setNext(DispenseChange next) {
        this.nextChain = next;

    }
}
