package eus.ehu.template.ui;

import eus.ehu.template.businessLogic.BlFacadeImplementation;
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
    public void initialize() {
        try {
            // Apply the color when the view is initialized
            Color selectedColor = BlFacadeImplementation.getInstance().getSelectedColor();
            coloredLabel.setTextFill(selectedColor);
        } catch (Exception e) {
            System.err.println("Error in initialize: " + e.getMessage());
            e.printStackTrace();
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