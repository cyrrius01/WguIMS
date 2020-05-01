package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Keith Graham 4/30/2020
 */
public class Inventory {
    
    private static ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;
    
    public void addPart(Part newPart) {
        // To do
    }
    
    public void addProduct(Product newProduct) {
        // To do
    }
    
    
    public static Part lookupPart(int partId) {
       ObservableList<Part> allParts = Part.getAllParts();
       
       for(Part pt : allParts) {
           if(pt.getId() == partId) {
               return pt;
           }
       }
        
        return null;
    }
    

    
    
    
    public static ObservableList<Part> lookupPart(String partialName) {
       ObservableList<Part> namedParts = FXCollections.observableArrayList();
       
       ObservableList<Part> allParts = Part.getAllParts();
       
       for(Part pt : allParts) {
           if(pt.getName().contains(partialName)) { 
               namedParts.add(pt);
           }
       }
       
       return namedParts;
    }
    
    
    

//    public Product lookupProduct(int productId) {
//        // get entered productId
//        // search allProducts by productId Product.id = productId
//        // if found, add to results and return result
//    }
//    

//    public ObservableList<Product> lookupProduct(String productName) {
//        // get entered productName
//        // search allProducts using enhance for loop doing partial match Product.productName.contains(productName)
//        // if found, add to results and return result
//    }
//    
//    public void updatePart(int index, Part selectedPart) {
//        // To do
//    }
//    
//    public void updateProduct(int index, Product newProduct) {
//        // To do
//    }
//    
//    public boolean deletePart(Part selectedPart) {
//        // To do
//    }
//    
//    public boolean deleteProduct(Product selectedProduct) {
//        // To do
//    }
    
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    
    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }
    
    // Part newPart = InHouse part; -- this is one way to create a new InHouse part or Outsourced
    
    // Outsourced ou1 = new Outsourced():  /*
    // InHouse inh1 = new InHouse();        *
    //                                      *
    // allParts.add(ou1)                    *
    // allParts.add(inh1                    */ this is another way to add parts 
    
    /*
        determine if it is an InHouse or Outsourced part 
        by using if (part instanceof Outsourced) {
                    *radio button Outsourced is selected and companyName field displays;
                    ((Outsourced)part).getCompanyName(); // this is casting the part as an outsourced part
                    } else if (part instanceof InHouse) {
                        * radio button InHouse is selected and machineId field displays;
                        ((InHouse)part).getMachineId();
                    }
    
    */
    
    
    
}
