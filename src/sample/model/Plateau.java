package sample.model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.controller.Controller;

import java.util.ArrayList;
import java.util.Optional;

public class Plateau {
    public Piece placement[][];
    public Controller controller;

    private boolean tourDeJeu;
    private boolean droitDeJeu;


    public Plateau(){
        placement = new Piece[8][8];
        tourDeJeu = true;
        droitDeJeu = false;
        controller = new Controller();
    }

    public void setPlacementPiece(Piece pPiece) {
        placement[pPiece.getPositionX()][pPiece.getPositionY()] = pPiece;
    }
    
    public void afficherPlateau(Pane[][] tableauPanneau){
        boolean roiBlanc = false;
        boolean roiNoir = false;
        int i=0;
        int resteJ;
        int resteI;
        for (Piece[] placements: placement) {
            int j=0;
            for (Piece placement: placements) {
                if(placement != null){
                    if (placement.getType() == 1){
                        resteI = i%2;
                        resteJ = j%2;
                        if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && !placement.getColor()) {
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/piecePionNoirFondGris.png);" +
                                    "-fx-background-size: 180px;" +
                                    "-fx-border-color : black");
                        } else if(!placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/piecePionNoirFondBlanc.png);" +
                                    "-fx-background-size: 180px;" +
                                    "-fx-border-color : black");
                        } else if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/piecePionBlancFondGris.png);" +
                                    "-fx-background-size : 180px;"+
                                    "-fx-border-color : black");
                        } else if(placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/piecePionBlancFondBlanc.png);" +
                                    "-fx-background-size : 180px;"+
                                    "-fx-border-color : black");
                        }
                    } else if (placement.getType() == 2){
                        resteI = i%2;
                        resteJ = j%2;
                        if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && !placement.getColor()) {
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceTourNoirFondGris.png);" +
                                    "-fx-background-size: 180px;" +
                                    "-fx-border-color : black");
                        } else if(!placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceTourNoirFondBlanc.png);" +
                                    "-fx-background-size: 180px;" +
                                    "-fx-border-color : black");
                        } else if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceTourBlancFondGris.png);" +
                                    "-fx-background-size : 180px;"+
                                    "-fx-border-color : black");
                        } else if(placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceTourBlancFondBlanc.png);" +
                                    "-fx-background-size : 180px;"+
                                    "-fx-border-color : black");
                        }
                    } else if (placement.getType() == 3){
                        resteI = i%2;
                        resteJ = j%2;
                        if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && !placement.getColor()) {
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceCavalierNoirFondGris.png);" +
                                    "-fx-background-size: 180px;" +
                                    "-fx-border-color : black");
                        } else if(!placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceCavalierNoirFondBlanc.png);" +
                                    "-fx-background-size: 180px;" +
                                    "-fx-border-color : black");
                        } else if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceCavalierBlancFondGris.png);" +
                                    "-fx-background-size : 180px;"+
                                    "-fx-border-color : black");
                        } else if(placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceCavalierBlancFondBlanc.png);" +
                                    "-fx-background-size : 180px;"+
                                    "-fx-border-color : black");
                        }
                    } else if (placement.getType() == 4){
                        resteI = i%2;
                        resteJ = j%2;
                        if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && !placement.getColor()) {
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceFouNoirFondGris.png);" +
                                    "-fx-background-size: 160px;" +
                                    "-fx-border-color : black");
                        } else if(!placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceFouNoirFondBlanc.png);" +
                                    "-fx-background-size: 160px;" +
                                    "-fx-border-color : black");
                        } else if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceFouBlancFondGris.png);" +
                                    "-fx-background-size : 160px;"+
                                    "-fx-border-color : black");
                        } else if(placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceFouBlancFondBlanc.png);" +
                                    "-fx-background-size : 160px;"+
                                    "-fx-border-color : black");
                        }
                    } else if (placement.getType() == 5){
                        resteI = i%2;
                        resteJ = j%2;
                        if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && !placement.getColor()) {
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceReineNoirFondGris.png);" +
                                    "-fx-background-size: 36px;" +
                                    "-fx-border-color : black");
                        } else if(!placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceReineNoirFondBlanc.png);" +
                                    "-fx-background-size: 36px;" +
                                    "-fx-border-color : black");
                        } else if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceReineBlancFondGris.png);" +
                                    "-fx-background-size : 36px;"+
                                    "-fx-border-color : black");
                        } else if(placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceReineBlancFondBlanc.png);" +
                                    "-fx-background-size : 36px;"+
                                    "-fx-border-color : black");
                        }
                    } else if (placement.getType() == 6){
                        resteI = i%2;
                        resteJ = j%2;
                        if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && !placement.getColor()) {
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceRoiNoirFondGris.png);" +
                                    "-fx-background-size: 180px;" +
                                    "-fx-border-color : black");
                            roiNoir = true;
                        } else if(!placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceRoiNoirFondBlanc.png);" +
                                    "-fx-background-size: 180px;" +
                                    "-fx-border-color : black");
                            roiNoir = true;
                        } else if((resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0) && placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceRoiBlancFondGris.png);" +
                                    "-fx-background-size : 36px;"+
                                    "-fx-border-color : black");
                            roiBlanc = true;
                        } else if(placement.getColor()){
                            tableauPanneau[j][i].setStyle("-fx-background-image : url(file:src/image/pieceRoiBlancFondBlanc.png);" +
                                    "-fx-background-size : 36px;"+
                                    "-fx-border-color : black");
                            roiBlanc = true;
                        }
                    }
                } else {
                    resteJ = j%2;
                    resteI = i%2;
                    if(resteJ != 0 && resteI==0 || resteJ==0 && resteI !=0){
                        tableauPanneau[j][i].setStyle("-fx-background-color : grey;" +
                                "-fx-border-color : black");
                    } else {
                        tableauPanneau[j][i].setStyle("-fx-border-color : black");
                    }
                }
                j++;
            }
            i++;
        }

        if(!roiBlanc) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Voulez vous recommencer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                controller.Start();
            } else {

            }
        } else if(!roiNoir){
        }
    }

    public void mouvement(int lastPositionX, int lastPositionY,int positionX, int positionY){
        if(placement[lastPositionX][lastPositionY]!=null && droitDeJeu){
            for (String mouvement : placement[lastPositionX][lastPositionY].getListMouvement()) {
                if (mouvement.equals(positionX + "||" + positionY)){
                    placement[positionX][positionY] = placement[lastPositionX][lastPositionY];
                    placement[positionX][positionY].setPositionX(positionX);
                    placement[positionX][positionY].setPositionY(positionY);
                    placement[lastPositionX][lastPositionY] = null;
                    if(tourDeJeu){
                        tourDeJeu = false;
                    } else if(!tourDeJeu){
                        tourDeJeu = true;
                    }
                    droitDeJeu = false;
                }
            }
        }
    }

    public void mouvementPossible(Pane[][] tableauPanneau, int positionX, int positionY){
        if(placement[positionX][positionY] != null && placement[positionX][positionY].getColor()==tourDeJeu){
            placement[positionX][positionY].mouvementPossible(tableauPanneau, placement);
            droitDeJeu = true;
        }

    }
}
