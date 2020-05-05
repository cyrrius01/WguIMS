package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import model.InHouse;
import model.Inventory;
import model.Outsourced;
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
            
            
            if(selectedPart instanceof InHouse) {
                InHouse part = (InHouse) selectedPart;
                modifyPartInOutField.setText(Integer.toString(part.getMachineId()));
                modifyPartInHouseRadio.setSelected(true);
            } else if(selectedPart instanceof Outsourced) {
                Outsourced part = (Outsourced) selectedPart;
                modifyPartInOutField.setText(part.getCompanyName());
                modifyPartOutsourcedRadio.setSelected(true);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
   
    
    public void onModifyPartSave(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(modifyPartIdField.getText());
            String name = modifyPartNameField.getText();
            int stock = Integer.parseInt(modifyPartInventoryField.getText());
            double price = Double.parseDouble(modifyPartPriceField.getText());
            int max = Integer.parseInt(modifyPartMaxField.getText());
            int min = Integer.parseInt(modifyPartMinField.getText());
            
        
            if(modifyPartInHouseRadio.isSelected()) {
                int machineId = Integer.parseInt(modifyPartInOutField.getText());
                Inventory.updatePart(id, new InHouse(id, name, price, stock, max, min, machineId));


            } else if(modifyPartOutsourcedRadio.isSelected()){
                String companyName = modifyPartInOutField.getText();
                Inventory.updatePart(id, new Outsourced(id, name, price, stock, max, min, companyName));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        Stage stage = (Stage) modifyPartSaveBtn.getScene().getWindow();
        stage.close();
        try {
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
    
    public void onModifyPartCancel(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to cancel modifying this part? All changes will be discarded.");
        ButtonType yes = new ButtonType("Yes");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yes, buttonTypeCancel);
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == yes) {
            Stage stage = (Stage) modifyPartCancelBtn.getScene().getWindow();
            stage.close();
        } else {
            // action canceled
        }
        
        
        
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
