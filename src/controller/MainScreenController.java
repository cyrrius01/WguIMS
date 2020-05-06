package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    private TableView<Product> productsTableView;
    @FXML
    private TableColumn<Product, Integer> productIdCol;
    @FXML
    private TableColumn<Product, String> productNameCol;
    @FXML
    private TableColumn<Product, Integer> productsInventoryLevelCol;
    @FXML
    private TableColumn<Product, Double> productsPriceCol;
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
    private TableView<Part> partsTableView;
    @FXML
    private TableColumn<Part, Integer> partIdCol;
    @FXML
    private TableColumn<Part, String> partNameCol;
    @FXML
    private TableColumn<Part, Integer> partsInventoryLevelCol;
    @FXML
    private TableColumn<Part, Double> partsPriceCol;
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
        
        // API methods for TableView
        // setItems()
        // getSelectionModel()
        // getSelectedIndex()
        // getSelectedItem()
        // select()
        
       partsTableView.setItems(Inventory.getAllParts());
       
       partIdCol.setCellValueFactory(new PropertyValueFactory<>("id")); // gets id of Part and populates the cell
       partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
       partsInventoryLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
       partsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
       
       productsTableView.setItems(Inventory.getAllProducts());
       
       productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
       productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
       productsInventoryLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
       productsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
       
       
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
    
    
    

    
    
    public void onPartsAdd(ActionEvent actionEvent) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/addPartScreen.fxml"));
        Parent root = loader.load(); // AddPartScreenController initializes here
        
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        stage.setResizable(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }    
    

    public void onPartsModify(ActionEvent actionEvent) {
        
        if(partsTableView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You must select a part from the list to modify.");
            alert.showAndWait();
        } else {
            Part part = partsTableView.getSelectionModel().getSelectedItem();
            ModifyPartScreenController.receivePart(part);
            
            try {       
            Parent root = FXMLLoader.load(getClass().getResource("/view/modifyPartScreen.fxml"));

            Stage stage = new Stage();
            stage.setTitle("");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            stage.setResizable(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
   
    }
      
    
    
    public void onPartsDelete(ActionEvent actionEvent) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this part?");
        ButtonType delete = new ButtonType("Delete Part");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(delete, buttonTypeCancel);
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == delete) {
            Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();
            Inventory.deletePart(selectedPart);
        } else {
            // action canceled
        }
        
        
    }
    
    
    public void onProductsSearch(ActionEvent actionEvent) {
        String r = productsTextField.getText();
        ObservableList<Product> products = Inventory.lookupProduct(r);
        if(products.size() == 0) {
            try {
                int productId = Integer.parseInt(r);
                Product pdt = Inventory.lookupProduct(productId);
                if(pdt != null)
                    products.add(pdt);
            }
            catch(NumberFormatException e)
            {
                // ignore
            }
        }
        productsTableView.setItems(products);
        productsTextField.setText("");
    }
    
    public void onProductsAdd(ActionEvent actionEvent){
        try {       
            Parent root = FXMLLoader.load(getClass().getResource("/view/addProductScreen.fxml"));

            Stage stage = new Stage();
            stage.setTitle("");
            stage.setScene(new Scene(root, 1500, 620));
            stage.show();
            stage.setResizable(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        
    }
    
    public void onProductsModify(ActionEvent actionEvent){
        
        if(productsTableView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You must select a product from the list to modify.");
            alert.showAndWait();
        } else {
            Product product = productsTableView.getSelectionModel().getSelectedItem();
            ModifyProductScreenController.receiveProduct(product);
            
            try {       
            Parent root = FXMLLoader.load(getClass().getResource("/view/modifyProductScreen.fxml"));

            Stage stage = new Stage();
            stage.setTitle("");
            stage.setScene(new Scene(root, 1500, 620));
            stage.show();
            stage.setResizable(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void onProductsDelete(ActionEvent actionEvent){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this product?");
        ButtonType delete = new ButtonType("Delete Product");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(delete, buttonTypeCancel);
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == delete) {
            Product selectedProduct = productsTableView.getSelectionModel().getSelectedItem();
            Inventory.deleteProduct(selectedProduct);
        } else {
            // action canceled
        }
    }
    
    public void onMainExit(ActionEvent actionEvent){
        System.out.println("Main Exit Clicked");
        System.exit(0);
    }
    
   
}
