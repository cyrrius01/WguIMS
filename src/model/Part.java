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
    
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }
    
    static {
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
    
    public static void init() {
        if (allParts.isEmpty()) {
        allParts.add(new InHouse(1,"AMD CPU",75.25,37,10,100, 00001));
        allParts.add(new InHouse(2,"Intel CPU", 125.39, 12,10,100, 00002));
        allParts.add(new InHouse(3,"AMD Motherboard",95.99,49,10,100, 00003));
        allParts.add(new InHouse(4,"Intel Motherboard",150.99,33,10,100, 00004));
        allParts.add(new InHouse(5,"HDD",49.99,75,10,100, 00005));
        allParts.add(new InHouse(6,"SSD",76.99,40,10,100, 00006));
        allParts.add(new Outsourced(7,"nVidia Graphics", 129.99, 30,10,100,"Card Warehouse"));
        allParts.add(new Outsourced(8,"AMD Graphics", 79.99, 30, 10, 100, "Card Warehouse"));
        allParts.add(new Outsourced(9, "Logitech Keyboard", 30.00, 90, 10, 100, "New Egg"));
        allParts.add(new Outsourced(10, "Razer mouse", 99.99, 20, 10, 100, "New Egg"));
        allParts.add(new Outsourced(11, "Logitech Webcam", 29.99, 42, 10, 100, "Cheap Parts"));
        allParts.add(new Outsourced(12, "Mouse Pad", 5.99, 83, 10, 100, "Cheap Parts"));
        }
    }
    
}
