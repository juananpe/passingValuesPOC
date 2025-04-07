package eus.ehu.template.businessLogic;

import eus.ehu.template.configuration.Config;
import eus.ehu.template.dataAccess.DataAccess;
import javafx.scene.paint.Color;

import java.util.Calendar;


/**
 * Implements the business logic as a web service.
 */
public class BlFacadeImplementation implements BlFacade {

    DataAccess dbManager;
    Config config = Config.getInstance();
    
    // Store the selected color - not related to database
    private static Color selectedColor = Color.BLACK;

    private static BlFacadeImplementation bl = null;

    public static BlFacadeImplementation getInstance() {
        if (bl == null) {
            bl = new BlFacadeImplementation(false); // Don't initialize DB by default
        }
        return bl;
    }
    
    // Constructor with option to initialize DB or not
    private BlFacadeImplementation(boolean initDB) {
        System.out.println("Creating BlFacadeImplementation instance");
        if (initDB) {
            try {
                boolean initialize = config.getDataBaseOpenMode().equals("initialize");
                dbManager = new DataAccess();
                if (initialize)
                    dbManager.initializeDB();
            } catch (Exception e) {
                System.err.println("Error initializing database: " + e.getMessage());
                // Continue without DB functionality
            }
        }
    }
    
    private BlFacadeImplementation() {
        this(true); // Default constructor still tries to initialize DB
    }
    
    /**
     * Sets the selected color - does not require database
     * @param color the color to set
     */
    public void setSelectedColor(Color color) {
        selectedColor = color;
    }
    
    /**
     * Gets the selected color - does not require database
     * @return the selected color
     */
    public Color getSelectedColor() {
        return selectedColor;
    }

}
