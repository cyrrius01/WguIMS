package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.InHouse;
import model.Outsourced;
import model.Part;
import model.Product;


/**
 *
 * @author Keith Graham 4/30/2020
 */
public class Inventory {
    
    private static ObservableList<Part> allParts = Part.getAllParts();
    private static ObservableList<Product> allProducts = Product.getAllProducts();
    
    public static void addPart(Part newPart) {
        allParts.add(newPart);        
    }
    
    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }
    
    
    public static Part lookupPart(int partId) {
       
       for(Part pt : allParts) {
           if(pt.getId() == partId) {
               return pt;
           }
       }
        
        return null;
    }
    
    public static ObservableList<Part> lookupPart(String partialName) {
       ObservableList<Part> namedParts = FXCollections.observableArrayList();
       
       
       for(Part pt : allParts) {
           if(pt.getName().contains(partialName)) { 
               namedParts.add(pt);
           }
       }
       
       return namedParts;
    }
    
    
    
    
    public static Product lookupProduct(int productId) {
        
        for(Product pdt : allProducts) {
            if(pdt.getId() == productId) {
                return pdt;
            }
        }
        
        return null;
    }
    
    public static ObservableList<Product> lookupProduct(String partialName) {
        ObservableList<Product> namedProducts = FXCollections.observableArrayList();
        
        
        
        for(Product pdt : allProducts) {
            if(pdt.getName().contains(partialName)) {
                namedProducts.add(pdt);
            }
        }
        
        return namedProducts;
    }
    


    public static void updatePart(int index, Part selectedPart) throws Exception {
        

        
    }
    
    
    
    
//    
//    public void updateProduct(int index, Product newProduct) {
//        // To do
//    }
//    
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
