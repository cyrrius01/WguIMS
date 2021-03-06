package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Part;
import model.InHouse;
import model.Inventory;
import static model.Inventory.getAllParts;
import model.Outsourced;

/**
 * FXML Controller class
 *
 * @author Keith A Graham
 */
public class AddPartScreenController implements Initializable {
    
    private static ObservableList<Part> allParts = Inventory.getAllParts();
    

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
        addPartInHouseRadio.setSelected(true);
        addPartOutsourcedRadio.setToggleGroup(group);  
    }    
    
    public void inHouseClick(ActionEvent actionEvent) {
        
        if(addPartInHouseRadio.isSelected()) {              // we check to see if the InHouse radio button is selected
            addPartInOutLabel.setText("Machine ID");        // and if it is, set the Label to Machine ID
            addPartInOutField.setPromptText("Mach ID");     // and also set the prompt text to Mach ID
        } 
    }
    
    public void outsourceClick(ActionEvent actionEvent) {
        if(addPartOutsourcedRadio.isSelected()) {           // we check to see if the Outsourced radio button is selected
            addPartInOutLabel.setText("Company Name");      // and if it is, set the Label to Company Name
            addPartInOutField.setPromptText("Comp Nm");     // and the prompt text to Comp Nm
        }
    }

    
    @FXML
    public void onAddPartSave(ActionEvent actionEvent) throws Exception {
        
        // do min field evaluation to ensure it does not exceed the max field value
        if(Integer.parseInt(addPartMinField.getText()) > Integer.parseInt(addPartMaxField.getText())) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("The minimum value cannot be greater than the maximum value.");
            alert.showAndWait();
        } else {
        
            int q = 0;
            int newId = q;
            for(Part pt : getAllParts()) {
                Part searchPart = Inventory.lookupPart(q);          // search by part ID method called here
                if(searchPart != null) {                            // the goal is to find either the first missing part ID
                    q = q + 1;                                      // in the case of a deleted part
                    newId = q;                                      // or the first available part ID
                } else {
                    newId = 0;
                }
            }

            String name = addPartNameField.getText();
            double price = Double.parseDouble(addPartPriceField.getText());
            int stock = Integer.parseInt(addPartInventoryField.getText());
            int min = Integer.parseInt(addPartMinField.getText());
            int max = Integer.parseInt(addPartMaxField.getText());

            if(addPartInHouseRadio.isSelected()) {


                int machineId = Integer.parseInt(addPartInOutField.getText());

                InHouse newPart = new InHouse(newId, name, price, stock, min, max, machineId);

                Inventory.addPart(newPart);



            } else if(addPartOutsourcedRadio.isSelected()) {

                String companyName = addPartInOutField.getText();

                Outsourced newPart = new Outsourced(newId, name, price, stock, min, max, companyName);

                Inventory.addPart(newPart);

            }



            Stage stage = (Stage) addPartCancelBtn.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/mainScreen.fxml"));
            loader.load();

            MainScreenController MSC = loader.getController();
            ActionEvent makeItSo = new ActionEvent();
            MSC.onPartsSearch(makeItSo);
        }
    }
    
    @FXML
    public void onAddPartCancel(ActionEvent actionEvent) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to cancel? Any data entered will be discarded.");
        ButtonType okay = new ButtonType("Okay");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okay, buttonTypeCancel);
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == okay) {
            Stage stage = (Stage) addPartCancelBtn.getScene().getWindow();
            stage.close();
        } else {
            // action canceled
        }
    }
    
    
    
}
