package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import Models.Drug;
import pharmacy.SellDrugs;

import java.io.IOException;

import static controllers.BuyDrugsController.getBoughtDrug;


public class Transaction {
    private static Drug processingDrug;
    private String processingDrugName;
    private static Integer processingDrugPrice;
    private static Integer selectedValue;
    static PaymentMode mode;

    public  static Drug getProcessingDrug(){return processingDrug;}
    public static  Integer getSelectedValue(){return selectedValue;}
    public static Integer getProcessingDrugPrice(){return processingDrugPrice;}
    //public static PaymentMode getMode(){return mode;}

    @FXML
    Label lblEnterAmount;
    @FXML
    TextField txtEnteredAmount;
    @FXML
    Button btnEnter;
    @FXML
    Label lbldisplayDrugInfo;
    @FXML
    public void initialize(){


        if(SellDrugs.getSelectedDrug()!= null){
            processingDrug = SellDrugs.getSelectedDrug();
            processingDrugName = processingDrug.getName();
            processingDrugPrice = processingDrug.getPrice();
            mode = PaymentMode.Selling;
        }

        else {
            processingDrug = getBoughtDrug();
            processingDrugName = processingDrug.getName();
            processingDrugPrice = processingDrug.getPrice();
            mode = PaymentMode.Buying;
        }
        lbldisplayDrugInfo.setText("Drug Name: " + processingDrugName + "\n" + "Drug Price: $" + processingDrugPrice);
    }

    @FXML
    public void EnterClicked(ActionEvent actionEvent) throws IOException {

               String selectedAmount = txtEnteredAmount.getText();
               selectedValue = Integer.parseInt(selectedAmount);

        Stage stage = (Stage) btnEnter.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/ConfirmBox.fxml")));
        stage.setScene(scene);
        stage.show();

    }

}
