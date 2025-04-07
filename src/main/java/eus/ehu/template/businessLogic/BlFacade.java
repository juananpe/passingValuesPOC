package eus.ehu.template.businessLogic;

import javafx.scene.paint.Color;

// import eus.ehu.template.domain.Hello;

/**
 * Interface that specifies the business logic.
 */
public interface BlFacade  {

    // ===== Define the public interface of the BL
    
    /**
     * Sets the selected color
     * @param color the color to set
     */
    void setSelectedColor(Color color);
    
    /**
     * Gets the selected color
     * @return the selected color
     */
    Color getSelectedColor();

}
