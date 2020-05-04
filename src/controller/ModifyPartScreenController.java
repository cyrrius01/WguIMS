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
import model.Inventory;
import model.Part;

/**
 *
 * @author Keith A Graham
 */
public class ModifyPartScreenController implements Initializable {
    
    private static int selectedPart = 0;

    @FXML
    private Label modifyPartLabel;
    @FXML
    private RadioButton modifyPartInHouseRadio;
    @FXML
    private RadioButton modifyPartOutsourcedRadio;
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
        try {ToggleGroup group = new ToggleGroup();
        
        modifyPartInHouseRadio.setToggleGroup(group);
        modifyPartInHouseRadio.setSelected(true);
        
        modifyPartOutsourcedRadio.setToggleGroup(group);
        }
        catch(Exception e) {
            System.out.println("Wrapper Exception: " + e);
            System.out.println("Underlying Exception: " + e.getCause());
        }
        
    }

   
    
    public void onModifyPartSave(ActionEvent actionEvent) {
        // To do
    }
    
    public void onModifyPartCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) modifyPartCancelBtn.getScene().getWindow();
        stage.close();
    }
    

    
    public void modifyInHouseClick(ActionEvent actionEvent) {
        if(modifyPartInHouseRadio.isSelected()) {              // we check to see if the InHouse radio button is selected
            modifyPartInOutLabel.setText("Machine ID");        // and if it is, set the Label to Machine ID
            
        }
    }
    
    public void modifyOutsourceClick(ActionEvent actionEvent) {
        if(modifyPartOutsourcedRadio.isSelected()) {           // we check to see if the Outsourced radio button is selected
            modifyPartInOutLabel.setText("Company Name");      // and if it is, set the Label to Company Name
            
        }
    }
    
}
