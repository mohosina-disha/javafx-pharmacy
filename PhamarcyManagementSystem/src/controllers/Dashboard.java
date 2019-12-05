package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Models.Drug;

import java.util.Calendar;
import static Models.DrugList.getAmoxy;
import static Models.DrugList.getNuroFen;
import static Models.DrugList.getPainEeze;

public class Dashboard {
    @FXML
    Label lblAmoxyExpired;
    @FXML
    Label lblAmoxyOutOfStock;
    @FXML
    Label lblNurofenExpired;
    @FXML
    Label lblNurofenOutOfStock;
    @FXML
    Label lblPaineezeExpired;
    @FXML
    Label lblPaineezeOutOfStock;

    @FXML
    public void initialize(){
            // int year = Calendar.getInstance().get(Calendar.YEAR);
            Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);

            Drug amoxy = getAmoxy();
            Integer amoxyExpiryDate = amoxy.getExpiryDate();
            Integer amoxySize = amoxy.getSize();


            Drug nuroFen = getNuroFen();
            Integer nuroFenExpiryDate = nuroFen.getExpiryDate();
            Integer nuroFenSize = nuroFen.getSize();


            Drug paineeze = getPainEeze();
            Integer painEezeExpiryDate = paineeze.getExpiryDate();
            Integer paineezeSize = paineeze.getSize();

            if ( currentYear < amoxyExpiryDate)
                lblAmoxyExpired.setText("No");
            else
                lblAmoxyExpired.setText("Yes");

            if ( currentYear < nuroFenExpiryDate )
                lblNurofenExpired.setText("No");
            else
                lblNurofenExpired.setText("Yes");

            if (currentYear < painEezeExpiryDate)
                lblPaineezeExpired.setText("No");
            else
                lblPaineezeExpired.setText("Yes");

            if (amoxySize == 0)
                lblAmoxyOutOfStock.setText("Yes");
            else
                lblAmoxyOutOfStock.setText("No");

            if (paineezeSize == 0)
                lblPaineezeOutOfStock.setText("Yes");
            else
                lblPaineezeOutOfStock.setText("No");

            if (nuroFenSize == 0)
                lblNurofenOutOfStock.setText("Yes");
            else
                lblNurofenOutOfStock.setText("No");


    }
}
