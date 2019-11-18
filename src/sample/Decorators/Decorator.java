package sample.Decorators;

public class Decorator implements Distance {
    private Distance distance;

    public Decorator(Distance distance){
        this.distance = distance;
    }

    @Override
    public String modify(){
        return this.distance.modify();
    }
}
