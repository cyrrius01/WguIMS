package model;

import javafx.collections.ObservableList;

/**
 *
 * @author Keith A Graham 4/30/2020
 */

public class InHouse extends Part {
    private int machineId;
    
    public static ObservableList<Part> allParts = Part.getAllParts();
    public static ObservableList<Product> allProducts = Product.getAllProducts();
    
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setStock(stock);
        this.setMin(min);
        this.setMax(max);
        this.machineId = machineId;
    }
    
    

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
    public int getMachineId() {
        return this.machineId;
    }
    
}
