package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.Chains.Chain;
import sample.Chains.FeetHandler;
import sample.Chains.MilesHandler;
import sample.Chains.YardHandler;
import sample.Decorators.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<String> distComboBox;
    @FXML
    private TextField inputDist;
    @FXML
    private TextField outputDist;

    private Chain milesChain, yardsChain, feetChain;

    public static String unitName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        distComboBox.getItems().setAll("Miles", "Yards", "Feet");
        distComboBox.setValue("Miles");
    }

    @FXML
    public void convertDistance(ActionEvent e){
        double convertedDist = 0.0;
        double inputDouble = Double.parseDouble(inputDist.getText());

        switch (distComboBox.getValue()){
            case "Feet":
                milesChain = new MilesHandler();
                yardsChain = new YardHandler();
                feetChain = new FeetHandler();
                milesChain.setNext(yardsChain);
                yardsChain.setNext(feetChain);
                convertedDist = milesChain.process(inputDouble);
                unitName = "Feet";
                break;
            case "Yards":
                milesChain = new MilesHandler();
                yardsChain = new YardHandler();
                milesChain.setNext(yardsChain);
                convertedDist = milesChain.process(inputDouble);
                unitName = "Yards";
                break;
            case "Miles":
                milesChain = new MilesHandler();
                convertedDist = milesChain.process(inputDouble);
                unitName = "Miles";
        }

        String convertedDistStr = Double.toString(convertedDist);
        Decorator modifiedDist = new UnitNameHandler(new ExponentialHandler(new RounderHandler(new BasicDistance(convertedDistStr))));
        outputDist.setText(modifiedDist.modify());

        System.out.println("Distance converted = " + modifiedDist.modify());
    }
}
