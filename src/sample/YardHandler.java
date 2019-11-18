package sample;

public class YardHandler implements Chain {

    private Chain next = null;

    @Override
    public void setNext(Chain next) {
        this.next = next;
    }

    @Override
    public double process(double distance) {
        double distInYards = distance * 1760;
        if(next == null)
            return distInYards;
        else
            return next.process(distance);
    }
}
