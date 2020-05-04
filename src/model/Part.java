package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Keith Graham 4/30/2020
 */
public abstract class Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    
    
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();
    
    {
        init();
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setMin(int min) {
        this.min = min;
    }
    public int getMin() {
        return this.min;
    }
    
    public void setMax(int max) {
        this.max = max;
    }
    public int getMax() {
        return this.max;
    }
    
    public void init() {
        if (allParts.isEmpty()) {
        allParts.add(new InHouse(0,"AMD CPU",75.25,37,10,100, 10001));
        allParts.add(new InHouse(1,"Intel CPU", 125.39, 12,10,100, 10002));
        allParts.add(new InHouse(2,"AMD Motherboard",95.99,49,10,100, 10003));
        allParts.add(new InHouse(3,"Intel Motherboard",150.99,33,10,100, 10004));
        allParts.add(new InHouse(4,"HDD",49.99,75,10,100, 10005));
        allParts.add(new InHouse(5,"SSD",76.99,40,10,100, 10006));
        allParts.add(new Outsourced(6,"nVidia Graphics", 129.99, 30,10,100,"Card Warehouse"));
        allParts.add(new Outsourced(7,"AMD Graphics", 79.99, 30, 10, 100, "Card Warehouse"));
        allParts.add(new Outsourced(8, "Logitech Keyboard", 30.00, 90, 10, 100, "New Egg"));
        allParts.add(new Outsourced(9, "Razer mouse", 99.99, 20, 10, 100, "New Egg"));
        allParts.add(new Outsourced(10, "Logitech Webcam", 29.99, 42, 10, 100, "Cheap Parts"));
        allParts.add(new Outsourced(11, "Mouse Pad", 5.99, 83, 10, 100, "Cheap Parts"));
        }
    }
        
}
