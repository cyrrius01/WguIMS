package model;

import javafx.collections.ObservableList;



/**
 *
 * @author Keith A Graham 4/30/2020
 */
public class Outsourced extends Part {
    
    private static ObservableList<Part> allParts = Part.getAllParts();
    private static ObservableList<Product> allProducts = Product.getAllProducts();
    
    private String companyName;
    
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setStock(stock);
        this.setMin(min);
        this.setMax(max);
        this.companyName = companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return this.companyName;
    }
}
