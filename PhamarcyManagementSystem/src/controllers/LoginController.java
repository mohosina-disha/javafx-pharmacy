package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.input.KeyEvent;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.ConnectionUtil;


/**
 *
 * @author oXCToo
 */
public class LoginController implements Initializable {


    @FXML
    private Label lblErrors;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignin;

    @FXML
    private Button btnForgotPassword;

    /// --
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    public void handleButtonAction() {


            //login here
            if (logIn().equals("Success")) {
                try {

                    //add you loading or delays - ;-)

                    Stage stage = (Stage) btnSignin.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Home.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }



            }

        }

        @FXML
        public void handleButton2Action(){
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setContentText("Please contact your database administrator");
            infoAlert.showAndWait();
        }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }


    }

    public LoginController() {
        con = ConnectionUtil.conDB();
    }

    //we gonna use string to check for status
    private String logIn() {
        String status = "Success";
        String email = txtUsername.getText();
        String password = txtPassword.getText();
        if (email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error";
        } else {
            //query
            String sql = "SELECT * FROM admins ";
            try {
                preparedStatement = con.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    String dbEmail = resultSet.getString("email");
                    String dbPassword = resultSet.getString("password");

                    if (dbEmail.equals(email) && dbPassword.equals(password)) {

                        setLblError(Color.GREEN, "Login Successful..Redirecting..");
                        return status;


                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Error";
            }


        }
        setLblError(Color.TOMATO,"Enter Correct Password or Email");
        return status = "error";
    }

    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }

    public void getText(KeyEvent keyEvent) {
    }

}
