package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Part;
import model.InHouse;
import model.Inventory;
import model.Outsourced;

/**
 *
 * @author Keith A Graham
 */
public class ModifyPartScreenController implements Initializable {
    
    private static Part selectedPart = null;

    @FXML
    private Label modifyPartLabel;
    @FXML
    public static RadioButton modifyPartInHouseRadio;
    @FXML
    public static RadioButton modifyPartOutsourcedRadio;
    @FXML
    private Label modifyPartIdLabel;
    @FXML
    private Label modifyPartNameLabel;
    @FXML
    private Label modifyPartInventoryLabel;
    @FXML
    private Label modifyPartPriceLabel;
    @FXML
    private Label modifyPartMaxLabel;
    @FXML
    private Label modifyPartMinLabel;
    @FXML
    private Label modifyPartInOutLabel;
    @FXML
    public static TextField modifyPartIdField;
    @FXML
    public static TextField modifyPartNameField;
    @FXML
    public static TextField modifyPartInventoryField;
    @FXML
    public static TextField modifyPartPriceField;
    @FXML
    public static TextField modifyPartMaxField;
    @FXML
    public static TextField modifyPartMinField;
    @FXML
    public static TextField modifyPartInOutField;
    @FXML
    private Button modifyPartSaveBtn;
    @FXML
    private Button modifyPartCancelBtn;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
    }

    public void onModifyPartSave(ActionEvent actionEvent) {
        // To do
    }
    
    public void onModifyPartCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) modifyPartCancelBtn.getScene().getWindow();
        stage.close();
    }
    
    public static void receiveParam(Part part) {
        selectedPart = part;
    }
    
    public void ModifyInHouseClick(ActionEvent actionEvent) {
        // to do
    }
    
    public void ModifyOutsourceClick(ActionEvent actionEvent) {
        // to do
    }
    
}
