package sample;

public class FeetHandler implements Chain {

    private Chain next = null;

    @Override
    public void setNext(Chain next) {
        this.next = next;
    }

    @Override
    public double process(double distance) {
        double distInFeet = distance * 3;
        if(next == null)
            return distInFeet;
        else
            return next.process(distance);
    }
}
