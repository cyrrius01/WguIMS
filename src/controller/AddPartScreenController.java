package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
 * FXML Controller class
 *
 * @author Keith A Graham
 */
public class AddPartScreenController implements Initializable {
    
    private static ObservableList<Part> allParts = Part.getAllParts();
    

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
        
        int q = 1;
        int newId = q;
        for(Part pt : allParts) {
            Part searchPart = Inventory.lookupPart(q);          // search by part ID method called here
            if(searchPart != null) {                            // the goal is to find either the first missing part ID
                q = q + 1;                                      // in the case of a deleted part
                newId = q;                                      // or the first available part ID
                System.out.println(q);
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
    
    @FXML
    public void onAddPartCancel(ActionEvent actionEvent) {
        
        Stage stage = (Stage) addPartCancelBtn.getScene().getWindow();
        stage.close();
        
    }
    
    
    
}
