package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import controllers.PaymentMode;

import static controllers.Transaction.*;

public class ConfirmBox {
    private Integer price = getSelectedValue() * getProcessingDrugPrice();
    private String newStringPrice = price.toString();



    @FXML
    private Label newPrice;

    @FXML
    Button btnYes;
    @FXML
    Button btnNo;
    @FXML
    private void initialize(){

        newPrice.setText(newStringPrice);

    }


    public void handleOnBottonAction(ActionEvent event){

        if (event.getSource() == btnYes){

                if (mode == PaymentMode.Selling)
                Transaction.getProcessingDrug().setSize(getProcessingDrug().getSize() - getSelectedValue());
                else
                    Transaction.getProcessingDrug().setSize(getProcessingDrug().getSize() + getSelectedValue());
            alert("Payment Successful \n Drug Size : " + getProcessingDrug().getSize());
        }

        if (event.getSource() == btnNo){

            alert("Payment failed");
        }
    }

    private void alert(String info){
        Alert paidAlert = new Alert(Alert.AlertType.CONFIRMATION);
        paidAlert.setContentText(info);
        paidAlert.setHeaderText("Confirmation");
        paidAlert.showAndWait();
    }





}
