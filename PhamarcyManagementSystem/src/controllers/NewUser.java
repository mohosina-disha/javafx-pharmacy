package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import utils.ConnectionUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewUser {
    Connection con = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    @FXML
    Label lblError;
    @FXML
    TextField txtEmail;
    @FXML
    TextField txtPassword;
    @FXML
    Button btnRegister;

    @FXML
    public void btnRegisterClick() {
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        if (email.isEmpty() || password.isEmpty()) {
            setlblError(Color.TOMATO, "Empty credentials");
        }
        else {
            try {
                con = ConnectionUtil.conDB();
                String sql = "insert into admins (email,password)" + "values(?,?)";
                preparedStatement = con.prepareStatement(sql);

                preparedStatement.setString(1,email);
                preparedStatement.setString(2,password);

                int status = preparedStatement.executeUpdate();

                if ( status != 0){
                    alert("Succesfully Registered");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

        private void setlblError(Color color, String text) {
            lblError.setTextFill(color);
            lblError.setText(text);
        }
    private void alert(String info){
        Alert paidAlert = new Alert(Alert.AlertType.CONFIRMATION);
        paidAlert.setContentText(info);
        paidAlert.setHeaderText("Confirmation");
        paidAlert.showAndWait();
    }
}

