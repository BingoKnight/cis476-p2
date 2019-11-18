package sample.Decorators;

public class BasicDistance implements Distance {

    private String distance;

    public BasicDistance(String distance){
        this.distance = distance;
    }

    @Override
    public String modify(){
        return distance;
    }
}
