package controllers;

import Models.Drug;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DashboardT {

    Connection con = null;
    ResultSet resultSet = null;

    @FXML
    TableView<Drug> tableView;
    @FXML
    TableColumn<Drug,Integer> ColDrugId;
    @FXML
    TableColumn<Drug,String> ColName;
    @FXML
    TableColumn<Drug,Integer> ColExoiryDate;
    @FXML
    TableColumn<Drug,Integer> ColSize;
    @FXML
    TableColumn<Drug,Integer> ColPrice;
    private ObservableList<String> data;





    @FXML
    public void initialize(){

        ColDrugId.setCellValueFactory(new PropertyValueFactory<Drug,Integer>("idDrug"));
        ColName.setCellValueFactory(new PropertyValueFactory<Drug,String>("name_1"));
        ColExoiryDate.setCellValueFactory(new PropertyValueFactory<Drug,Integer>("expiry_Date"));
        ColSize.setCellValueFactory(new PropertyValueFactory<Drug,Integer>("size_1"));
        ColPrice.setCellValueFactory(new PropertyValueFactory<Drug,Integer>("price_1"));
        tableView.getItems().setAll(getAllDrugInfo());


    }

    public List<Drug> getAllDrugInfo(){
        List ll = new LinkedList();
        try{
            con = ConnectionUtil.conDB();
            resultSet = con.createStatement().executeQuery("SELECT * FROM Drugs");

            while(resultSet.next()){
                Integer Drugid = resultSet.getInt("idDrugs");
                String name = resultSet.getString("name");
                Integer expiryDate = resultSet.getInt("expiryDate");
                Integer size = resultSet.getInt("size");
                Integer price = resultSet.getInt("price");
                ll.add(new Drug(Drugid, name, expiryDate,size, price));

            }
        }catch( SQLException ex){
            ex.printStackTrace();

        }
        return ll;
    }


}
