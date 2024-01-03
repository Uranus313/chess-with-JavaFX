
import java.io.IOException;
import java.util.LinkedHashSet;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    private static Scene scene;
    BorderPane borderPane;

    
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        borderPane = new BorderPane();
        HBox leftSide = new HBox();
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setPadding(new Insets(10));
        leftSide.setSpacing(10);
        VBox leftLeftSide = new VBox();
        leftLeftSide.setAlignment(Pos.CENTER);
        VBox leftRightSide= new VBox();
        leftRightSide.setAlignment(Pos.CENTER);
        HBox rightSide = new HBox();
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setPadding(new Insets(10));
        rightSide.setSpacing(10);
        VBox rightLeftSide= new VBox();
        VBox rightRightSide= new VBox();
        HBox topSide = new HBox();
        Label label = new Label("30");
        topSide.setAlignment(Pos.CENTER);
        topSide.getChildren().add(label);
        rightLeftSide.setAlignment(Pos.CENTER);
        rightRightSide.setAlignment(Pos.CENTER);
        leftSide.getChildren().addAll(leftLeftSide,leftRightSide);
        rightSide.getChildren().addAll(rightLeftSide,rightRightSide);

        borderPane.setCenter(gridPane);
        borderPane.setLeft(leftSide);
        borderPane.setRight(rightSide);
        borderPane.setTop(topSide);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            //get the current value of the label as an integer
            int value = Integer.parseInt(label.getText());
            //if the value is greater than zero, subtract one and set the new value to the label
            if (value >= 1) {
                value--;
                label.setText(String.valueOf(value));
            } else {
                //if the value is zero, stop the timeline and print something
                if((CustomButton.turn+1)%2==1){
                    AlertBox.show("time ran out","Black won because white didnt play in time");
                }else{
                    AlertBox.show("time ran out","White won because black didnt play in time");
                }
                timeline.stop();
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        //play the timeline
        timeline.play();
        // CustomButton button[][] = new CustomButton[8][8];
        // for(int i=0;i<8;i++){
        //     for(int j=0;j<8;j++){
        //         final int I = i;
        //         final int J = j;
        //         button[i][j] = new CustomButton(button,gridPane);
        //         button[i][j].setText(i+" : "+j);
        //         // button[i][j].setStyle("-fx-background-color:grey; "+
        //         //             "-fx-background-radius: 0;"+
        //         //             "-fx-border-color:yellow;");
        //         // button[i][j].setOnAction(e -> {System.out.println("im number "+ I +" "+J);
        //         //     for(int y=0;y<8;y++){
        //         //         for(int x=0;x<8;x++){
        //         //             button[y][x].setStyle("-fx-background-color:grey; "+
        //         //             "-fx-background-radius: 0;"+
        //         //             "-fx-border-color:yellow;");
        //         //         }
        //         //   }
        //         // }
        //         // );
        //         button[i][j].setMinSize(80,80);
        //         gridPane.setPadding(new Insets(8));
        //         gridPane.setAlignment(Pos.CENTER);
        //         gridPane.add(button[i][j], j, i);
        //     }
        // }
        // button[5][6].setStyle("-fx-background-color: blue;");
    //     button[5][6].setStyle("-fx-background-color: blue;");
    //     button[5][6].setStyle("-fx-background-color: grey;");


    //     int x =4;
    //     int y=4;
    //    for(int j=0;j<8;j++){ 
    //    gridPane.getChildren().remove(button[7][j]); 
    //    button[7][j] = new Pawn(button, 1,false);
    //    gridPane.add(button[7][j], j, 7);
    //    } 
    //    for(int j=0;j<8;j++){ 
    //    gridPane.getChildren().remove(button[0][j]); 
    //    button[0][j] = new Pawn(button, 2,false);
    //    gridPane.add(button[0][j], j, 0);
    //    }
    //    gridPane.getChildren().remove(button[4][4]);
    //    button[4][4] = new Bishop(button, 1);
    //    gridPane.add(button[4][4], 4, 4);
    //    gridPane.getChildren().remove(button[3][3]);
    //    button[3][3] = new Rook(button, 2);
    //    gridPane.add(button[3][3], 3, 3);
    //    gridPane.getChildren().remove(button[2][2]);
    //    button[2][2] = new Knight(button, 1);
    //    gridPane.add(button[2][2], 2, 2);
    //    gridPane.getChildren().remove(button[5][5]);
    //    button[5][5] = new Queen(button, 2);
    //    gridPane.add(button[5][5], 5, 5);
       
    //     // button[y][x].setOnAction(e -> {
    //     //     int i=y;
    //     //     int j=x;
    //     //     while( i>=0 && i<=7 && j>=0 && j<=7){
    //     //         button[i][j].setStyle("-fx-background-color: blue");
    //     //         i--;j--;
    //     //         System.out.println("done");
    //     //     }
    //     //     i=y;
    //     //     j=x;
    //     //                 while( i>=0 && i<=7 && j>=0 && j<=7){
    //     //         button[i][j].setStyle("-fx-background-color: blue");
    //     //         i++;j--;
    //     //     }
    //     //     i=y;
    //     //     j=x;
    //     //                 while( i>=0 && i<=7 && j>=0 && j<=7){
    //     //         button[i][j].setStyle("-fx-background-color: blue");
    //     //         i--;j++;
    //     //     }
    //     //     i=y;
    //     //     j=x;
    //     //                 while( i>=0 && i<=7 && j>=0 && j<=7){
    //     //         button[i][j].setStyle("-fx-background-color: blue");
    //     //         i++;j++;
    //     //     }
    //     //     button[y][x].setStyle("-fx-background-color: gold");
                       
        // });
        new Game(gridPane);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
        
    }


/**
 * JavaFX App
 */
class ButtonWrapper{
    public CustomButton button;
    ButtonWrapper(CustomButton button){
        this.button = button;
    }
}
class Game {
    LinkedHashSet team1Moves;
    LinkedHashSet team2Moves;
    Game(GridPane gridPane){
        team1Moves = new LinkedHashSet<Integer>();
        team2Moves = new LinkedHashSet<Integer>();
        CustomButton allButtons[][] = new CustomButton[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                final int I = i;
                final int J = j;
                allButtons[i][j] = new CustomButton(allButtons,gridPane);
                allButtons[i][j].setText(i+" : "+j);
                // button[i][j].setStyle("-fx-background-color:grey; "+
                //             "-fx-background-radius: 0;"+
                //             "-fx-border-color:yellow;");
                // button[i][j].setOnAction(e -> {System.out.println("im number "+ I +" "+J);
                //     for(int y=0;y<8;y++){
                //         for(int x=0;x<8;x++){
                //             button[y][x].setStyle("-fx-background-color:grey; "+
                //             "-fx-background-radius: 0;"+
                //             "-fx-border-color:yellow;");
                //         }
                //   }
                // }
                // );
                allButtons[i][j].setMinSize(80,80);
                gridPane.setPadding(new Insets(8));
                gridPane.setAlignment(Pos.CENTER);
                gridPane.add(allButtons[i][j], j, i);
            }
        }
        // loading team 1
        for(int j=0;j<8;j++){
            gridPane.getChildren().remove(allButtons[6][j]);
            allButtons[6][j] = new Pawn(allButtons, 1,false,team1Moves);
            gridPane.add(allButtons[6][j], j, 6);
        }
        gridPane.getChildren().remove(allButtons[7][0]);
        allButtons[7][0] = new Rook(allButtons, 1,false,team1Moves);
        gridPane.add(allButtons[7][0], 0, 7);
        gridPane.getChildren().remove(allButtons[7][7]);
        allButtons[7][7] = new Rook(allButtons, 1,false,team1Moves);
        gridPane.add(allButtons[7][7], 7, 7);
        gridPane.getChildren().remove(allButtons[7][1]);
        allButtons[7][1] = new Knight(allButtons, 1,team1Moves);
        gridPane.add(allButtons[7][1], 1, 7);
        gridPane.getChildren().remove(allButtons[7][6]);
        allButtons[7][6] = new Knight(allButtons, 1,team1Moves);
        gridPane.add(allButtons[7][6], 6, 7);
        gridPane.getChildren().remove(allButtons[7][2]);
        allButtons[7][2] = new Bishop(allButtons, 1,team1Moves);
        gridPane.add(allButtons[7][2], 2, 7);
        gridPane.getChildren().remove(allButtons[7][5]);
        allButtons[7][5] = new Bishop(allButtons, 1,team1Moves);
        gridPane.add(allButtons[7][5], 5, 7);
        gridPane.getChildren().remove(allButtons[7][4]);
        allButtons[7][4] = new King(allButtons, 1,false,team1Moves,team2Moves);
        gridPane.add(allButtons[7][4], 4, 7);
        gridPane.getChildren().remove(allButtons[7][3]);
        allButtons[7][3] = new Queen(allButtons, 1,team1Moves);
        gridPane.add(allButtons[7][3], 3, 7);
        //loading team 2
        for(int j=0;j<8;j++){
            gridPane.getChildren().remove(allButtons[1][j]);
            allButtons[1][j] = new Pawn(allButtons, 2,false,team1Moves);
            gridPane.add(allButtons[1][j], j, 1);
        }
        gridPane.getChildren().remove(allButtons[0][0]);
        allButtons[0][0] = new Rook(allButtons, 2,false,team2Moves);
        gridPane.add(allButtons[0][0], 0, 0);
        gridPane.getChildren().remove(allButtons[0][7]);
        allButtons[0][7] = new Rook(allButtons, 2,false,team2Moves);
        gridPane.add(allButtons[0][7], 7, 0);
        gridPane.getChildren().remove(allButtons[0][1]);
        allButtons[0][1] = new Knight(allButtons, 2,team2Moves);
        gridPane.add(allButtons[0][1], 1, 0);
        gridPane.getChildren().remove(allButtons[0][6]);
        allButtons[0][6] = new Knight(allButtons, 2,team2Moves);
        gridPane.add(allButtons[0][6], 6, 0);
        gridPane.getChildren().remove(allButtons[0][2]);
        allButtons[0][2] = new Bishop(allButtons, 2,team2Moves);
        gridPane.add(allButtons[0][2], 2, 0);
        gridPane.getChildren().remove(allButtons[0][5]);
        allButtons[0][5] = new Bishop(allButtons, 2,team2Moves);
        gridPane.add(allButtons[0][5], 5, 0);
        gridPane.getChildren().remove(allButtons[0][4]);
        allButtons[0][4] = new King(allButtons, 2,false,team2Moves,team1Moves);
        gridPane.add(allButtons[0][4], 4, 0);
        gridPane.getChildren().remove(allButtons[0][3]);
        allButtons[0][3] = new Queen(allButtons, 2,team2Moves);
        gridPane.add(allButtons[0][3], 3, 0);
        // allButtons[0][4].updateRange(2,team2Moves);
        allButtons[0][4].updateRange(4, team2Moves);
        System.out.println(allButtons[0][4].getClass().toString().equals("class King"));
        // System.out.println(team2Moves);
        // if(team2Moves.contains(37)){
        //     System.out.println("true");
        // }
    }
}
class CustomButton extends Button{
    static GridPane gridPane;
    CustomButton allButtons[][];
    LinkedHashSet<Integer> teamMoves; 
    LinkedHashSet<Integer> allTeamMoves;
    int team;
    static int turn=0;
    boolean hasMoved=false;
    boolean En_Passant_right=false;
    boolean En_Passant_left=false;
    CustomButton(CustomButton allButtons[][]){
        super();
        teamMoves=new LinkedHashSet<Integer>();
        this.allTeamMoves = teamMoves;
        this.setMinSize(80, 80);
        this.allButtons = allButtons;
        this.team = 0;
        actionSet();
    }
    
    CustomButton(CustomButton allButtons[][],GridPane gridPane){
        super();
        teamMoves=new LinkedHashSet<Integer>();
        this.allButtons = allButtons;
        this.gridPane = gridPane;
        this.team = 0;
        actionSet();
    }
    CustomButton(CustomButton allButtons[][],int team,LinkedHashSet teamMoves){
        super();
        this.allTeamMoves = teamMoves;
        this.teamMoves=new LinkedHashSet<Integer>();
        this.setMinSize(80, 80);
        this.allButtons = allButtons;
        this.team = team;
        actionSet();
    }
    public boolean possibleMove(int team,int startRow,int startColumn,int endRow,int endColumn){
        int kingRow=0;
        int kingColumn=0;
        if(allButtons[startRow][startColumn].getClass()== new King(allButtons, team, hasMoved, teamMoves, allTeamMoves).getClass()){
            kingRow= endRow;
            kingColumn= endColumn;
        }else{
        for(int y=0;y<8;y++){
                        for(int x=0;x<8;x++){
                            if(this.allButtons[y][x].team==team && this.allButtons[y][x].getClass()== new King(allButtons, team, hasMoved, teamMoves, allTeamMoves).getClass()){
                                kingRow=y;
                                kingColumn=x;
                            }
                        }
                  }
                }
        CustomButton startPos = allButtons[startRow][startColumn];
        CustomButton finalPos = allButtons[endRow][endColumn];
        allButtons[endRow][endColumn] = startPos;
        allButtons[startRow][startColumn] = new CustomButton(allButtons);
        if(checkKingMove(kingRow, kingColumn, team, allTeamMoves)){
            allButtons[endRow][endColumn] = finalPos; 
            allButtons[startRow][startColumn] = startPos;
            return false;
        }
        allButtons[endRow][endColumn] = finalPos; 
        allButtons[startRow][startColumn] = startPos;          
        return true;          
    }
    public void updateRange(int team,LinkedHashSet enemyMoves){
        enemyMoves.clear();
        for(int y=0;y<8;y++){
                        for(int x=0;x<8;x++){
                            if(this.allButtons[y][x].team==team){
                                this.allButtons[y][x].getRange();
                                enemyMoves.addAll(allButtons[y][x].teamMoves);
                            }
                        }
                  }          
    }
    public boolean checkKingMove(int row,int column,int team,LinkedHashSet enemyMoves){
        if(team==1){
                        updateRange(2, enemyMoves);
                        }else{
                        updateRange(1, enemyMoves);
                        }
              
        if(enemyMoves.contains((row*10)+column)){

            return true;
        }
        return false;
    }
    public boolean checkMate(int row,int column,int team,LinkedHashSet enemyMoves){

        if(!checkKingMove(row, column,team, enemyMoves)){
            System.out.println("fast");
            return false;
        }
        CustomButton c = new CustomButton(allButtons);
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(this.allButtons[y][x].team==team){
                    this.allButtons[y][x].getRange();
                    for(int move : allButtons[y][x].teamMoves){
                        int cMove= move%10;
                        int rMove = (move-cMove)/10; 
                        if(allButtons[rMove][cMove].team==team){
                            continue;
                        }
                        CustomButton startPos = allButtons[y][x];
                        CustomButton finalPos = allButtons[rMove][cMove];
                        allButtons[rMove][cMove] = new Pawn(allButtons, team,true,teamMoves);
                        allButtons[y][x] = c;

                        if(!checkKingMove(row, column,team, enemyMoves)){
                            allButtons[y][x] = startPos;
                            allButtons[rMove][cMove] = finalPos;
                            System.out.println((y*10)+x);
                            System.out.println((rMove*10)+cMove);
                            return false;
                        }
                        allButtons[y][x] = startPos;
                        allButtons[rMove][cMove] = finalPos;
                    }
                }
            }
        }
        return true;
    }
    public void recolor(){
        this.setStyle("-fx-background-color: grey;");
    }
    public void actionSet(){
        this.setOnAction(e -> {
                                for(int y=0;y<8;y++){
                        for(int x=0;x<8;x++){
                            if(this.allButtons[y][x].team==0){
                            this.allButtons[y][x].setStyle("-fx-background-color:grey; "+
                            "-fx-background-radius: 0;"+
                            "-fx-border-color:yellow;");
                            }
                        }
                  }
                  this.allActionSet();

        });
    }
    public void allActionSet(){

        for(int y=0;y<8;y++){
                        for(int x=0;x<8;x++){
                            this.allButtons[y][x].actionSet();
                            this.allButtons[y][x].recolor();
                        }
        }
    }
    public void getRange(){};
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){};
}
class Pawn extends CustomButton{
    public boolean hasMoved = false;
    Pawn(CustomButton allButtons[][],int team,boolean hasMoved,LinkedHashSet teamMoves){
        super(allButtons,team,teamMoves);
        this.hasMoved = hasMoved;
        this.actionSet();
        this.setText("PAWN");
        if(team==2){
        this.setStyle("-fx-background-color:blue;");
        
        }else{
            this.setStyle("-fx-background-color:red;");
        }
    }
    public void recolor(){
        this.setStyle("-fx-background-color: blue;");
    }
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){
        HBox leftBox =(HBox)borderPane.getChildren().get(1);
        VBox leftLeftSide = (VBox)leftBox.getChildren().get(0);
        VBox rightLeftSide  = (VBox)leftBox.getChildren().get(1);
        HBox rightBox =(HBox)borderPane.getChildren().get(2);
        VBox leftRightSide= (VBox)rightBox.getChildren().get(0);
        VBox rightRightSide = (VBox)rightBox.getChildren().get(1);
        HBox topBox = (HBox)borderPane.getChildren().get(3);
        Label timeLabel = (Label)topBox.getChildren().get(0);
        timeLabel.setText("30");
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        if(allButtons[endRow][endColumn].getClass()!= new CustomButton(allButtons).getClass()){
            if(team==1){
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftRightSide.getChildren().size()<9){
                    leftRightSide.getChildren().add(label);
                }else{
                    rightRightSide.getChildren().add(label);
                }
            }else{
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftLeftSide.getChildren().size()<9){
                    leftLeftSide.getChildren().add(label);
                }else{
                    rightLeftSide.getChildren().add(label);
                }
            }
        }
        allButtons[endRow][endColumn] = new Pawn(allButtons, team,true,allTeamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++){
                allButtons[i][j].En_Passant_left=false;
                allButtons[i][j].En_Passant_right=false;
            }
        }
        new CustomButton(allButtons).fire();
        
        
    };
    public void actionSet(){
        this.setOnAction(e ->{
            
            new CustomButton(allButtons).fire();
            if((turn+1)%2 == this.team%2){
                
            for (int i=0;i<8;i++) {
                for(int j=0;j<8;j++){
                    
                    if(allButtons[i][j].equals(this)){
                        allButtons[i][j].setStyle("-fx-background-color: gold");
                        if(this.team==2){
                            
                            if(i<7){
                                if(En_Passant_left){
                                    
                                    if(allButtons[i+1][j-1].getClass()== new CustomButton(allButtons).getClass()){
                                        if(!possibleMove(team, i, j, i, j-1)){
                                        }else{
                                        allButtons[i+1][j-1].setStyle("-fx-background-color: rgb(230,166,255);");
                                        final int I=i;
                                        final int J=j;
                                        
                                        allButtons[i+1][j-1].setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent arg0) {
                                                movePiece(team, I, J, I, J-1);
                                                movePiece(team, I, J-1, I+1, J-1);
                                                // gridPane.getChildren().remove(allButtons[I + 1][J - 1]);
                                                // gridPane.getChildren().remove(allButtons[I][J]);
                                                // gridPane.getChildren().remove(allButtons[I][J - 1]);
                                                // allButtons[I + 1][J - 1] = new Pawn(allButtons, team, true, allTeamMoves);
                                                // gridPane.add(allButtons[I + 1][J - 1], J - 1, I + 1);
                                                // allButtons[I][J] = new CustomButton(allButtons);
                                                // gridPane.add(allButtons[I][J], J, I);
                                                // allButtons[I][J - 1] = new CustomButton(allButtons);
                                                // gridPane.add(allButtons[I][J - 1], J - 1, I);
                                                // allButtons[I][J].fire();
                                                turn++;
                                            }
                                        });
                                    }
                                    }
                                }
                                if(En_Passant_right){
                                    final int I=i;
                                    final int J=j;
                                    if(allButtons[I+1][J+1].getClass()== new CustomButton(allButtons).getClass()){
                                        if(!possibleMove(team, i, j, i, j+1)){
                                        }else{
                                        allButtons[i+1][j+1].setStyle("-fx-background-color: rgb(230,166,255);");
                                        allButtons[i+1][j+1].setOnAction(new EventHandler<ActionEvent>() {
                                            
                                            public void handle(ActionEvent arg0) {
                                                movePiece(team, I, J, I, J+1);
                                                movePiece(team, I, J+1, I+1, J+1);


                                                // gridPane.getChildren().remove(allButtons[I + 1][J + 1]);
                                                // gridPane.getChildren().remove(allButtons[I][J]);
                                                // gridPane.getChildren().remove(allButtons[I][J + 1]);
                                                // allButtons[I + 1][J + 1] = new Pawn(allButtons, team, true, allTeamMoves);
                                                // gridPane.add(allButtons[I + 1][J + 1], J + 1, I + 1);
                                                // allButtons[I][J] = new CustomButton(allButtons);
                                                // gridPane.add(allButtons[I][J], J, I);
                                                // allButtons[I][J + 1] = new CustomButton(allButtons);
                                                // gridPane.add(allButtons[I][J + 1], J + 1, I);
                                                // allButtons[I][J].fire();
                                                turn++;
                                            }
                                        });
                                    }
                                }
                                }
                                if(allButtons[i+1][j].team == 0){
                                    
                                    final int I = i;
                                    final int J = j;
                                if(!possibleMove(team, i, j, i+1, j)){
                                        }else{    
                                allButtons[i+1][j].setStyle("-fx-background-color: rgb(77,166,255);");
                                    allButtons[i+1][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             movePiece(team, I, J, I+1, J);
                                             turn++;
                                             
                                        }
                                    });
                                }   
                                    if(i<6){    
                                    if(!this.hasMoved && allButtons[i+2][j].team == 0){
                                        if(!possibleMove(team, i, j, i+2, j)){
                                        }else{    
                                    allButtons[i+2][j].setStyle("-fx-background-color: rgb(177,166,255);");    
                                    allButtons[i+2][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, I, J, I+2, J);
                                             if(J-1>=0){
                                                 if(allButtons[I+2][J-1].getClass()== new Pawn(allButtons,team,true,teamMoves).getClass()){
                                                    allButtons[I+2][J-1].En_Passant_right= true;
                                                 }
                                             }
                                            if(J+1<=7){
                                                if(allButtons[I+2][J+1].getClass()== new Pawn(allButtons,team,true,teamMoves).getClass()){
                                                    allButtons[I+2][J+1].En_Passant_left= true;
                                                }
                                            }
                                             turn++;
                                        }
                                    });
                                    }
                                }
                                }
                                }
                            if(j>0){
                            if(allButtons[i+1][j-1].team == 1){
                                final int I = i;
                                    final int J = j;
                                if(!possibleMove(team, i, j, i+1, j-1)){
                                        }else{        
                                allButtons[i+1][j-1].setStyle("-fx-background-color: red;");
                                    allButtons[i+1][j-1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             movePiece(team, I, J, I+1, J-1);

                                             turn++;
                                        }
                                    });
                            }
                        }
                        }   
                            if(j<7){
                            if(  allButtons[i+1][j+1].team == 1){
                                final int I = i;
                                    final int J = j;
                                    if(!possibleMove(team, i, j, i+1, j+1)){
                                        }else{    
                                allButtons[i+1][j+1].setStyle("-fx-background-color: red;");
                                    allButtons[i+1][j+1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, I, J, I+1, J+1);
                                             turn++;
                                        }
                                    });
                            }
                        }
                            }
                        }
                        }else{
                            if(i>0){
                                if(En_Passant_left){
                                    if(allButtons[i-1][j-1].getClass()== new CustomButton(allButtons).getClass()){
                                        final int I=i;
                                        final int J=j;
                                        if(!possibleMove(team, i, j, i, j-1)){
                                        }else{    
                                        allButtons[i-1][j-1].setStyle("-fx-background-color: rgb(230,166,255);");
                                        allButtons[i-1][j-1].setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent arg0) {
                                                movePiece(team, I, J, I, J-1);
                                                movePiece(team, I, J-1, I-1, J-1);
                                                // gridPane.getChildren().remove(allButtons[I - 1][J - 1]);
                                                // gridPane.getChildren().remove(allButtons[I][J]);
                                                // gridPane.getChildren().remove(allButtons[I][J - 1]);
                                                // allButtons[I - 1][J - 1] = new Pawn(allButtons, team, true, allTeamMoves);
                                                // gridPane.add(allButtons[I - 1][J - 1], J - 1, I - 1);
                                                // allButtons[I][J] = new CustomButton(allButtons);
                                                // gridPane.add(allButtons[I][J], J, I);
                                                // allButtons[I][J - 1] = new CustomButton(allButtons);
                                                // gridPane.add(allButtons[I][J - 1], J - 1, I);
                                                // allButtons[I][J].allActionSet();
                                                turn++;
                                            }
                                        });
                                    }
                                }
                                }
                                if(En_Passant_right){
                                    final int I=i;
                                    final int J=j;
                                    if(allButtons[I-1][J+1].getClass()== new CustomButton(allButtons).getClass()){
                                        if(!possibleMove(team, i, j, i, j+1)){
                                        }else{    
                                        allButtons[i-1][j+1].setStyle("-fx-background-color: rgb(230,166,255);");
                                        allButtons[i-1][j+1].setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent arg0) {
                                                movePiece(team, I, J, I, J+1);
                                                movePiece(team, I, J+1, I-1, J+1);


                                                // gridPane.getChildren().remove(allButtons[I - 1][J + 1]);
                                                // gridPane.getChildren().remove(allButtons[I][J]);
                                                // gridPane.getChildren().remove(allButtons[I][J + 1]);
                                                // allButtons[I - 1][J + 1] = new Pawn(allButtons, team, true, allTeamMoves);
                                                // gridPane.add(allButtons[I - 1][J + 1], J + 1, I - 1);
                                                // allButtons[I][J] = new CustomButton(allButtons);
                                                // gridPane.add(allButtons[I][J], J, I);
                                                // allButtons[I][J + 1] = new CustomButton(allButtons);
                                                // gridPane.add(allButtons[I][J + 1], J + 1, I);
                                                // allButtons[I][J].allActionSet();
                                                turn++;
                                            }
                                        });
                                    }
                                }
                                }
                                if(allButtons[i-1][j].team == 0){
                                    final int I = i;
                                    final int J = j;
                                    if(!possibleMove(team, i, j, i-1, j)){
                                        }else{    
                                    allButtons[i-1][j].setStyle("-fx-background-color: rgb(77,166,255);");
                                    allButtons[i-1][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, I, J, I-1, J);
                                             turn++;
                                             
                                        }
                                    });
                                }
                                    if(!this.hasMoved && allButtons[i-2][j].team == 0){
                                        if(!possibleMove(team, i, j, i-2, j)){
                                        }else{    
                                        allButtons[i-2][j].setStyle("-fx-background-color: rgb(177,166,255);");
                                    allButtons[i-2][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, I, J, I-2, J);
                                             if(J-1>=0){
                                                if(allButtons[I-2][J-1].getClass()== new Pawn(allButtons,team,true,teamMoves).getClass()){
                                                    allButtons[I-2][J-1].En_Passant_right= true;
                                                }
                                            }
                                            if(J+1<=7){
                                                if(allButtons[I-2][J+1].getClass()== new Pawn(allButtons,team,true,teamMoves).getClass()){
                                                    allButtons[I-2][J+1].En_Passant_left= true;
                                                }
                                            }
                                             turn++;
                                        }
                                    });
                                    }
                                }
                                }
                            if(j>0){
                            if( allButtons[i-1][j-1].team == 2){
                                final int I = i;
                                    final int J = j;
                                if(!possibleMove(team, i, j, i-1, j-1)){
                                        }else{        
                                allButtons[i-1][j-1].setStyle("-fx-background-color: red;");
                                    allButtons[i-1][j-1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, I, J, I-1, J-1);
                                             turn++;
                                        }
                                    });
                            }
                        }
                        }   if(j<7){
                            if(allButtons[i-1][j+1].team == 2){
                                final int I = i;
                                    final int J = j;
                                    if(!possibleMove(team, i, j, i+1, j)){
                                        }else{                                        
                                allButtons[i-1][j+1].setStyle("-fx-background-color: red;");
                                    allButtons[i-1][j+1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, I, J, I-1, J+1);
                                             turn++;
                                        }
                                    });
                            }
                        }
                        }
                            }
                        }
                    }
                }
            
                
            }


        }  
        });
    }
    
    
    public void changePiece(CustomButton piece,int y,int x){
                piece = new Pawn(allButtons, team,true, teamMoves);
                allButtons[y][x]= new CustomButton(allButtons);
    }
    public void getRange(){
        teamMoves.clear();
        for (int i=0;i<8;i++) {
                for(int j=0;j<8;j++){
                    if(allButtons[i][j].equals(this)){
                        if(this.team==2){
                            if(i<7){
                            if(j>0){
                                teamMoves.add(((i+1)*10)+j-1);

                        }   
                            if(j<7){
                                teamMoves.add(((i+1)*10)+j+1);
                            }
                        }
                        }else{
                            if(i>0){
                            if(j>0){
                                teamMoves.add(((i-1)*10)+j-1);

                        }   if(j<7){

                                teamMoves.add(((i-1)*10)+j+1);
                            
                        }
                            }
                        }
                    }
                } 
        }
        
    }
    
}
class Bishop extends CustomButton{
    Bishop(CustomButton allButtons[][],int team, LinkedHashSet teamMoves){
        super(allButtons, team,teamMoves);
        this.setText("Bishop");
        this.setStyle("-fx-background-color: silver;");
        // this.actionSet();
    }
    public void recolor(){
        this.setStyle("-fx-background-color: silver;");
    }
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){
        HBox leftBox =(HBox)borderPane.getChildren().get(1);
        VBox leftLeftSide = (VBox)leftBox.getChildren().get(0);
        VBox rightLeftSide  = (VBox)leftBox.getChildren().get(1);
        HBox rightBox =(HBox)borderPane.getChildren().get(2);
        VBox leftRightSide= (VBox)rightBox.getChildren().get(0);
        VBox rightRightSide = (VBox)rightBox.getChildren().get(1);
        HBox topBox = (HBox)borderPane.getChildren().get(3);
        Label timeLabel = (Label)topBox.getChildren().get(0);
        timeLabel.setText("30");
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        if(allButtons[endRow][endColumn].getClass()!= new CustomButton(allButtons).getClass()){
            if(team==1){
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftRightSide.getChildren().size()<9){
                    leftRightSide.getChildren().add(label);
                }else{
                    rightRightSide.getChildren().add(label);
                }
            }else{
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftLeftSide.getChildren().size()<9){
                    leftLeftSide.getChildren().add(label);
                }else{
                    rightLeftSide.getChildren().add(label);
                }
            }
        }
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Bishop(allButtons, team,allTeamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++){
                allButtons[i][j].En_Passant_left=false;
                allButtons[i][j].En_Passant_right=false;
            }
        }
        new CustomButton(allButtons).fire();
    };
    public void actionSet(){
        this.setOnAction(e ->{
            
        new CustomButton(allButtons).fire();
        if((turn+1)%2 == this.team%2){
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                        allButtons[y][x].setStyle("-fx-background-color: gold");
            int i=y-1;
            int j=x-1;
            final int Y = y;
            final int X = x;
            int color = 77;
            while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                
                if(allButtons[i][j].team==0){
                 if(!possibleMove(team, y, x, i, j)){
                    i--;j--;
                    continue;
                }  
                allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, Y, X, I, J);
                                             turn++;         
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }
                                    break;
                                    
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                             
                                        }
                                    });
                                    break;
                                }
                                    i--;j--;
           
            }
            i=y+1;
            j=x-1;
             color = 77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i++;j--;
                    continue;
                }
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                             
                                        }
                                    });
                                    break;
                                }
                i++;j--;
            }
            i=y-1;
            j=x+1;
             color = 77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i--;j++;
                    continue;
                }
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;

                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                i--;j++;
            }
            i=y+1;
            j=x+1;
            color = 77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i++;j++;
                    continue;
                }
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;

                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                i++;j++;
            }
        }
        }
    }
    }
        });
        
    }
    public void getRange(){
        teamMoves.clear();
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
            int i=y-1;
            int j=x-1;
            final int Y = y;
            final int X = x;
            while( i>=0 && i<=7 && j>=0 && j<=7){

                if(allButtons[i][j].team==0){
                    teamMoves.add((i*10)+j);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((i*10)+j);
                                    break;
                                }else{
                                    teamMoves.add((i*10)+j);

                                    break;
                                }
                                    i--;j--;
           
            }
            i=y+1;
            j=x-1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((i*10)+j);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((i*10)+j);                                   

                                    break;
                                }
                i++;j--;
            }
            i=y-1;
            j=x+1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){

                    teamMoves.add((i*10)+j);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    
                                    break;
                                }else{
                                   
                                        teamMoves.add((i*10)+j);
                                    break;
                                }
                i--;j++;
            }
            i=y+1;
            j=x+1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((i*10)+j);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((i*10)+j);
                                    break;
                                }
                i++;j++;
            }
        }
    }
}
    
    }
}
class Knight extends CustomButton{
    Knight(CustomButton allButtons[][],int team,LinkedHashSet teamMoves){
        super(allButtons, team,teamMoves);
        this.setText("Knight");
        this.setStyle("-fx-background-color: purple;");
    }
    public void recolor(){
        this.setStyle("-fx-background-color: purple;");
    }
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){
        HBox leftBox =(HBox)borderPane.getChildren().get(1);
        VBox leftLeftSide = (VBox)leftBox.getChildren().get(0);
        VBox rightLeftSide  = (VBox)leftBox.getChildren().get(1);
        HBox rightBox =(HBox)borderPane.getChildren().get(2);
        VBox leftRightSide= (VBox)rightBox.getChildren().get(0);
        VBox rightRightSide = (VBox)rightBox.getChildren().get(1);
        HBox topBox = (HBox)borderPane.getChildren().get(3);
        Label timeLabel = (Label)topBox.getChildren().get(0);
        timeLabel.setText("30");
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        if(allButtons[endRow][endColumn].getClass()!= new CustomButton(allButtons).getClass()){
            if(team==1){
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftRightSide.getChildren().size()<9){
                    leftRightSide.getChildren().add(label);
                }else{
                    rightRightSide.getChildren().add(label);
                }
            }else{
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftLeftSide.getChildren().size()<9){
                    leftLeftSide.getChildren().add(label);
                }else{
                    rightLeftSide.getChildren().add(label);
                }
            }
        }
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Knight(allButtons, team,allTeamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++){
                allButtons[i][j].En_Passant_left=false;
                allButtons[i][j].En_Passant_right=false;
            }
        }
        new CustomButton(allButtons).fire();
    };
    public void actionSet(){
        this.setOnAction(e ->{
            new CustomButton(allButtons).fire();
            if((turn+1)%2 == this.team%2){
            for (int y=0;y<8;y++) {
                for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                        allButtons[y][x].setStyle("-fx-background-color: gold");
                        final int Y = y;
                        final int X = x;
                        System.out.println(Y+" "+X);
                        if(y+2 <8 && x+1<8){
                            final int I = y+2;
                            final int J = x+1;
                            if(allButtons[I][J].team == team){
                            }else{
                                if(possibleMove(team, Y, X, I, J)){
                                System.out.println("Knight");
                                allButtons[I][J].setStyle("-fx-background-color:rgb(77,76,255);");
                                if(allButtons[I][J].team!=0){
                                  allButtons[I][J].setStyle("-fx-background-color:red;");  
                                }
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                        }
                        if(y+2 <8 && x-1>=0){
                            final int I = y+2;
                            final int J = x-1;
                            if(allButtons[I][J].team == team){
                            }else{
                                 if(possibleMove(team, Y, X, I, J)){
                                allButtons[I][J].setStyle("-fx-background-color:rgb(77,255,255);");
                                if(allButtons[I][J].team!=0){
                                  allButtons[I][J].setStyle("-fx-background-color:red;");  
                                }
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                        }
                        if(y+1 <8 && x+2<8){
                            final int I = y+1;
                            final int J = x+2;
                            if(allButtons[I][J].team == team){
                            }else{
                                 if(possibleMove(team, Y, X, I, J)){
                                allButtons[I][J].setStyle("-fx-background-color:rgb(77,236,255);");
                                if(allButtons[I][J].team!=0){
                                  allButtons[I][J].setStyle("-fx-background-color:red;");  
                                }
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                    }
                    if(y+1 <8 && x-2>=0){
                            final int I = y+1;
                            final int J = x-2;
                            if(allButtons[I][J].team == team){
                            }else{
                                 if(possibleMove(team, Y, X, I, J)){
                                allButtons[I][J].setStyle("-fx-background-color:rgb(77,106,255);");
                                if(allButtons[I][J].team!=0){
                                  allButtons[I][J].setStyle("-fx-background-color:red;");  
                                }
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                    }
                    if(y-1 >=0 && x-2>=0){
                            final int I = y-1;
                            final int J = x-2;
                            if(allButtons[I][J].team == team){
                            }else{
                                 if(possibleMove(team, Y, X, I, J)){
                                allButtons[I][J].setStyle("-fx-background-color:rgb(77,146,255);");
                                if(allButtons[I][J].team!=0){
                                  allButtons[I][J].setStyle("-fx-background-color:red;");  
                                }
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                }
                    if(y-1 >=0 && x+2<8){
                            final int I = y-1;
                            final int J = x+2;
                            if(allButtons[I][J].team == team){
                            }else{
                                 if(possibleMove(team, Y, X, I, J)){
                                allButtons[I][J].setStyle("-fx-background-color:rgb(77,176,255);");
                                if(allButtons[I][J].team!=0){
                                  allButtons[I][J].setStyle("-fx-background-color:red;");  
                                }
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                }   
                
                    if(y-2 >=0 && x+1<8){
                            final int I = y-2;
                            final int J = x+1;
                            if(allButtons[I][J].team == team){
                            }else{
                                 if(possibleMove(team, Y, X, I, J)){
                                allButtons[I][J].setStyle("-fx-background-color:rgb(77,206,255);");
                                if(allButtons[I][J].team!=0){
                                  allButtons[I][J].setStyle("-fx-background-color:red;");  
                                }
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                }
                    if(y-2 >=0 && x-1>=0){
                            final int I = y-2;
                            final int J = x-1;
                            if(allButtons[I][J].team == team){
                            }else{
                                 if(possibleMove(team, Y, X, I, J)){
                                allButtons[I][J].setStyle("-fx-background-color:rgb(77,236,255);");
                                if(allButtons[I][J].team!=0){
                                  allButtons[I][J].setStyle("-fx-background-color:red;");  
                                }
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                }             
            }
                }
            }
        }   
        });
    }
    public void getRange(){
        teamMoves.clear();
        for (int y=0;y<8;y++) {
                for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                        if(y+2 <8 && x+1<8){
                            final int I = y+2;
                            final int J = x+1;
                            if(allButtons[I][J].team == team){
                                teamMoves.add((I*10)+J);
                            }else{
                               teamMoves.add((I*10)+J);
                            }
                        }
                        if(y+2 <8 && x-1>=0){
                            final int I = y+2;
                            final int J = x-1;
                            if(allButtons[I][J].team == team){
                                teamMoves.add((I*10)+J);
                            }else{
                                teamMoves.add((I*10)+J);
                            }
                        }
                        if(y+1 <8 && x+2<8){
                            final int I = y+1;
                            final int J = x+2;
                            if(allButtons[I][J].team == team){
                                teamMoves.add((I*10)+J);
                            }else{
                                teamMoves.add((I*10)+J);
                            }
                    }
                    if(y+1 <8 && x-2>=0){
                            final int I = y+1;
                            final int J = x-2;
                            if(allButtons[I][J].team == team){
                                teamMoves.add((I*10)+J);
                            }else{
                                teamMoves.add((I*10)+J);
                            }
                    }
                    if(y-1 >=0 && x-2>=0){
                            final int I = y-1;
                            final int J = x-2;
                            if(allButtons[I][J].team == team){
                                teamMoves.add((I*10)+J);
                            }else{
                                 teamMoves.add((I*10)+J);
                            }
                }
                    if(y-1 >=0 && x+2<8){
                            final int I = y-1;
                            final int J = x+2;
                            if(allButtons[I][J].team == team){
                                teamMoves.add((I*10)+J);
                            }else{
                                teamMoves.add((I*10)+J);
                            }
                }   
                    if(y-2 >=0 && x+1<8){
                            final int I = y-2;
                            final int J = x+1;
                            if(allButtons[I][J].team == team){
                                teamMoves.add((I*10)+J);
                            }else{
                                teamMoves.add((I*10)+J);       
                            }
                }
                    if(y-2 >=0 && x-1>=0){
                            final int I = y-2;
                            final int J = x-1;
                            if(allButtons[I][J].team == team){
                                teamMoves.add((I*10)+J);
                            }else{
                                teamMoves.add((I*10)+J);
                            }
                }             
            }
                }
            }
    }
}
class Queen extends CustomButton{
    Queen(CustomButton allButtons[][],int i,LinkedHashSet teamMoves){
        super(allButtons, i,teamMoves);
        this.setText("Queen");
        this.setStyle("-fx-background-color: pink; ");
    }
    public void recolor(){
        this.setStyle("-fx-background-color: pink;");
    }
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){
        HBox leftBox =(HBox)borderPane.getChildren().get(1);
        VBox leftLeftSide = (VBox)leftBox.getChildren().get(0);
        VBox rightLeftSide  = (VBox)leftBox.getChildren().get(1);
        HBox rightBox =(HBox)borderPane.getChildren().get(2);
        VBox leftRightSide= (VBox)rightBox.getChildren().get(0);
        VBox rightRightSide = (VBox)rightBox.getChildren().get(1);
        HBox topBox = (HBox)borderPane.getChildren().get(3);
        Label timeLabel = (Label)topBox.getChildren().get(0);
        timeLabel.setText("30");
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        if(allButtons[endRow][endColumn].getClass()!= new CustomButton(allButtons).getClass()){
            if(team==1){
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftRightSide.getChildren().size()<9){
                    leftRightSide.getChildren().add(label);
                }else{
                    rightRightSide.getChildren().add(label);
                }
            }else{
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftLeftSide.getChildren().size()<9){
                    leftLeftSide.getChildren().add(label);
                }else{
                    rightLeftSide.getChildren().add(label);
                }
            }
        }
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Queen(allButtons, team,allTeamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++){
                allButtons[i][j].En_Passant_left=false;
                allButtons[i][j].En_Passant_right=false;
            }
        }
        new CustomButton(allButtons).fire();
    };
    public void actionSet(){
        this.setOnAction(e ->{
            new CustomButton(allButtons).fire();
            if((turn+1)%2 == this.team%2){
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                        allButtons[y][x].setStyle("-fx-background-color: gold");
                                    int i=y-1;
            int j=x-1;
            final int Y = y;
            final int X = x;
            int color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i--;j--;
                    continue;
                    }  
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[I][J].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                                    i--;j--;
           
            }
            i=y+1;
            j=x-1;
            color = 77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;

                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i++;j--;
                    continue;
                    }  
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[I][J].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                            turn++; 
                                             
                                        }
                                    });
                                    break;
                                }
                i++;j--;
            }
        
            i=y-1;
            j=x+1;
            color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i--;j++;
                    continue;
                    }  
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[I][J].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                i--;j++;
            }
            i=y+1;
            j=x+1;
            color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i++;j++;
                    continue;
                    }  
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[I][J].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                i++;j++;
            }
            i=y-1;
            j=x;
            color=77;
            while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                 
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i--;
                    continue;
                    }  
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[I][J].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                                    i--;;
           
            }
            i=y+1;
            j=x;
            color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i++;
                    continue;
                    }  
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[I][J].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                i++;
            }
            i=y;
            j=x+1;
            color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    j++;
                    continue;
                    }  
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[I][J].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                j++;
            }
            i=y;
            j=x-1;
            color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    j--;
                    continue;
                    } 
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[I][J].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                            turn++; 
                                             
                                        }
                                    });
                                    break;
                                }
                j--;
            }
            allButtons[y][x].setStyle("-fx-background-color: gold");
        }
        }
    }
    }
        });
    }
    public void getRange(){
        teamMoves.clear();
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                                    int i=y-1;
            int j=x-1;
            final int Y = y;
            final int X = x;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    
                                    break;
                                }
                                    i--;j--;
           
            }
            i=y+1;
            j=x-1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                i++;j--;
            }
            i=y-1;
            j=x+1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                i--;j++;
            }
            i=y+1;
            j=x+1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                i++;j++;
            }
            i=y-1;
            j=x;
            while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);                   

                                    break;
                                }
                                    i--;;
           
            }
            i=y+1;
            j=x;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                i++;
            }
            i=y;
            j=x+1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                j++;
            }
            i=y;
            j=x-1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                j--;
            }
        }
        }
    }
    
    }
}
class Rook extends CustomButton{
    Rook(CustomButton allButtons[][],int team,boolean hasMoved,LinkedHashSet teamMoves){
        super(allButtons, team,teamMoves);
        this.hasMoved = hasMoved;
        this.setText("Rook");
        this.setStyle("-fx-background-color: orange;");
    }
    public void recolor(){
        this.setStyle("-fx-background-color: orange;");
    }
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){
        HBox leftBox =(HBox)borderPane.getChildren().get(1);
        VBox leftLeftSide = (VBox)leftBox.getChildren().get(0);
        VBox rightLeftSide  = (VBox)leftBox.getChildren().get(1);
        HBox rightBox =(HBox)borderPane.getChildren().get(2);
        VBox leftRightSide= (VBox)rightBox.getChildren().get(0);
        VBox rightRightSide = (VBox)rightBox.getChildren().get(1);
        HBox topBox = (HBox)borderPane.getChildren().get(3);
        Label timeLabel = (Label)topBox.getChildren().get(0);
        timeLabel.setText("30");
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        if(allButtons[endRow][endColumn].getClass()!= new CustomButton(allButtons).getClass()){
            if(team==1){
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftRightSide.getChildren().size()<9){
                    leftRightSide.getChildren().add(label);
                }else{
                    rightRightSide.getChildren().add(label);
                }
            }else{
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftLeftSide.getChildren().size()<9){
                    leftLeftSide.getChildren().add(label);
                }else{
                    rightLeftSide.getChildren().add(label);
                }
            }
        }
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Rook(allButtons, team,true,allTeamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++){
                allButtons[i][j].En_Passant_left=false;
                allButtons[i][j].En_Passant_right=false;
            }
        }
        new CustomButton(allButtons).fire();
    };
    public void actionSet(){
        this.setOnAction(e ->{
            new CustomButton(allButtons).fire();
            if((turn+1)%2 == this.team%2){
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                        allButtons[y][x].setStyle("-fx-background-color: gold");
            int i=y-1;
            int j=x;
            final int Y = y;
            final int X = x;
            int color = 77;            
            while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i--;
                    continue;
                    }  
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             movePiece(team, Y, X, I, J);
                                             turn++;
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                                    i--;
           
            }
            i=y+1;
            j=x;
            color = 77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                
               
                
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    i++;
                    continue;
                    } 
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                i++;
            }
            i=y;
            j=x+1;
            color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                
                
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    j++;
                    continue;
                }
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                j++;
            }
            i=y;
            j=x-1;
            color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                
                
                if(allButtons[i][j].team==0){
                    if(!possibleMove(team, y, x, i, j)){
                    j--;
                    continue;
                }
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    if(!possibleMove(team, y, x, i, j)){
                                        break;
                                    }  
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                            movePiece(team, Y, X, I, J);
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                j--;
            }
        }
        }
    }
}
        });
    }
    public void getRange(){
        teamMoves.clear();
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
            int i=y-1;
            int j=x;
            final int Y = y;
            final int X = x;
 
            while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                    teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                                    i--;;
           
            }
            i=y+1;
            j=x;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                i++;
            }
            i=y;
            j=x+1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                j++;
            }
            i=y;
            j=x-1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(allButtons[i][j].team==0){
                teamMoves.add((I*10)+J);
                                }else if(allButtons[i][j].team==team){
                                    teamMoves.add((I*10)+J);
                                    break;
                                }else{
                                    teamMoves.add((I*10)+J);
                                    break;
                                }
                j--;
            }
            
        }
        }
    }
    }
}
class King extends CustomButton{
    LinkedHashSet<Integer> enemyTeamMoves;
    King(CustomButton allButtons[][],int team,boolean hasMoved,LinkedHashSet teamMoves,LinkedHashSet<Integer> enemyTeamMoves){
        super(allButtons, team,teamMoves);
        this.hasMoved = hasMoved;
        this.enemyTeamMoves = enemyTeamMoves;
        this.setText("King");
        this.setStyle("-fx-background-color: gold;");
    }
    public void recolor(){
        this.setStyle("-fx-background-color: gold;");
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                if(allButtons[y][x].equals(this)){
                    if(checkKingMove(y, x, team, enemyTeamMoves)){
                        this.setStyle("-fx-background-color: rgb(255,25,255);");
                    }
                }
            }
        }
        
    }
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){
        HBox leftBox =(HBox)borderPane.getChildren().get(1);
        VBox leftLeftSide = (VBox)leftBox.getChildren().get(0);
        VBox rightLeftSide  = (VBox)leftBox.getChildren().get(1);
        HBox rightBox =(HBox)borderPane.getChildren().get(2);
        VBox leftRightSide= (VBox)rightBox.getChildren().get(0);
        VBox rightRightSide = (VBox)rightBox.getChildren().get(1);
        HBox topBox = (HBox)borderPane.getChildren().get(3);
        Label timeLabel = (Label)topBox.getChildren().get(0);
        timeLabel.setText("30");
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        if(allButtons[endRow][endColumn].getClass()!= new CustomButton(allButtons).getClass()){
            if(team==1){
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftRightSide.getChildren().size()<9){
                    leftRightSide.getChildren().add(label);
                }else{
                    rightRightSide.getChildren().add(label);
                }
            }else{
                Label label = new Label();
                label.setText(allButtons[endRow][endColumn].getText());
                if(leftLeftSide.getChildren().size()<9){
                    leftLeftSide.getChildren().add(label);
                }else{
                    rightLeftSide.getChildren().add(label);
                }
            }
        }
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new King(allButtons, team,true,allTeamMoves,enemyTeamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++){
                allButtons[i][j].En_Passant_left=false;
                allButtons[i][j].En_Passant_right=false;
            }
        }
        new CustomButton(allButtons).fire();
    };
    public void actionSet(){

        this.setOnAction(e ->{
            new CustomButton(allButtons).fire();
            if((turn+1)%2 == this.team%2){
        if(this.team==1){
            updateRange(2,enemyTeamMoves);
        }else{
            updateRange(1,enemyTeamMoves);
        }
        
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                if(allButtons[y][x].equals(this)){
                    allButtons[y][x].setStyle("-fx-background-color: gold");
                    System.out.println(checkMate(y, x, team, enemyTeamMoves));
                    int i=y-1;
                    int j=x-1;
                    final int Y = y;
                    final int X = x;
                    int leftRookColumn=0;
                    int rightRookColumn=7;
                    int rookRow;
                    if(this.team==1){
                        rookRow=7;
                    }else{
                        rookRow=0;
                    }

                    if(!this.hasMoved && !checkKingMove(Y,X,team,enemyTeamMoves)){
                        if(allButtons[rookRow][leftRookColumn].getClass()== new Rook(allButtons,1,false,teamMoves).getClass()){
                            if(!allButtons[rookRow][leftRookColumn].hasMoved){
                                boolean checker = false;
                                for(int column =leftRookColumn+1;column<x;column++){
                                    if(allButtons[rookRow][column].getClass()!= new CustomButton(allButtons).getClass()){
                                        checker = true;
                                        break;
                                    }
                                    if(checkKingMove(rookRow,column,team,enemyTeamMoves)){
                                        checker = true;
                                        break;
                                    }
                                }
                                if(!checker){
                                    allButtons[rookRow][leftRookColumn+2].setStyle("-fx-background-color:rgb(85,255,0)");
                                    allButtons[rookRow][leftRookColumn+2].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, Y, X, Y, X-2);
                                            Rook x =(Rook)allButtons[rookRow][leftRookColumn];
                                            x.movePiece(team, rookRow, leftRookColumn, Y, X-1);
                                            // gridPane.getChildren().remove(allButtons[Y][X]);
                                            // gridPane.getChildren().remove(allButtons[Y][X-1]);
                                            // gridPane.getChildren().remove(allButtons[Y][X-2]);
                                            // gridPane.getChildren().remove(allButtons[Y][X-4]);
                                            // allButtons[Y][X-2] = new King(allButtons, team,true, allTeamMoves,enemyTeamMoves);
                                            // gridPane.add(allButtons[Y][X-2], X-2, Y);
                                            // allButtons[Y][X] = new CustomButton(allButtons);
                                            // gridPane.add(allButtons[Y][X], X, Y);
                                            // allButtons[Y][X-1] = new Rook(allButtons,team,true,allTeamMoves);
                                            // gridPane.add(allButtons[Y][X-1], X-1, Y);
                                            // allButtons[Y][X-4] = new CustomButton(allButtons);
                                            // gridPane.add(allButtons[Y][X-4], X-4, Y);
                                            // allButtons[Y][X].fire();
                                            turn++;
                                        }
                                    });
                                }
                            }
                        }
                        if(allButtons[rookRow][rightRookColumn].getClass()== new Rook(allButtons,1,false,teamMoves).getClass()){
                            if(!allButtons[rookRow][rightRookColumn].hasMoved){
                                boolean checker = false;
                                for(int column =rightRookColumn-1;column>x;column--){
                                    if(allButtons[rookRow][column].getClass()!= new CustomButton(allButtons).getClass()){
                                        checker = true;
                                        break;
                                    }
                                    if(checkKingMove(rookRow,column,team,enemyTeamMoves)){
                                        checker = true;
                                        break;
                                    }
                                }
                                if(!checker){
                                    allButtons[rookRow][rightRookColumn-2].setStyle("-fx-background-color:rgb(85,255,0)");
                                    allButtons[rookRow][rightRookColumn-1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            movePiece(team, Y, X, Y, X+2);
                                            Rook x =(Rook)allButtons[rookRow][rightRookColumn];
                                            x.movePiece(team, rookRow, rightRookColumn, Y, X+1);
                                            // gridPane.getChildren().remove(allButtons[Y][X]);
                                            // gridPane.getChildren().remove(allButtons[Y][X+1]);
                                            // gridPane.getChildren().remove(allButtons[Y][X+2]);
                                            // gridPane.getChildren().remove(allButtons[Y][X+3]);
                                            // allButtons[Y][X+2] = new King(allButtons, team,true, allTeamMoves,enemyTeamMoves);
                                            // gridPane.add(allButtons[Y][X+2], X+2, Y);
                                            // allButtons[Y][X] = new CustomButton(allButtons);
                                            // gridPane.add(allButtons[Y][X], X, Y);
                                            // allButtons[Y][X+1] = new Rook(allButtons,team,true,allTeamMoves);
                                            // gridPane.add(allButtons[Y][X+1], X+1, Y);
                                            // allButtons[Y][X+3] = new CustomButton(allButtons);
                                            // gridPane.add(allButtons[Y][X+3], X+3, Y);
                                            // allButtons[Y][X].fire();
                                            turn++;
                                        }
                                    });
                                }
                            }
                        }
                    }
                    if(y>0){
                        
                        if(x==0){
                        j++;
                        }
                    int color = 100;    
                    while( j <= x+1){
                        if(j>7){
                            System.out.println("blocked");
                            break;
                        }
                        if(!possibleMove(team, y, x, i, j)){
                        System.out.println("cant move");
                        j++;
                        continue;
                        }  

                        final int I = i;
                        final int J = j;
                        
                        if(allButtons[i][j].team==0){
                            allButtons[I][J].setStyle("-fx-background-color:rgb(77,"+color+",255);");
                            color+=40;   
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
                                 
                                movePiece(team, Y, X, I, J);

                                    turn++;                   
                                }
                            });
                        }else if(allButtons[i][j].team==team){
                        }else{
                            allButtons[i][j].setStyle("-fx-background-color:red;");
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                movePiece(team, Y, X, I, J);
;
                                    turn++;                
                                }
                            });
                        }
                        j++;;
                    }
                }
                    i=y;
                    j=x-1;

                    if(x==0){
                        j+=2;
                    }
                    System.out.println(x+1);
                    int color = 220;
                    while( j <= x+1){
                        if(j>7){
                            System.out.println("blocked");
                            break;
                        }
                        if(!possibleMove(team, y, x, i, j)){
                        j+=2;
                        continue;
                        }  
                        final int I = i;
                        final int J = j;
                        
                        if(allButtons[i][j].team==0){
                            allButtons[I][J].setStyle("-fx-background-color:rgb(77,"+color+",255);");
                            color+=40;
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                movePiece(team, Y, X, I, J);
;
                                     turn++;               
                                }
                            });
                        }else if(allButtons[i][j].team==team){
                        }else{
                            allButtons[i][j].setStyle("-fx-background-color:red;");
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                movePiece(team, Y, X, I, J);
;
                                     turn++;               
                                }
                            });
                        }
                        j+=2;
                    }
                    i=y+1;
                    j=x-1;
                    if(y<7){
                        if(x==0){
                        j++;
                        }
                    color=0;
                    while( j <= x+1){
                        if(j>7){
                            System.out.println("blocked");
                            break;
                        }
                        if(!possibleMove(team, y, x, i, j)){
                        j++;
                        continue;
                        }  
    
                        final int I = i;
                        final int J = j;
                        
                        if(allButtons[i][j].team==0){
                            allButtons[I][J].setStyle("-fx-background-color:rgb(77,"+color+",255);");
                            color+=40;
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){

                                movePiece(team, Y, X, I, J);

                                    turn++;                
                                }
                            });
                        }else if(allButtons[i][j].team==team){
                        }else{
                            allButtons[i][j].setStyle("-fx-background-color:red;");
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                movePiece(team, Y, X, I, J);
;
                                    turn++;                
                                }
                            });
                        }
                        j++;
                    }
                }
                            
                }
                }
            }
    }});
    }
    public void getRange(){
        teamMoves.clear();
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                if(allButtons[y][x].equals(this)){
                    int i=y-1;
                    int j=x-1;

                    while( j <= x+1){
                            int n = (i*10)+j;
                            if(n>=0 && n<=77){
                            teamMoves.add(n);
                            }
                            j++;
                    }
                    i=y;
                    j=x-1;
                    while( j <= x+1){
                            int n = (i*10)+j;
                            if(n>=0 && n<=77){
                            teamMoves.add(n);
                            }
                        j+=2;
                    }
                    i=y+1;
                    j=x-1;
                    while( j <= x+1){
                            int n = (i*10)+j;
                            if(n>=0 && n<=77){
                            teamMoves.add(n);
                            }
                        j++;
                    }
                            
                }
                }
            }
    }
    
}
}