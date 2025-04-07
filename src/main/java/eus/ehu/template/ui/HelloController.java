package eus.ehu.template.ui;

import eus.ehu.template.businessLogic.BlFacadeImplementation;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class HelloController {
    @FXML
    private ToggleGroup colorToggleGroup;
    
    @FXML
    private Label welcomeText;

    @FXML
    private void handleColorChange(ActionEvent event) {
        try {
            RadioButton selectedRadioButton = (RadioButton) colorToggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                String colorName = selectedRadioButton.getUserData().toString();
                Color selectedColor;
                
                switch (colorName) {
                    case "RED":
                        selectedColor = Color.RED;
                        break;
                    case "GREEN":
                        selectedColor = Color.GREEN;
                        break;
                    case "BLUE":
                        selectedColor = Color.BLUE;
                        break;
                    default:
                        selectedColor = Color.BLACK;
                        break;
                }
                
                // Store the selected color in the business logic
                BlFacadeImplementation.getInstance().setSelectedColor(selectedColor);
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
                Parent root = loader.load();
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.err.println("Error in handleColorChange: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
