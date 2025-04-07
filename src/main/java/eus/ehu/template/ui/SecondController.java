package eus.ehu.template.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SecondController {
    @FXML
    private Label coloredLabel;
    
    @FXML
    private Label colorNameLabel;
    
    // Reference to the shared model
    private final ColorModel colorModel = ColorModel.getInstance();
    
    @FXML
    public void initialize() {
        try {
            // Bind the text fill property directly to the color property in the model
            coloredLabel.textFillProperty().bind(colorModel.colorProperty());
            
            // Set the color name text
            Color currentColor = colorModel.getColor();
            String colorName = getColorName(currentColor);
            colorNameLabel.setText("Selected color: " + colorName);
        } catch (Exception e) {
            System.err.println("Error in initialize: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Helper method to get the color name from a Color object
     */
    private String getColorName(Color color) {
        if (color.equals(Color.RED)) {
            return "Red";
        } else if (color.equals(Color.GREEN)) {
            return "Green";
        } else if (color.equals(Color.BLUE)) {
            return "Blue";
        } else {
            return "Unknown";
        }
    }
    
    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error navigating back: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 