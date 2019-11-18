package sample.Decorators;

import sample.Decorators.Decorator;
import sample.Decorators.Distance;

import java.text.DecimalFormat;

public class ExponentialHandler extends Decorator {

    DecimalFormat df = new DecimalFormat("0.######E0");

    public ExponentialHandler(Distance distance){
        super(distance);
    }

    @Override
    public String modify(){
        String distanceStr = super.modify();
        distanceStr = df.format(Double.parseDouble(distanceStr));
        System.out.println("Exponentialer : " + distanceStr);
        return distanceStr;
    }
}
