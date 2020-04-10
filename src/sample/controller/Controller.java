package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import sample.model.Piece;
import sample.model.Plateau;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private GridPane GridChest;

    @FXML
    private Pane pane00, pane10, pane20, pane30, pane40, pane50, pane60, pane70,
                 pane01, pane11, pane21, pane31, pane41, pane51, pane61, pane71,
                 pane02, pane12, pane22, pane32, pane42, pane52, pane62, pane72,
                 pane03, pane13, pane23, pane33, pane43, pane53, pane63, pane73,
                 pane04, pane14, pane24, pane34, pane44, pane54, pane64, pane74,
                 pane05, pane15, pane25, pane35, pane45, pane55, pane65, pane75,
                 pane06, pane16, pane26, pane36, pane46, pane56, pane66, pane76,
                 pane07, pane17, pane27, pane37, pane47, pane57, pane67, pane77;

    private Pane tableauPane[][];

    private Piece piece;
    private Plateau plateau;

    /* Initialisation du plateau */
    private int posStartX[] = {0,1,2,3,4,5,6,7};
    private int posStartY[] = {0,1,6,7};
    /* Type : 1 - Soldat
              2 - Tour
              3 - Cavalier
              4 - Fou
              5 - Dame
              6 - Roi
     */
    private int typeStart[] = {2,3,4,5,6,4,3,2};
    boolean etat = false;

    boolean tourJeu;

    int lastColumn;
    int lastRow;
    int column;
    int row;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Start();
        initialisationTableauPane();
        plateau.afficherPlateau(tableauPane);
        for (Pane[] lignePane: tableauPane) {
            for (Pane pane: lignePane) {
                pane.setOnMouseClicked(event -> {
                    if (!etat) {
                        if(GridChest.getColumnIndex(pane) == null){
                            lastColumn = 0;
                        } else {
                            lastColumn = GridChest.getColumnIndex(pane);
                        }
                        if(GridChest.getRowIndex(pane) == null){
                            lastRow = 0;
                        } else {
                            lastRow = GridChest.getRowIndex(pane);
                        }
                        plateau.mouvementPossible(tableauPane, lastColumn, lastRow);
                        etat = true;


                    } else {
                        if(GridChest.getColumnIndex(pane) == null){
                            column = 0;
                        } else {
                            column = GridChest.getColumnIndex(pane);
                        }
                        if(GridChest.getRowIndex(pane) == null){
                            row = 0;
                        } else {
                            row = GridChest.getRowIndex(pane);
                        }
                        plateau.mouvement(lastColumn, lastRow, column, row);
                        plateau.afficherPlateau(tableauPane);
                        etat = false;
                    }
                });

            }
        }

    }

    public void Start(){
        plateau= new Plateau();
        for (int i = 0; i< posStartY.length; i++) {
            for (int j = 0; j < posStartX.length; j++) {
                if(i==0||i==1){
                    if (posStartY[i] == 0 || posStartY[i] == 7) {
                        piece = new Piece(typeStart[j], posStartX[j], posStartY[i], false);
                    } else {
                        piece = new Piece(1, posStartX[j], posStartY[i], false);
                    }
                } else {
                    if (posStartY[i] == 0 || posStartY[i] == 7) {
                        piece = new Piece(typeStart[j], posStartX[j], posStartY[i], true);
                    } else {
                        piece = new Piece(1, posStartX[j], posStartY[i], true);
                    }
                }

                plateau.setPlacementPiece(piece);
            }
        }
    }
    private void initialisationTableauPane(){
         tableauPane = new Pane[][]{{pane00, pane10, pane20, pane30, pane40, pane50, pane60, pane70},
                 {pane01, pane11, pane21, pane31, pane41, pane51, pane61, pane71},
                 {pane02, pane12, pane22, pane32, pane42, pane52, pane62, pane72},
                 {pane03, pane13, pane23, pane33, pane43, pane53, pane63, pane73},
                 {pane04, pane14, pane24, pane34, pane44, pane54, pane64, pane74},
                 {pane05, pane15, pane25, pane35, pane45, pane55, pane65, pane75},
                 {pane06, pane16, pane26, pane36, pane46, pane56, pane66, pane76},
                 {pane07, pane17, pane27, pane37, pane47, pane57, pane67, pane77}};
    }
}
