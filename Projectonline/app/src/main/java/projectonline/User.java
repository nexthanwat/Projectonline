package projectonline;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method for login
    public boolean login(String enteredPassword) {
        return enteredPassword.equals(this.password);
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static User createUser(String username, String password) {
        return new User(username, password);
    }
}

class LoginScreen extends Application {
    private User currentUser;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // Create UI elements
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button createAccountButton = new Button("Create Account");

        // Login action
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            currentUser = new User(username, password); // Here, you'd check against a stored user
            if (currentUser.login(password)) {
                showShoppingList(primaryStage); // If login successful, show shopping list
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password.", ButtonType.OK);
                alert.show();
            }
        });

        // Create account action
        createAccountButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            currentUser = User.createUser(username, password); // Simulating account creation
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Account Created Successfully", ButtonType.OK);
            alert.show();
        });

        VBox layout = new VBox(10, usernameField, passwordField, loginButton, createAccountButton);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Shopping list screen after login
    private void showShoppingList(Stage primaryStage) {
        ShoppingListScreen shoppingListScreen = new ShoppingListScreen();
        shoppingListScreen.start(new Stage());
        primaryStage.close(); // Close login window
    }

    public static void main(String[] args) {
        launch(args);
    }
}
