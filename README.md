# JavaFX UI State Management Experiment

This project demonstrates two different approaches to managing UI state in a JavaFX application, specifically for passing a selected color between different views. Both approaches solve the same problem but showcase different architectural patterns.

## The Application

The application has two screens:
1. A first screen with radio buttons for selecting a color (Red, Green, or Blue)
2. A second screen that displays text in the selected color

## Approach 1: Business Logic as Intermediary

### Implementation:
- Uses `BlFacadeImplementation` to store and retrieve the selected color
- Controllers access the business logic layer to share UI state
- The business logic acts as a data store between UI components

### Pros:
- Follows a centralized state management pattern
- Business logic could potentially apply validation rules or transformations
- Could integrate with other business services if needed
- Works well in applications where UI state needs business processing

### Cons:
- Unnecessarily involves the business layer for what is a UI concern
- Creates dependencies between UI and business layers
- More verbose implementation
- Not reactive (requires explicit get/set calls)
- Potential issues with lifecycle management of business objects
- May lead to business logic layer acting as a "catch-all" for app state

## Approach 2: JavaFX Property Binding with UI Model

### Implementation:
- Creates a dedicated `ColorModel` with JavaFX properties
- Uses direct binding between UI elements and model properties
- Leverages reactive programming paradigm

### Pros:
- Clear separation of concerns (UI state stays in UI layer)
- Reactive: UI automatically updates when model changes
- More idiomatic JavaFX approach
- No dependency on business logic for UI concerns
- More concise and direct implementation
- Better encapsulation of UI state
- Easier to extend with additional UI properties

### Cons:
- Requires understanding of JavaFX property binding system
- Introduces a new class just for UI state
- Additional complexity for simple applications

## Combining the Approaches

The UI model approach can incorporate business logic processing when needed:

```java
public class ColorModel {
    private final ObjectProperty<Color> colorProperty = new SimpleObjectProperty<>();
    private final BlFacadeImplementation businessLogic = BlFacadeImplementation.getInstance();
    
    // Method that incorporates business processing
    public void setColorWithValidation(Color requestedColor) {
        // Business logic can validate, transform or process the color
        Color processedColor = businessLogic.validateAndProcessColor(requestedColor);
        colorProperty.set(processedColor);
    }
    
    // The property binding still works the same way
    public ObjectProperty<Color> colorProperty() {
        return colorProperty;
    }
}
```

### Benefits of This Combined Approach:

1. **Maintains Separation of Concerns:**
   - UI components only interact with the UI model
   - Business logic remains focused on business rules
   - UI model mediates between the two

2. **Retains Reactive Benefits:**
   - UI still updates automatically through property binding
   - No need for explicit refresh calls when state changes

3. **Enforces Business Rules:**
   - Business validation and processing still applied
   - Consistent business rules across the application

4. **More Flexible:**
   - Can handle both simple UI state and complex business state
   - Scales better as application complexity grows

## When to Use Each Approach

**Use Business Logic Approach When:**
- The state requires validation or transformation by business rules
- The state is persisted to a database or external system
- The state represents actual business data rather than just UI state
- You need to maintain a strict MVC architecture with controllers only communicating through the model

**Use JavaFX Property Binding Approach When:**
- The state is purely for UI purposes (colors, visibility, etc.)
- You want reactive UI updates
- You need better separation of concerns
- You want to leverage JavaFX's built-in property binding capabilities
- Performance and reduced coupling are priorities

In this specific case, the JavaFX Property Binding approach is more appropriate since we're dealing with pure UI state (a selected color) that doesn't require business logic processing.
