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
import model.InHouse;
import model.Part;


/**
 *
 * @author Keith A Graham
 */
public class ModifyPartScreenController implements Initializable {
    
    public static Part selectedPart;
    

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
    private TextField modifyPartIdField;
    @FXML
    private TextField modifyPartNameField;
    @FXML
    private TextField modifyPartInventoryField;
    @FXML
    private TextField modifyPartPriceField;
    @FXML
    private TextField modifyPartMaxField;
    @FXML
    private TextField modifyPartMinField;
    @FXML
    private TextField modifyPartInOutField;
    @FXML
    private Button modifyPartSaveBtn;
    @FXML
    private Button modifyPartCancelBtn;

    
    
    public static void receivePart(Part part){
        selectedPart = part;
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
        try {
            ToggleGroup group = new ToggleGroup();
            modifyPartInHouseRadio.setToggleGroup(group);
            modifyPartInHouseRadio.setSelected(true);
            modifyPartOutsourcedRadio.setToggleGroup(group);
            modifyPartIdField.setText(Integer.toString(selectedPart.getId()));
            modifyPartNameField.setText(selectedPart.getName());
            modifyPartInventoryField.setText(Integer.toString(selectedPart.getStock()));
            modifyPartPriceField.setText(Double.toString(selectedPart.getPrice()));
            modifyPartMaxField.setText(Integer.toString(selectedPart.getMax()));
            modifyPartMinField.setText(Integer.toString(selectedPart.getMin()));
//            if(selectedPart instanceof InHouse) {
//                int x = getMachineId();
//                modifyPartInOutField.setText(Integer.toString(selectedPart.getMachineId()));
//                modifyPartInHouseRadio.setSelected(true);
//            } else if(selectedPart instanceof Outsourced) {
//                // do stuff too
//                modifyPartOutsourcedRadio.setSelected(true);
//            }
        }
        catch(Exception e) {
            e.printStackTrace();
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
