package sample.Chains;

public class MilesHandler implements Chain {

    private Chain next = null;

    @Override
    public void setNext(Chain next) {
        this.next = next;
    }

    @Override
    public double process(double distance) {
        double distInMiles = distance * 0.621371;
        if(next == null)
            return distInMiles;
        else
            return next.process(distInMiles);
    }
}
