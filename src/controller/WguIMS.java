package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

/**
 *
 * @author Keith Graham 4/28/2020
 */

public class WguIMS extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScreen.fxml"));
        primaryStage.setScene(new Scene(root, 1500, 600)); 
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Test Data
        
        InHouse ih0 = new InHouse(0,"AMD CPU",75.25,37,10,100, 10001);
        InHouse ih1 = new InHouse(1,"Intel CPU", 125.39, 12,10,100, 10002);
        InHouse ih2 = new InHouse(2,"AMD Motherboard",95.99,49,10,100, 10003);
        InHouse ih3 = new InHouse(3,"Intel Motherboard",150.99,33,10,100, 10004);
        InHouse ih4 = new InHouse(4,"HDD",49.99,75,10,100, 10005);
        InHouse ih5 = new InHouse(5,"SSD",76.99,40,10,100, 10006);
        Outsourced os0 = new Outsourced(6,"nVidia Graphics", 129.99, 30,10,100,"Card Warehouse");
        Outsourced os1 = new Outsourced(7,"AMD Graphics", 79.99, 30, 10, 100, "Card Warehouse");
        Outsourced os2 = new Outsourced(8, "Logitech Keyboard", 30.00, 90, 10, 100, "New Egg");
        Outsourced os3 = new Outsourced(9, "Razer mouse", 99.99, 20, 10, 100, "New Egg");
        Outsourced os4 = new Outsourced(10, "Logitech Webcam", 29.99, 42, 10, 100, "Cheap Parts");
        Outsourced os5 = new Outsourced(11, "Mouse Pad", 5.99, 83, 10, 100, "Cheap Parts");
        
        Inventory.addPart(ih0);
        Inventory.addPart(ih1);
        Inventory.addPart(ih2);
        Inventory.addPart(ih3);
        Inventory.addPart(ih4);
        Inventory.addPart(ih5);
        Inventory.addPart(os0);
        Inventory.addPart(os1);
        Inventory.addPart(os2);
        Inventory.addPart(os3);
        Inventory.addPart(os4);
        Inventory.addPart(os5);
        
//        Product pdt1 = new Product(associatedParts, 1, "Intel PC A", 1299.00, 20, 5, 20);
//        Product pdt2 = new Product(associatedParts, 2, "Intel PC B", 1199.00, 19, 5, 20);
//        Product pdt3 = new Product(associatedParts, 3, "Intel PC C", 999.00, 15, 5, 20);
//        Product pdt4 = new Product(associatedParts, 4, "AMD PC A", 699.00, 12, 5, 20);
//        Product pdt5 = new Product(associatedParts, 5, "AMD PC B", 650.00, 12, 5, 20);
//        Product pdt6 = new Product(associatedParts, 6, "AMD PC C", 499.00, 7, 5, 20);
//        
//        Inventory.addProduct(pdt1);
//        Inventory.addProduct(pdt2);
//        Inventory.addProduct(pdt3);
//        Inventory.addProduct(pdt4);
//        Inventory.addProduct(pdt5);
//        Inventory.addProduct(pdt6);

        launch(args);
        
    }
    
}
