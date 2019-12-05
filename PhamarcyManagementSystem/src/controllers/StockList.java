package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Models.Drug;

import static Models.DrugList.getAmoxy;
import static Models.DrugList.getNuroFen;
import static Models.DrugList.getPainEeze;

public class StockList {
    @FXML
    Label lblNurofenSize;
    @FXML
    Label lblPaineezeSize;
    @FXML
    Label lblSizeAmoxy;

    @FXML

    public void initialize(){
        Drug amoxy = getAmoxy();
        Integer amoxySize = amoxy.getSize();

        Drug nuroFen = getNuroFen();
        Integer nuroFenSize = nuroFen.getSize();

        Drug paineeze = getPainEeze();
        Integer paineezeSize = paineeze.getSize();

        lblNurofenSize.setText(nuroFenSize.toString());
        lblPaineezeSize.setText(paineezeSize.toString());
        lblSizeAmoxy.setText(amoxySize.toString());


    }
}
