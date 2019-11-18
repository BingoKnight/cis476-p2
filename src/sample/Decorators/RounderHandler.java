package sample.Decorators;

import java.text.DecimalFormat;

public class RounderHandler extends Decorator {

    private DecimalFormat df = new DecimalFormat("0.00");

    public RounderHandler(Distance distance){
        super(distance);
    }

    @Override
    public String modify(){
        String distanceStr = super.modify();
        distanceStr = df.format(Double.parseDouble(distanceStr));
        System.out.println("Rounder : " + distanceStr);
        return distanceStr;
    }
}
