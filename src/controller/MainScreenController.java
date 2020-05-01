package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.*;
import static model.Part.allParts;
import static model.Product.allProducts;
import model.Part;
import model.Product;
import model.Inventory;


/**
 *
 * @author Keith Graham 4/28/2020
 */

public class MainScreenController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane productsAnchorPane;
    @FXML
    public TableView productsTableView;
    @FXML
    public TableColumn productIdCol;
    @FXML
    public TableColumn productNameCol;
    @FXML
    public TableColumn productsInventoryLevelCol;
    @FXML
    public TableColumn productsPriceCol;
    @FXML
    private Label labelProducts;
    @FXML
    private Button productsSearchBtn;
    @FXML
    private TextField productsTextField;
    @FXML
    private Button productsModifyBtn;
    @FXML
    private Button productsAddBtn;
    @FXML
    private Button productsDeleteBtn;
    @FXML
    private Label labelMain;
    @FXML
    private Button mainExitBtn;
    @FXML
    private AnchorPane partsAnchorPane;
    @FXML
    public TableView partsTableView;
    @FXML
    public TableColumn partIdCol;
    @FXML
    public TableColumn partNameCol;
    @FXML
    public TableColumn partsInventoryLevelCol;
    @FXML
    public TableColumn partsPriceCol;
    @FXML
    private Label labelParts;
    @FXML
    private Button partsSearchBtn;
    @FXML
    private TextField partsTextField;
    @FXML
    private Button partsModifyBtn;
    @FXML
    private Button partsAddBtn;
    @FXML
    private Button partsDeleteBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partsInventoryLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        ObservableList<Part> parts = Part.getAllParts();
        partsTableView.setItems(parts);
        
        
        productsTableView.setItems(allProducts);
        productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productsInventoryLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));   
        
        ObservableList<Product> products = Product.getAllProducts();
        productsTableView.setItems(products);
    }    
    
    
    
    public void onPartsSearch(ActionEvent actionEvent) {
        String q = partsTextField.getText();
        
        ObservableList<Part> parts = Inventory.lookupPart(q); // search by part name method called here
        
        if(parts.size() == 0) {
            
            try {
                int partId = Integer.parseInt(q);
                Part pt = Inventory.lookupPart(partId);         // search by part ID method called here
                if(pt != null) 
                    parts.add(pt);
            
            }
            
            catch(NumberFormatException e)
            
            {
                // ignore
            }
        }
        partsTableView.setItems(parts);
        partsTextField.setText("");
    }
    
    
    
//    private ObservableList<Part> searchPartName(String partialName) {
//       ObservableList<Part> namedParts = FXCollections.observableArrayList();
//       
//       ObservableList<Part> allParts = Part.getAllParts();
//       
//       for(Part pt : allParts) {
//           if(pt.getName().contains(partialName)) { 
//               namedParts.add(pt);
//           }
//       }
//       
//       return namedParts;
//    }
    
    
//    private Part searchPartId(int partId) {
//       ObservableList<Part> allParts = Part.getAllParts();
//       
//       for(Part pt : allParts) {
//           if(pt.getId() == partId) {
//               return pt;
//           }
//       }
//        
//        return null;
//    }
    
    
    public void onPartsAdd(ActionEvent actionEvent) {
        System.out.println("Parts Add Clicked");
    }
    
    
    
    public void onPartsModify(ActionEvent actionEvent) {
        System.out.println("Parts Modify Clicked");
    }
    
    
    
    public void onPartsDelete(ActionEvent actionEvent) {
        System.out.println("Parts Delete Clicked");
    }
    
    
    
    public void onProductsSearch(ActionEvent actionEvent) {
        System.out.println("Products Search Clicked");
    }
    
    
    
    public void onProductsAdd(ActionEvent actionEvent){
        System.out.println("Products Add Clicked");
    }
    
    
    
    public void onProductsModify(ActionEvent actionEvent){
        System.out.println("Products Modify Clicked");
    }
    
    
    
    public void onProductsDelete(ActionEvent actionEvent){
        System.out.println("Products Delete Clicked");
    }
    
    
    
    public void onMainExit(ActionEvent actionEvent){
        System.out.println("Main Exit Clicked");
        System.exit(0);
    }
    
   
}
