package projectonline;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

class ShoppingListScreen {
    private List<Item> shoppingList = new ArrayList<>();

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Shopping List");

        // UI Elements
        TextField itemNameField = new TextField();
        TextField itemPriceField = new TextField();
        TextField itemStockField = new TextField();
        Button addItemButton = new Button("Add Item");
        Button deleteItemButton = new Button("Delete Item");
        ListView<String> listView = new ListView<>();

        // Add item button
        addItemButton.setOnAction(e -> {
            String name = itemNameField.getText();
            double price = Double.parseDouble(itemPriceField.getText());
            int stock = Integer.parseInt(itemStockField.getText());
            Item item = new Item(name, price, stock);
            shoppingList.add(item);
            listView.getItems().add(item.getName() + " - Price: " + price + " - Stock: " + stock);
        });

        // Delete item button
        deleteItemButton.setOnAction(e -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                shoppingList.removeIf(item -> item.getName().equals(selectedItem.split(" - ")[0]));
                listView.getItems().remove(selectedItem);
            }
        });

        VBox layout = new VBox(10, itemNameField, itemPriceField, itemStockField, addItemButton, deleteItemButton, listView);
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

