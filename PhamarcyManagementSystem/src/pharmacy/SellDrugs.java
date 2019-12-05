package pharmacy;

import Models.Drug;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static Models.DrugList.getAmoxy;
import static Models.DrugList.getNuroFen;
import static Models.DrugList.getPainEeze;


public class SellDrugs {

    private Button sell;
    private ListView<Drug> drugs;
    private static Drug selectedDrug;


    public static Drug getSelectedDrug(){ return selectedDrug;}



    public void displaySellDrugsWindow(){
    Stage sellDrugsWindow = new Stage();
      sellDrugsWindow.initModality(Modality.APPLICATION_MODAL);
      sellDrugsWindow.setTitle("Sell Drugs");
      sellDrugsWindow.setMinWidth(600);
      sellDrugsWindow.setMinHeight(400);
        drugs = new ListView<>();
    drugs.setMinWidth(600);
    drugs.setMinHeight(400);
        drugs.getItems().addAll(getPainEeze(),getAmoxy(),getNuroFen());
        drugs.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        sell = new Button();
        sell.setText("Sell");
        sell.setLayoutX(200);
        sell.setLayoutY(400);
        sell.setPrefWidth(150);
        sell.setPrefHeight(41);

        sell.setOnAction(e-> {
            try {
                buttonClicked();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


    AnchorPane anchorPane = new AnchorPane();
    anchorPane.setMinHeight(400);
    anchorPane.setMinWidth(600);

        anchorPane.getChildren().add(drugs);
        anchorPane.getChildren().add(sell);

    Scene scene = new Scene(anchorPane);
        sellDrugsWindow.setScene(scene);
        sellDrugsWindow.showAndWait();

}

public void buttonClicked() throws IOException {

    selectedDrug = drugs.getSelectionModel().getSelectedItem();

    Stage stage = (Stage) sell.getScene().getWindow();
    //stage.setMaximized(true);
    stage.close();
    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/transaction.fxml")));

    stage.setScene(scene);
    stage.show();

}


}
