package eus.ehu.template.ui;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * Shared model class to store UI state between controllers
 */
public class ColorModel {
    // Singleton instance
    private static final ColorModel instance = new ColorModel();
    
    // The color property that will be bound to UI elements
    private final ObjectProperty<Color> colorProperty = new SimpleObjectProperty<>(Color.BLACK);
    
    private ColorModel() {
        // Private constructor for singleton
    }
    
    public static ColorModel getInstance() {
        return instance;
    }
    
    // Getter for the color property
    public ObjectProperty<Color> colorProperty() {
        return colorProperty;
    }
    
    // Convenience getter for the color value
    public Color getColor() {
        return colorProperty.get();
    }
    
    // Convenience setter for the color value
    public void setColor(Color color) {
        colorProperty.set(color);
    }
} 