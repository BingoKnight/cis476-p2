package sample.Chains;

import sample.Chains.Chain;

public class FeetHandler implements Chain {

    private Chain next = null;

    @Override
    public void setNext(Chain next) {
        this.next = next;
    }

    @Override
    public double process(double distance) {
        System.out.println(distance);
        double distInFeet = distance * 3;
        if(next == null)
            return distInFeet;
        else
            return next.process(distance);
    }
}
