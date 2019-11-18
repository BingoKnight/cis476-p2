package sample.Decorators;

import sample.Controller.Controller;

public class UnitNameHandler extends Decorator {

    public UnitNameHandler(Distance distance){
        super(distance);
    }

    @Override
    public String modify(){
        String distanceStr = super.modify();
        distanceStr = distanceStr + " " + Controller.unitName;
        System.out.println("Unit Namer : " + distanceStr);
        return distanceStr;
    }
}
