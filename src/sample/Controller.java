package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        distComboBox.getItems().setAll("Miles", "Yards", "Feet");
        distComboBox.setValue("Miles");
    }

    @FXML
    public void convertDistance(ActionEvent e){
        double convertedDist = 0.0;

        System.out.println(inputDist.getText());

        switch (distComboBox.getValue()){
            case "Feet":
                milesChain = new MilesHandler();
                yardsChain = new YardHandler();
                feetChain = new FeetHandler();
                milesChain.setNext(yardsChain);
                yardsChain.setNext(feetChain);
                convertedDist = milesChain.process(Double.parseDouble(inputDist.getText()));
                break;
            case "Yards":
                milesChain = new MilesHandler();
                yardsChain = new YardHandler();
                milesChain.setNext(yardsChain);
                convertedDist = milesChain.process(Double.parseDouble(inputDist.getText()));
                break;
            case "Miles":
                milesChain = new MilesHandler();
                convertedDist = milesChain.process(Double.parseDouble(inputDist.getText()));
        }

        outputDist.setText(Double.toString(convertedDist));

        System.out.println("Distance converted");
    }
}
