package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import model.Part;
import model.Product;


public class ModifyProductScreenController implements Initializable {
    
    ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    
    public static Product selectedProduct;

    @FXML
    private TextField modifyProductIdTextField;
    @FXML
    private TextField modifyProductNameTextField;
    @FXML
    private TextField modifyProductInventoryTextField;
    @FXML
    private TextField modifyProductPriceTextField;
    @FXML
    private TextField modifyProductMaxTextField;
    @FXML
    private TextField modifyProductMinTextField;
    @FXML
    private Button modifyProductSearchBtn;
    @FXML
    private TextField modifyProductTextField;
    @FXML
    private TableView<Part> modifyProductTableViewAll;
    @FXML
    private TableColumn<Part, Integer> allPartIdCol;
    @FXML
    private TableColumn<Part, String> allPartPartNameCol;
    @FXML
    private TableColumn<Part, Integer> allPartInventoryCol;
    @FXML
    private TableColumn<Part, Double> allPartPriceCol;
    @FXML
    private Button modifyProductAddPartBtn;
    @FXML
    private TableView<Part> modifyProductTableViewPartial;
    @FXML
    private TableColumn<Part, Integer> fewPartIdCol;
    @FXML
    private TableColumn<Part, String> fewPartPartNameCol;
    @FXML
    private TableColumn<Part, Integer> fewPartInventoryCol;
    @FXML
    private TableColumn<Part, Double> fewPartPriceCol;
    @FXML
    private Button modifyProductDeleteBtn;
    @FXML
    private Button modifyProductSaveBtn;
    @FXML
    private Button modifyProductCancelBtn;

    public static void receiveProduct(Product product){
        selectedProduct = product;
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        modifyProductTableViewAll.setItems(Inventory.getAllParts());
       
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id")); 
        allPartPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
       
       
       
        modifyProductTableViewPartial.setItems(associatedParts);
       
        fewPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        fewPartPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        fewPartInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        fewPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }    

    @FXML
    private void onAddProductSearch(ActionEvent event) {
        
        String q = modifyProductTextField.getText();
        
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
        modifyProductTableViewAll.setItems(parts);
        modifyProductTextField.setText("");
    }

    @FXML
    private void onAddProductAddPart(ActionEvent event) {
    }

    @FXML
    private void onAddProductDelete(ActionEvent event) {
    }

    @FXML
    private void onAddProductSave(ActionEvent event) {
    }

    @FXML
    private void onAddProductCancel(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to cancel? Any changes made will be discarded.");
        ButtonType okay = new ButtonType("Okay");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okay, buttonTypeCancel);
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == okay) {
            Stage stage = (Stage) modifyProductCancelBtn.getScene().getWindow();
            stage.close();
        } else {
            // action canceled
        }
    }
    
}
