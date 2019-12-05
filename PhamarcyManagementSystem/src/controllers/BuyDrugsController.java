package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import Models.Drug;

import java.io.IOException;

import static Models.DrugList.getPainEeze;
import static Models.DrugList.getNuroFen;
import static Models.DrugList.getAmoxy;
public class BuyDrugsController {
    @FXML
    Button btnBuy;
    @FXML
    ListView<Drug> itemsList;
    private static Drug boughtDrug;

    public static Drug getBoughtDrug(){return boughtDrug;}

    @FXML
    public void initialize(){

        itemsList.getItems().addAll(getPainEeze(),getNuroFen(),getAmoxy());
    }

    @FXML

    public void btnBuyClick(ActionEvent event) throws IOException {

        if(event.getSource() == btnBuy){

            itemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            boughtDrug = itemsList.getSelectionModel().getSelectedItem();

            Stage stage = (Stage) btnBuy.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/transaction.fxml")));
            stage.setScene(scene);
            stage.show();

        }
    }
}
