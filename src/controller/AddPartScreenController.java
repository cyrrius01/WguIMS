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

/**
 * FXML Controller class
 *
 * @author Keith A Graham
 */
public class AddPartScreenController implements Initializable {

    @FXML
    private Label addPartLabel;
    @FXML
    private RadioButton addPartInHouseRadio;
    @FXML
    private RadioButton addPartOutsourcedRadio;
    @FXML
    private Label addPartIdLabel;
    @FXML
    private Label addPartNameLabel;
    @FXML
    private Label addPartInventoryLabel;
    @FXML
    private Label addPartPriceLabel;
    @FXML
    private Label addPartMaxLabel;
    @FXML
    private Label addPartInOutLabel;
    @FXML
    private TextField addPartIdField;
    @FXML
    private TextField addPartNameField;
    @FXML
    private TextField addPartInventoryField;
    @FXML
    private TextField addPartPriceField;
    @FXML
    private TextField addPartMaxField;
    @FXML
    private TextField addPartInOutField;
    @FXML
    private TextField addPartMinField;
    @FXML
    private Label addPartMinLabel;
    @FXML
    private Button addPartSaveBtn;
    @FXML
    private Button addPartCancelBtn;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        addPartInHouseRadio.setToggleGroup(group);
        addPartInHouseRadio.fire();
        addPartOutsourcedRadio.setToggleGroup(group);
        addPartInOutLabel.setText("Machine ID");
        
        
    }    
    
    public void inHouseClick(ActionEvent actionEvent) {
        
        if(addPartInHouseRadio.isSelected()) {
            addPartInOutLabel.setText("Machine ID");
            
            addPartInOutField.setPromptText("Mach ID");
            
            
            // set field type to int
            // and set prompt text to Mach Id
        } 
    }
    
    public void outsourceClick(ActionEvent actionEvent) {
        if(addPartOutsourcedRadio.isSelected()) {
            addPartInOutLabel.setText("Company Name");
            addPartInOutField.setPromptText("Comp Nm");
        }
    }

    
    @FXML
    public void onAddPartSave(ActionEvent actionEvent) {
        
        // this will retrieve all of the field inputs and compile them into the selected Part type
        // so if(InHouse selected) do(build Inhouse object) else build Outsourced object
        
    }
    
    @FXML
    public void onAddPartCancel(ActionEvent actionEvent) {
        
        Stage stage = (Stage) addPartCancelBtn.getScene().getWindow();
        stage.close();
        
    }
    
    
    
}
