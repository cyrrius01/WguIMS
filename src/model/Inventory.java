package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Keith Graham 4/30/2020
 */
public class Inventory {
    
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    public static void addPart(Part newPart) {
        allParts.add(newPart);        
    }
    
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }
    
    
    public static Part lookupPart(int partId) {
       for(Part pt : getAllParts()) {
           if(pt.getId() == partId) {
               return pt;
           }
       }
        return null;
    }
    
    public static ObservableList<Part> lookupPart(String partialName) {
       ObservableList<Part> namedParts = FXCollections.observableArrayList();
       for(Part pt : getAllParts()){
           if(pt.getName().contains(partialName)) { 
               namedParts.add(pt);
           }
       }
       return namedParts;
    }
    
    public static Product lookupProduct(int productId) {
        for(Product pdt : getAllProducts()) {
            if(pdt.getId() == productId) {
                return pdt;
            }
        }
        return null;
    }
    
    public static ObservableList<Product> lookupProduct(String partialName) {
        ObservableList<Product> namedProducts = FXCollections.observableArrayList();
        for(Product pdt : getAllProducts()) {
            if(pdt.getName().contains(partialName)) {
                namedProducts.add(pdt);
            }
        }
        return namedProducts;
    }
    


    public static void updatePart(int index, Part selectedPart) throws Exception {
        
        int loc = -1;
        
        for(Part p : getAllParts()) {

            loc++;
            if(p.getId() == index) {
                getAllParts().set(loc, selectedPart);
            }
        }
    }
    
    
    public static void updateProduct(int index, Product newProduct) {
        // To do
    }
    
    public static boolean deletePart(Part selectedPart) {
        if(allParts.contains(selectedPart)) {
          allParts.remove(selectedPart);
          return true;
        } else {
            return false;
        }
    }
 
    public static boolean deleteProduct(Product selectedProduct) {
        if(allProducts.contains(selectedProduct)) {
          allProducts.remove(selectedProduct);
          return true;
        } else {
            return false;
        }
    }
    
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
    
    
}
