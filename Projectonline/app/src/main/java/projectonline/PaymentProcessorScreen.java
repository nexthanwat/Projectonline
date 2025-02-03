package projectonline;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaymentProcessorScreen {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Payment Processor");

        // UI Elements
        TextField amountField = new TextField();
        TextField cardNumberField = new TextField();
        TextField expirationDateField = new TextField();
        TextField cvvField = new TextField();
        Button processPaymentButton = new Button("Process Payment");

        // Process Payment Button
        processPaymentButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            String cardNumber = cardNumberField.getText();
            String expirationDate = expirationDateField.getText();
            String cvv = cvvField.getText();
            processPayment(amount, cardNumber, expirationDate, cvv);
        });

        VBox layout = new VBox(10, amountField, cardNumberField, expirationDateField, cvvField, processPaymentButton);
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processPayment(double amount, String cardNumber, String expirationDate, String cvv) {
        // Simulate payment processing (just printing data for now)
        System.out.println("Processing payment...");
        System.out.println("Amount: " + amount);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("CVV: " + cvv);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment Processed", ButtonType.OK);
        alert.show();
    }
}
