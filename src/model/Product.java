package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Keith Graham 4/30/2020
 */
public class Product {
    private static ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    public Product(ObservableList<Part> associatedParts,int id, String name, double price, int stock, int min, int max) {
        this.associatedParts = associatedParts;
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
    public int getId(){
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
    
    public void addAssociatedPart(Part part) {
        // To do
        // on action event, get selected
        // selected part add selected as associatedPart
        // confirm part is added
    }
    
//    public boolean deleteAssociatedPart(Part selectedAsPart) {
        // To do
        // get selected part to delete
        // Confirm if user wants to delete
        // remove selected part from associatedParts
//    }
    
    public ObservableList<Part> getAllAssociatedParts() {
        // To do
        // get selected part
        // check associatedParts        
        return associatedParts;
    }
    
    // need to initialize associatedParts - list is empty
    
    public static void init() {
        if (allProducts.isEmpty()) {
            allProducts.add(new Product(associatedParts, 1, "Intel PC A", 1299.00, 20, 5, 20));
            allProducts.add(new Product(associatedParts, 2, "Intel PC B", 1199.00, 19, 5, 20));
            allProducts.add(new Product(associatedParts, 3, "Intel PC C", 999.00, 15, 5, 20));
            allProducts.add(new Product(associatedParts, 4, "AMD PC A", 699.00, 12, 5, 20));
            allProducts.add(new Product(associatedParts, 5, "AMD PC B", 650.00, 12, 5, 20));
            allProducts.add(new Product(associatedParts, 6, "AMD PC C", 499.00, 7, 5, 20));
        }
    }
    
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
    
}
