package sample.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Piece {
    /* Permet de savoir si la pièce est toujours active ou non */
    boolean etat;
    /* Permet de savoir si la pièce à déjà joué ou non (utile pour les soldats) */
    boolean start;
    /* Permet de savoir si la pièce est blanche ou noir (True = blanc || False = noir) */
    boolean color;

    int positionX;
    int positionY;

    /* Permet de savoir le type de la pièce (Soldats, Tour, Cavalier, Fou, Reine, Roi)*/
    int type;
    ArrayList<String> listMouvement;


    public Piece(int pType, int pPositionX, int pPositionY, boolean pColor){
        type = pType;
        positionX = pPositionX;
        positionY = pPositionY;
        etat = true;
        start = true;
        color = pColor;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getType() {
        return type;
    }

    public boolean getColor(){
        return color;
    }

    public ArrayList<String> getListMouvement(){
        return listMouvement;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String afficherPiece(){
        return ("La pièce se situe : " + positionX + " | " + positionY + " et est de type : " + type);
    }

    public void mouvementSoldat(Pane[][] tableauPanneau, Piece[][] plateau){
        listMouvement = new ArrayList<String>(1);
        if(color){
            if(getPositionY()>0 && plateau[getPositionX()][getPositionY()-1] == null){
                if(start){
                    if (plateau[getPositionX()][getPositionY()-2] ==null) {
                        tableauPanneau[getPositionY()-2][getPositionX()].setStyle("-fx-background-color: #DFE285");
                        listMouvement.add(getPositionX() + "||" + (getPositionY()-2));
                    }
                    tableauPanneau[getPositionY()-1][getPositionX()].setStyle("-fx-background-color: #DFE285");
                    listMouvement.add(getPositionX() + "||" + (getPositionY()-1));

                    start = false;
                } else {
                    tableauPanneau[getPositionY()-1][getPositionX()].setStyle("-fx-background-color: #DFE285");
                    listMouvement.add(getPositionX() + "||" + (getPositionY()-1));
                }
            }
            if(getPositionY()>0
                    && plateau[getPositionX()][getPositionY()].getPositionX()!=7
                    && plateau[getPositionX()+1][getPositionY()-1]!=null
                    && !plateau[getPositionX()+1][getPositionY()-1].getColor()){
                tableauPanneau[getPositionY()-1][getPositionX()+1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+1 + "||" + (getPositionY()-1));
            }
            if(getPositionY()>0
                    && plateau[getPositionX()][getPositionY()].getPositionX() !=0
                    && plateau[getPositionX()-1][getPositionY()-1]!=null
                    && !plateau[getPositionX()-1][getPositionY()-1].getColor()){
                tableauPanneau[getPositionY()-1][getPositionX()-1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-1 + "||" + (getPositionY()-1));
            }
        } else {
            if(getPositionY()<7 && plateau[getPositionX()][getPositionY()+1] == null){
                if(start){
                    if (plateau[getPositionX()][getPositionY()+2] ==null) {
                        tableauPanneau[getPositionY()+2][getPositionX()].setStyle("-fx-background-color: #DFE285");
                        listMouvement.add(getPositionX() + "||" + (getPositionY()+2));
                    }
                    tableauPanneau[getPositionY()+1][getPositionX()].setStyle("-fx-background-color: #DFE285");
                    listMouvement.add(getPositionX() + "||" + (getPositionY()+1));
                    start = false;
                } else {
                    tableauPanneau[getPositionY()+1][getPositionX()].setStyle("-fx-background-color: #DFE285");
                    listMouvement.add(getPositionX() + "||" + (getPositionY()+1));
                }
            }
            if(getPositionY()<7
                    && getPositionX()!=7
                    && plateau[getPositionX()+1][getPositionY()+1]!=null
                    && plateau[getPositionX()+1][getPositionY()+1].getColor()){
                tableauPanneau[getPositionY()+1][getPositionX()+1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+1 + "||" + (getPositionY()+1));
            }
            if(getPositionY()<7
                    && getPositionX() !=0
                    && plateau[getPositionX()-1][getPositionY()+1]!=null
                    && plateau[getPositionX()-1][getPositionY()+1].getColor()){
                tableauPanneau[getPositionY()+1][getPositionX()-1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-1 + "||" + (getPositionY()+1));
            }
        }
    }



    public void mouvementTour(Pane[][] tableauPanneau, Piece[][] plateau){
        listMouvement = new ArrayList<String>(1);
        int j = 1;
        while (getPositionX()-j>=0 && plateau[getPositionX()-j][getPositionY()] == null){
            tableauPanneau[getPositionY()][getPositionX()-j].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-j + "||" + getPositionY());
            j++;
        }
        if(getPositionX()-j>=0 && plateau[getPositionX()-j][getPositionY()].getColor()!= getColor()){
            tableauPanneau[getPositionY()][getPositionX()-j].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-j + "||" + getPositionY());
        }

        j = 1;
        while (getPositionX()+j<=7 && plateau[getPositionX()+j][getPositionY()] == null){
            tableauPanneau[getPositionY()][getPositionX()+j].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+j + "||" + getPositionY());
            j++;
        }
        if(getPositionX()+j<=7 && plateau[getPositionX()+j][getPositionY()].getColor()!= getColor()){
            tableauPanneau[getPositionY()][getPositionX()+j].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+j + "||" + getPositionY());
        }

        j = 1;
        while (getPositionY()+j<=7 && plateau[getPositionX()][getPositionY()+j] == null){
            tableauPanneau[getPositionY()+j][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()+j));
            j++;
        }
        if(getPositionY()+j<=7 && plateau[getPositionX()][getPositionY()+j].getColor()!= getColor()){
            tableauPanneau[getPositionY()+j][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()+j));
        }

        j = 1;
        while (getPositionY()-j>=0 && plateau[getPositionX()][getPositionY()-j] == null){
            tableauPanneau[getPositionY()-j][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()-j));
            j++;
        }
        if(getPositionY()-j>=0 && plateau[getPositionX()][getPositionY()-j].getColor()!= getColor()){
            tableauPanneau[getPositionY()-j][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()-j));
        }
    }



    public void mouvementCavalier(Pane[][] tableauPanneau, Piece[][] plateau){
        listMouvement = new ArrayList<String>(1);
        if(getPositionX()-1>=0 && getPositionY()-2 >=0){
            if(plateau[getPositionX()-1][getPositionY()-2]!= null && plateau[getPositionX()-1][getPositionY()-2].getColor()!= getColor()){
                tableauPanneau[getPositionY()-2][getPositionX()-1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-1 + "||" + (getPositionY()-2));
            } else if(plateau[getPositionX()-1][getPositionY()-2]== null){
                tableauPanneau[getPositionY()-2][getPositionX()-1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-1 + "||" + (getPositionY()-2));
            }
        }
        if(getPositionX()+1<=7 && getPositionY()-2 >=0){
            if(plateau[getPositionX()+1][getPositionY()-2]!= null && plateau[getPositionX()+1][getPositionY()-2].getColor()!= getColor()){
                tableauPanneau[getPositionY()-2][getPositionX()+1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+1 + "||" + (getPositionY()-2));
            } else if(plateau[getPositionX()+1][getPositionY()-2]== null){
                tableauPanneau[getPositionY()-2][getPositionX()+1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+1 + "||" + (getPositionY()-2));
            }
        }
        if(getPositionX()-1>=0 && getPositionY()+2 <=7){
            if(plateau[getPositionX()-1][getPositionY()+2]!= null && plateau[getPositionX()-1][getPositionY()+2].getColor()!= getColor()){
                tableauPanneau[getPositionY()+2][getPositionX()-1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-1 + "||" + (getPositionY()+2));
            } else if(plateau[getPositionX()-1][getPositionY()+2]== null){
                tableauPanneau[getPositionY()+2][getPositionX()-1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-1 + "||" + (getPositionY()+2));
            }
        }
        if(getPositionX()+1<=7 && getPositionY()+2 <=7 ){
            if(plateau[getPositionX()+1][getPositionY()+2] != null && plateau[getPositionX()+1][getPositionY()+2].getColor()!= getColor()){
                tableauPanneau[getPositionY()+2][getPositionX()+1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+1 + "||" + (getPositionY()+2));
        }  else if (plateau[getPositionX()+1][getPositionY()+2]==null){
                tableauPanneau[getPositionY()+2][getPositionX()+1].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+1 + "||" + (getPositionY()+2));
            }
        }
        if(getPositionX()-2>=0 && getPositionY()-1 >=0 ){
            if(plateau[getPositionX()-2][getPositionY()-1] != null && plateau[getPositionX()-2][getPositionY()-1].getColor()!= getColor()) {
                tableauPanneau[getPositionY()-1][getPositionX()-2].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-2 + "||" + (getPositionY()-1));
            } else if (plateau[getPositionX()-2][getPositionY()-1] == null) {
                tableauPanneau[getPositionY()-1][getPositionX()-2].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-2 + "||" + (getPositionY()-1));
            }
        }

        if(getPositionX()-2>=0 && getPositionY()+1 <=7){
            if(plateau[getPositionX()-2][getPositionY()+1] != null && plateau[getPositionX()-2][getPositionY()+1].getColor()!= getColor()) {
                tableauPanneau[getPositionY()+1][getPositionX()-2].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-2 + "||" + (getPositionY()+1));
            } else if(plateau[getPositionX()-2][getPositionY()+1] == null){
                tableauPanneau[getPositionY()+1][getPositionX()-2].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()-2 + "||" + (getPositionY()+1));
            }
        }
        if(getPositionX()+2<=7 && getPositionY()-1 >=0){
            if(plateau[getPositionX()+2][getPositionY()-1] != null && plateau[getPositionX()+2][getPositionY()-1].getColor()!= getColor()) {
                tableauPanneau[getPositionY()-1][getPositionX()+2].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+2 + "||" + (getPositionY()-1));
            } else if(plateau[getPositionX()+2][getPositionY()-1] == null){
                tableauPanneau[getPositionY()-1][getPositionX()+2].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+2 + "||" + (getPositionY()-1));
            }
        }
        if(getPositionX()+2<=7 && getPositionY()+1 <=7){
            if(plateau[getPositionX()+2][getPositionY()+1] != null && plateau[getPositionX()+2][getPositionY()+1].getColor()!= getColor()) {
                tableauPanneau[getPositionY()+1][getPositionX()+2].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+2 + "||" + (getPositionY()+1));
            } else if(plateau[getPositionX()+2][getPositionY()+1] == null) {
                tableauPanneau[getPositionY()+1][getPositionX()+2].setStyle("-fx-background-color: #DFE285");
                listMouvement.add(getPositionX()+2 + "||" + (getPositionY()+1));
            }
        }
    }




    public void mouvementFou(Pane[][] tableauPanneau, Piece[][] plateau){
        listMouvement = new ArrayList<String>(1);
        int i = 1;
        int j = 1;
        while(getPositionX()+i<=7 && getPositionY()+j<=7 && plateau[getPositionX()+i][getPositionY()+j]==null){
            tableauPanneau[getPositionY()+j][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()+j));
            i++;
            j++;
        }
        if(getPositionX()+i<=7 && getPositionY()+j<=7
                && plateau[getPositionX()+i][getPositionY()+j] != null
                && plateau[getPositionX()+i][getPositionY()+j].getColor() != getColor()){
            tableauPanneau[getPositionY()+j][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()+j));
        }

        i=1;
        j=1;
        while(getPositionX()+i<=7 && getPositionY()-j>=0 && plateau[getPositionX()+i][getPositionY()-j]==null){
            tableauPanneau[getPositionY()-j][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()-j));
            i++;
            j++;
        }
        if(getPositionX()+i<=7 && getPositionY()-j>=0
                && plateau[getPositionX()+i][getPositionY()-j] != null
                && plateau[getPositionX()+i][getPositionY()-j].getColor() != getColor()){
            tableauPanneau[getPositionY()-j][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()-j));
        }

        i=1;
        j=1;
        while(getPositionX()-i>=0 && getPositionY()-j>=0 && plateau[getPositionX()-i][getPositionY()-j]==null){
            tableauPanneau[getPositionY()-j][getPositionX()-i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()-j));
            i++;
            j++;
        }
        if(getPositionX()-i>=0 && getPositionY()-j>=0
                && plateau[getPositionX()-i][getPositionY()-j] != null
                && plateau[getPositionX()-i][getPositionY()-j].getColor() != getColor()){
            tableauPanneau[getPositionY()-j][getPositionX()-i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()-j));
        }

        i=1;
        j=1;
        while(getPositionX()-i>=0 && getPositionY()+j<=7 && plateau[getPositionX()-i][getPositionY()+j]==null){
            tableauPanneau[getPositionY()+j][getPositionX()-i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()+j));
            i++;
            j++;
        }
        if(getPositionX()-i>=0 && getPositionY()+j<=7
                && plateau[getPositionX()-i][getPositionY()+j] != null
                && plateau[getPositionX()-i][getPositionY()+j].getColor() != getColor()){
            tableauPanneau[getPositionY()+j][getPositionX()-i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()+j));
        }
    }
    public void mouvementReine(Pane[][] tableauPanneau, Piece[][] plateau){
        listMouvement = new ArrayList<String>(1);
        int j = 1;
        while (getPositionX()-j>=0 && plateau[getPositionX()-j][getPositionY()] == null){
            tableauPanneau[getPositionY()][getPositionX()-j].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-j + "||" + getPositionY());
            j++;
        }
        if(getPositionX()-j>=0 && plateau[getPositionX()-j][getPositionY()].getColor()!= getColor()){
            tableauPanneau[getPositionY()][getPositionX()-j].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-j + "||" + getPositionY());
        }

        j = 1;
        while (getPositionX()+j<=7 && plateau[getPositionX()+j][getPositionY()] == null){
            tableauPanneau[getPositionY()][getPositionX()+j].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+j + "||" + getPositionY());
            j++;
        }
        if(getPositionX()+j<=7 && plateau[getPositionX()+j][getPositionY()].getColor()!= getColor()){
            tableauPanneau[getPositionY()][getPositionX()+j].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+j + "||" + getPositionY());
        }

        j = 1;
        while (getPositionY()+j<=7 && plateau[getPositionX()][getPositionY()+j] == null){
            tableauPanneau[getPositionY()+j][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()+j));
            j++;
        }
        if(getPositionY()+j<=7 && plateau[getPositionX()][getPositionY()+j].getColor()!= getColor()){
            tableauPanneau[getPositionY()+j][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()+j));
        }

        j = 1;
        while (getPositionY()-j>=0 && plateau[getPositionX()][getPositionY()-j] == null){
            tableauPanneau[getPositionY()-j][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()-j));
            j++;
        }
        if(getPositionY()-j>=0 && plateau[getPositionX()][getPositionY()-j].getColor()!= getColor()){
            tableauPanneau[getPositionY()-j][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()-j));
        }
        int i = 1;
        j = 1;
        while(getPositionX()+i<=7 && getPositionY()+j<=7 && plateau[getPositionX()+i][getPositionY()+j]==null){
            tableauPanneau[getPositionY()+j][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()+j));
            i++;
            j++;
        }
        if(getPositionX()+i<=7 && getPositionY()+j<=7
                && plateau[getPositionX()+i][getPositionY()+j] != null
                && plateau[getPositionX()+i][getPositionY()+j].getColor() != getColor()){
            tableauPanneau[getPositionY()+j][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()+j));
        }

        i=1;
        j=1;
        while(getPositionX()+i<=7 && getPositionY()-j>=0 && plateau[getPositionX()+i][getPositionY()-j]==null){
            tableauPanneau[getPositionY()-j][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()-j));
            i++;
            j++;
        }
        if(getPositionX()+i<=7 && getPositionY()-j>=0
                && plateau[getPositionX()+i][getPositionY()-j] != null
                && plateau[getPositionX()+i][getPositionY()-j].getColor() != getColor()){
            tableauPanneau[getPositionY()-j][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()-j));
        }

        i=1;
        j=1;
        while(getPositionX()-i>=0 && getPositionY()-j>=0 && plateau[getPositionX()-i][getPositionY()-j]==null){
            tableauPanneau[getPositionY()-j][getPositionX()-i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()-j));
            i++;
            j++;
        }
        if(getPositionX()-i>=0 && getPositionY()-j>=0
                && plateau[getPositionX()-i][getPositionY()-j] != null
                && plateau[getPositionX()-i][getPositionY()-j].getColor() != getColor()){
            tableauPanneau[getPositionY()-j][getPositionX()-i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()-j));
        }

        i=1;
        j=1;
        while(getPositionX()-i>=0 && getPositionY()+j<=7 && plateau[getPositionX()-i][getPositionY()+j]==null){
            tableauPanneau[getPositionY()+j][getPositionX()-i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()+j));
            i++;
            j++;
        }
        if(getPositionX()-i>=0 && getPositionY()+j<=7
                && plateau[getPositionX()-i][getPositionY()+j] != null
                && plateau[getPositionX()-i][getPositionY()+j].getColor() != getColor()){
            tableauPanneau[getPositionY()+j][getPositionX()-i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()+j));
        }
    }
    public void mouvementRoi(Pane[][] tableauPanneau, Piece[][] plateau){
        listMouvement = new ArrayList<String>(1);
        int i  = 1;
        if(getPositionX()-i>=0 && (plateau[getPositionX() - i][getPositionY()] == null || plateau[getPositionX() - i][getPositionY()].getColor() != getColor())) {
            tableauPanneau[getPositionY()][getPositionX() - i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()));
        }
        if(getPositionX()+i<=7 && (plateau[getPositionX() + i][getPositionY()] == null || plateau[getPositionX() + i][getPositionY()].getColor() != getColor())) {
            tableauPanneau[getPositionY()][getPositionX() + i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()));
        }
        if(getPositionY()-i>=0 && (plateau[getPositionX()][getPositionY()-i] == null || plateau[getPositionX()][getPositionY()-i].getColor() != getColor())) {
            tableauPanneau[getPositionY()-i][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()-i));
        }
        if(getPositionY()+i<=7 && (plateau[getPositionX()][getPositionY()+i] == null || plateau[getPositionX()][getPositionY()+i].getColor() != getColor())) {
            tableauPanneau[getPositionY()+i][getPositionX()].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX() + "||" + (getPositionY()+i));
        }
        if(getPositionX()-i>=0 && getPositionY()-i>=0 && (plateau[getPositionX() - i][getPositionY()-i] == null || plateau[getPositionX() - i][getPositionY()-i].getColor() != getColor())) {
            tableauPanneau[getPositionY()-i][getPositionX() - i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()-i));
        }
        if(getPositionX()-i>=0 && getPositionY()+i<=7 && (plateau[getPositionX() - i][getPositionY()+i] == null || plateau[getPositionX() - i][getPositionY()+i].getColor() != getColor())) {
            tableauPanneau[getPositionY()+i][getPositionX() - i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()-i + "||" + (getPositionY()+i));
        }
        if(getPositionX()+i<=7 && getPositionY()-i>=0 && (plateau[getPositionX() + i][getPositionY()-i] == null || plateau[getPositionX() + i][getPositionY()-i].getColor() != getColor())) {
            tableauPanneau[getPositionY()-i][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()-i));
        }
        if(getPositionX()+i<=7 && getPositionY()+i<=7 && (plateau[getPositionX() + i][getPositionY()+i] == null || plateau[getPositionX() + i][getPositionY()+i].getColor() != getColor())) {
            tableauPanneau[getPositionY()+i][getPositionX()+i].setStyle("-fx-background-color: #DFE285");
            listMouvement.add(getPositionX()+i + "||" + (getPositionY()+i));
        }


    }
    public void mouvementPossible(Pane[][] tableauPanneau, Piece[][] plateau){
        switch (type){
            case 1:
                mouvementSoldat(tableauPanneau, plateau);
                break;
            case 2:
                mouvementTour(tableauPanneau, plateau);
                break;
            case 3:
                mouvementCavalier(tableauPanneau, plateau);
                break;
            case 4:
                mouvementFou(tableauPanneau, plateau);
                break;
            case 5:
                mouvementReine(tableauPanneau, plateau);
                break;
            case 6:
                mouvementRoi(tableauPanneau, plateau);
                break;
        }
    }
}
