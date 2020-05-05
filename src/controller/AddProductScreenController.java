package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import static model.Inventory.getAllProducts;
import model.Part;
import model.Product;

/**
 *
 * @author Keith A Graham
 */
public class AddProductScreenController implements Initializable {

    @FXML
    private Button addProductSearchBtn;
    @FXML
    private TextField addProductTextField;
    @FXML
    private TableView<Part> addProductTableViewAll;
    @FXML
    private TableColumn<Part, Integer> allPartIdCol;
    @FXML
    private TableColumn<Part, String> allPartPartNameCol;
    @FXML
    private TableColumn<Part, Integer> allPartInventoryCol;
    @FXML
    private TableColumn<Part, Double> allPartPriceCol;
    @FXML
    private TableView<Part> addProductTableViewPartial;
    @FXML
    private TableColumn<Part, Integer> fewPartIdCol;
    @FXML
    private TableColumn<Part, String> fewPartPartNameCol;
    @FXML
    private TableColumn<Part, Integer> fewPartInventoryCol;
    @FXML
    private TableColumn<Part, Double> fewPartPriceCol;
    @FXML
    private Button addProductAddPartBtn;
    @FXML
    private Button addProductDeleteBtn;
    @FXML
    private Button addProductCancelBtn;
    @FXML
    private Button addProductSaveBtn;
    @FXML
    private TextField addProductIdTextField;
    @FXML
    private TextField addProductNameTextField;
    @FXML
    private TextField addProductInventoryTextField;
    @FXML
    private TextField addProductPriceTextField;
    @FXML
    private TextField addProductMaxTextField;
    @FXML
    private TextField addProductMinTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // API methods for TableView
        // setItems()
        // getSelectionModel()
        // getSelectedIndex()
        // getSelectedItem()
        // select()
        
       addProductTableViewAll.setItems(Inventory.getAllParts());
       
       allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id")); 
       allPartPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
       allPartInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
       allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
       
       ObservableList<Part> associatedParts = FXCollections.observableArrayList();
       
       addProductTableViewPartial.setItems(associatedParts);
       
       fewPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
       fewPartPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
       fewPartInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
       fewPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
       
       
    }    
    
    @FXML
    private void onAddProductSearch(ActionEvent event) {
    }

    @FXML
    private void onAddProductAddPart(ActionEvent event) {
    }

    @FXML
    private void onAddProductDelete(ActionEvent event) {
    }

    @FXML
    private void onAddProductCancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to cancel? Any data entered will be discarded.");
        ButtonType okay = new ButtonType("Okay");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okay, buttonTypeCancel);
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == okay) {
            Stage stage = (Stage) addProductCancelBtn.getScene().getWindow();
            stage.close();
        } else {
            // action canceled
        }
    }

    @FXML
    private void onAddProductSave(ActionEvent event) {
        
        // do min field evaluation to ensure it does not exceed the max field value
        if(Integer.parseInt(addProductMinTextField.getText()) > Integer.parseInt(addProductMaxTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("The minimum value cannot be greater than the maximum value.");
            alert.showAndWait();
        } else {
        
            int q = 0;
            int newId = q;
            for(Product pt : getAllProducts()) {
                Product searchProduct = Inventory.lookupProduct(q);          // search by product ID method called here
                if(searchProduct != null) {                                  // the goal is to find either the first missing product ID
                    q = q + 1;                                               // in the case of a deleted product
                    newId = q;                                               // or the first available product ID
                } else {
                    newId = 0;
                }
            }

            String name = addProductNameTextField.getText();
            double price = Double.parseDouble(addProductPriceTextField.getText());
            int stock = Integer.parseInt(addProductInventoryTextField.getText());
            int min = Integer.parseInt(addProductMinTextField.getText());
            int max = Integer.parseInt(addProductMaxTextField.getText());
            
            
            // get associated parts
            // can't use get selected because there will be multiple parts in the list to get
            // 
            addProductTableViewAll.getItems();
            

            
            
            
            
            ObservableList<Part> associatedParts = null;
            
            
            Product newProduct = new Product(associatedParts, newId, name, price, stock, min, max);

            
            Inventory.addProduct(newProduct);

            }


        try {
            Stage stage = (Stage) addProductCancelBtn.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/mainScreen.fxml"));
            loader.load();

            MainScreenController MSC = loader.getController();
            ActionEvent makeItSo = new ActionEvent();
            MSC.onPartsSearch(makeItSo);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
