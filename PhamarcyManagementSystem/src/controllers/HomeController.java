package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pharmacy.SellDrugs;

import java.io.IOException;

public class HomeController {
    @FXML
    ImageView imageView;
    @FXML
    private Label lblHome;
    @FXML
    private Button btnDashboardT;
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnExitApplication;
    @FXML
    private Button btnSellDrugs;
    @FXML
    private Button btnViewStockList;
    @FXML
    private Button btnBuyDrugs;
    @FXML
    private Button btnRegisterNewUser;



    public void btnDashboardTClick(ActionEvent actionEvent) throws IOException{

        Stage stage = new Stage();


        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/DashboardT.fxml")));
        stage.setScene(scene);
        stage.show();

    }

    public void btnRegisterNewUser(ActionEvent actionEvent) throws IOException{

        Stage stage = new Stage();


        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/NewUser.fxml")));
        stage.setScene(scene);
        stage.show();

    }
    public void btnBuyDrugsClick(ActionEvent actionEvent) throws IOException{
       Stage stage = new Stage();


       Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/BuyDrugs.fxml")));
       stage.setScene(scene);
       stage.show();
    }

    public void btnViewStockListCLick(ActionEvent actionEvent) throws IOException{
        Stage stage = new Stage();


        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/StockList.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void btnSellDrugsClick(ActionEvent actionEvent) throws IOException {

        SellDrugs display = new SellDrugs();

        display.displaySellDrugsWindow();

    }


    public void btnExitApplicationClick(ActionEvent actionEvent){
        System.exit(0);
    }

    public void btnLogOutClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Login.fxml")));
        stage.setScene(scene);
        stage.show();

    }
}
