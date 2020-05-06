package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class ModifyProductScreenController implements Initializable {

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
    private TableView<?> modifyProductTableViewAll;
    @FXML
    private TableColumn<?, ?> allPartIdCol;
    @FXML
    private TableColumn<?, ?> allPartPartNameCol;
    @FXML
    private TableColumn<?, ?> allPartInventoryCol;
    @FXML
    private TableColumn<?, ?> allPartPriceCol;
    @FXML
    private Button modifyProductAddPartBtn;
    @FXML
    private TableView<?> modifyProductTableViewPartial;
    @FXML
    private TableColumn<?, ?> fewPartIdCol;
    @FXML
    private TableColumn<?, ?> fewPartPartNameCol;
    @FXML
    private TableColumn<?, ?> fewPartInventoryCol;
    @FXML
    private TableColumn<?, ?> fewPartPriceCol;
    @FXML
    private Button modifyProductDeleteBtn;
    @FXML
    private Button modifyProductSaveBtn;
    @FXML
    private Button modifyProductCancelBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void onAddProductSave(ActionEvent event) {
    }

    @FXML
    private void onAddProductCancel(ActionEvent event) {
    }
    
}
