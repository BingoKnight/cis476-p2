package sample;

public interface Chain {
    public abstract void setNext(Chain next);
    public abstract double process(double distance);
}
