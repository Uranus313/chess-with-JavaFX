
import java.io.IOException;
import java.util.LinkedHashSet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;


    
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
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
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
        
    }

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
        allButtons[7][0] = new Rook(allButtons, 1,team1Moves);
        gridPane.add(allButtons[7][0], 0, 7);
        gridPane.getChildren().remove(allButtons[7][7]);
        allButtons[7][7] = new Rook(allButtons, 1,team1Moves);
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
        gridPane.getChildren().remove(allButtons[7][3]);
        allButtons[7][3] = new King(allButtons, 1,team1Moves,team2Moves);
        gridPane.add(allButtons[7][3], 3, 7);
        gridPane.getChildren().remove(allButtons[7][4]);
        allButtons[7][4] = new Queen(allButtons, 1,team1Moves);
        gridPane.add(allButtons[7][4], 4, 7);
        //loading team 2
        for(int j=0;j<8;j++){
            gridPane.getChildren().remove(allButtons[1][j]);
            allButtons[1][j] = new Pawn(allButtons, 2,false,team1Moves);
            gridPane.add(allButtons[1][j], j, 1);
        }
        gridPane.getChildren().remove(allButtons[0][0]);
        allButtons[0][0] = new Rook(allButtons, 2,team2Moves);
        gridPane.add(allButtons[0][0], 0, 0);
        gridPane.getChildren().remove(allButtons[0][7]);
        allButtons[0][7] = new Rook(allButtons, 2,team2Moves);
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
        gridPane.getChildren().remove(allButtons[0][3]);
        allButtons[0][3] = new King(allButtons, 2,team2Moves,team1Moves);
        gridPane.add(allButtons[0][3], 3, 0);
        gridPane.getChildren().remove(allButtons[0][4]);
        allButtons[0][4] = new Queen(allButtons, 2,team2Moves);
        gridPane.add(allButtons[0][4], 4, 0);
        // allButtons[0][4].updateRange(2,team2Moves);
        allButtons[0][3].updateRange(2, team2Moves);
        System.out.println(allButtons[0][3].getClass().toString().equals("class King"));
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
        for(int y=0;y<8;y++){
                        for(int x=0;x<8;x++){
                            if(this.allButtons[y][x].team==team && this.allButtons[y][x].getClass().toString().equals("class King")){
                                kingRow=y;
                                kingColumn=x;
                            }
                        }
                  }
        CustomButton startPos = allButtons[startRow][startColumn];
        CustomButton finalPos = allButtons[endRow][endColumn];
        allButtons[endRow][endColumn] = new Pawn(allButtons, team,true,teamMoves);
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
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Pawn(allButtons, team,true,teamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
    };
    public void actionSet(){
        this.setOnAction(e ->{
            if((turn+1)%2 == this.team%2){
            for (int i=0;i<8;i++) {
                for(int j=0;j<8;j++){
                    if(allButtons[i][j].equals(this)){

                        if(this.team==2){
                            
                            if(i<7){
                                if(allButtons[i+1][j].team == 0){
                                    
                                    final int I = i;
                                    final int J = j;
                                
                                    allButtons[i+1][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             
                                             gridPane.getChildren().remove(allButtons[I+1][J]);
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             allButtons[I+1][J] = new Pawn(allButtons, team,true,teamMoves);
                                             gridPane.add(allButtons[I+1][J], J, I+1);
                                             allButtons[I][J] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[I][J].allActionSet();
                                             turn++;
                                             
                                        }
                                    });
                                    if(i<6){
                                    if(!this.hasMoved && allButtons[i+2][j].team == 0){
                                    allButtons[i+2][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             gridPane.getChildren().remove(allButtons[I+2][J]);
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             allButtons[I+2][J] = new Pawn(allButtons, team,true,teamMoves);
                                             gridPane.add(allButtons[I+2][J], J, I+2);
                                             allButtons[I][J] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[I][J].allActionSet();
                                             turn++;
                                        }
                                    });
                                    }
                                }
                                }
                            if(j>0){
                            if(allButtons[i+1][j-1].team == 1){
                                final int I = i;
                                    final int J = j;

                                    allButtons[i+1][j-1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             gridPane.getChildren().remove(allButtons[I+1][J-1]);
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             allButtons[I+1][J-1] = new Pawn(allButtons, team,true,teamMoves);
                                             gridPane.add(allButtons[I+1][J-1], J-1, I+1);
                                             allButtons[I][J] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[I][J].allActionSet();
                                             turn++;
                                        }
                                    });
                            }
                        }   
                            if(j<7){
                            if(  allButtons[i+1][j+1].team == 1){
                                final int I = i;
                                    final int J = j;

                                    allButtons[i+1][j+1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             gridPane.getChildren().remove(allButtons[I+1][J+1]);
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             allButtons[I+1][J+1] = new Pawn(allButtons, team,true,teamMoves);
                                             gridPane.add(allButtons[I+1][J+1], J+1, I+1);
                                             allButtons[I][J] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[I][J].allActionSet();
                                             turn++;
                                        }
                                    });
                            }
                            }
                        }
                        }else{
                            if(i>0){
                                if(allButtons[i-1][j].team == 0){
                                    final int I = i;
                                    final int J = j;

                                    allButtons[i-1][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             gridPane.getChildren().remove(allButtons[I-1][J]);
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             allButtons[I-1][J] = new Pawn(allButtons, team,true, teamMoves);
                                             gridPane.add(allButtons[I-1][J], J, I-1);
                                             allButtons[I][J] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[I][J].allActionSet();
                                             turn++;
                                             
                                        }
                                    });
                                    if(!this.hasMoved && allButtons[i-2][j].team == 0){
                                    allButtons[i-2][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             gridPane.getChildren().remove(allButtons[I-2][J]);
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             allButtons[I-2][J] = new Pawn(allButtons, team,true, teamMoves);
                                             gridPane.add(allButtons[I-2][J], J, I-2);
                                             allButtons[I][J] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[I][J].allActionSet();
                                             turn++;
                                        }
                                    });
                                    }
                                }
                            if(j>0){
                            if( allButtons[i-1][j-1].team == 2){
                                final int I = i;
                                    final int J = j;

                                    allButtons[i-1][j-1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            gridPane.getChildren().remove(allButtons[I-1][J-1]);
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             allButtons[I-1][J-1] = new Pawn(allButtons, team,true, teamMoves);
                                             gridPane.add(allButtons[I-1][J-1], J-1, I-1);
                                             allButtons[I][J] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[I][J].allActionSet();
                                             turn++;
                                        }
                                    });
                            }
                        }   if(j<7){
                            if(allButtons[i-1][j+1].team == 2){
                                final int I = i;
                                    final int J = j;

                                    allButtons[i-1][j+1].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             gridPane.getChildren().remove(allButtons[I-1][J+1]);
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             allButtons[I-1][J+1] = new Pawn(allButtons, team,true, teamMoves);
                                             gridPane.add(allButtons[I-1][J+1], J+1, I-1);
                                             allButtons[I][J] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[I][J].allActionSet();
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
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Bishop(allButtons, team,teamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
    };
    public void actionSet(){
        this.setOnAction(e ->{
            
        new CustomButton(allButtons).fire();
        if((turn+1)%2 == this.team%2){
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                        
            int i=y-1;
            int j=x-1;
            final int Y = y;
            final int X = x;
            int color = 77;
            while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                if(!possibleMove(team, y, x, i, j)){
                    i--;j--;
                    continue;
                }
                if(allButtons[i][j].team==0){
                   
                allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Bishop(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setStyle("-fx-background-color:red;");
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Bishop(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                if(!possibleMove(team, y, x, i, j)){
                    i++;j--;
                    continue;
                }
                if(allButtons[i][j].team==0){
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Bishop(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Bishop(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                if(!possibleMove(team, y, x, i, j)){
                    i--;j++;
                    continue;
                }
                if(allButtons[i][j].team==0){
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;

                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Bishop(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Bishop(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                if(!possibleMove(team, y, x, i, j)){
                    i++;j++;
                    continue;
                }
                if(allButtons[i][j].team==0){
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;

                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Bishop(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Bishop(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                i++;j++;
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
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Knight(allButtons, team,teamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
    };
    public void actionSet(){
        this.setOnAction(e ->{
            new CustomButton(allButtons).fire();
            if((turn+1)%2 == this.team%2){
            for (int y=0;y<8;y++) {
                for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                        final int Y = y;
                        final int X = x;
                        System.out.println(Y+" "+X);
                        if(y+2 <8 && x+1<8){
                            final int I = y+2;
                            final int J = x+1;
                            if(allButtons[I][J].team == team){
                            }else{
                                System.out.println("Knight");
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Knight(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                        if(y+2 <8 && x-1>=0){
                            final int I = y+2;
                            final int J = x-1;
                            if(allButtons[I][J].team == team){
                            }else{
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Knight(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                            }
                        }
                        if(y+1 <8 && x+2<8){
                            final int I = y+1;
                            final int J = x+2;
                            if(allButtons[I][J].team == team){
                            }else{
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Knight(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                            }
                    }
                    if(y+1 <8 && x-2>=0){
                            final int I = y+1;
                            final int J = x-2;
                            if(allButtons[I][J].team == team){
                            }else{
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Knight(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                            }
                    }
                    if(y-1 >=0 && x-2>=0){
                            final int I = y-1;
                            final int J = x-2;
                            if(allButtons[I][J].team == team){
                            }else{
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Knight(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                            }
                }
                    if(y-1 >=0 && x+2<8){
                            final int I = y-1;
                            final int J = x+2;
                            if(allButtons[I][J].team == team){
                            }else{
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Knight(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                            }
                }   
                
                    if(y-2 >=0 && x+1<8){
                            final int I = y-2;
                            final int J = x+1;
                            if(allButtons[I][J].team == team){
                            }else{
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Knight(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                            }
                }
                    if(y-2 >=0 && x-1>=0){
                            final int I = y-2;
                            final int J = x-1;
                            if(allButtons[I][J].team == team){
                            }else{
                                allButtons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Knight(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
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
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Queen(allButtons, team,teamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
    };
    public void actionSet(){
        this.setOnAction(e ->{
            new CustomButton(allButtons).fire();
            if((turn+1)%2 == this.team%2){
        for (int y=0;y<8;y++) {
            for(int x=0;x<8;x++){
                    if(allButtons[y][x].equals(this)){
                                    int i=y-1;
            int j=x-1;
            final int Y = y;
            final int X = x;
            int color=77;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                final int I = i;
                final int J = j;
                
                if(allButtons[i][j].team==0){
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team,teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
                    allButtons[i][j].setStyle("-fx-background-color: rgb("+color+",166,255);");    
                color+=50;
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Queen(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
            allButtons[y][x].setStyle("-fx-background-color: gold");
        }
        }
    }
    
    }
}
class Rook extends CustomButton{
    Rook(CustomButton allButtons[][],int team,LinkedHashSet teamMoves){
        super(allButtons, team,teamMoves);
        this.setText("Rook");
        this.setStyle("-fx-background-color: orange;");
    }
    public void recolor(){
        this.setStyle("-fx-background-color: orange;");
    }
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new Rook(allButtons, team,teamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
    };
    public void actionSet(){
        this.setOnAction(e ->{
            new CustomButton(allButtons).fire();
            if((turn+1)%2 == this.team%2){
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
                if(!possibleMove(team, y, x, i, j)){
                    i--;
                    continue;
                }    
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Rook(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Rook(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                                    i--;
           
            }
            i=y+1;
            j=x;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(!possibleMove(team, y, x, i, j)){
                    i++;
                    continue;
                }
                if(allButtons[i][j].team==0){
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Rook(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Rook(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                i++;
            }
            i=y;
            j=x+1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(!possibleMove(team, y, x, i, j)){
                    j++;
                    continue;
                }
                if(allButtons[i][j].team==0){
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Rook(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Rook(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                    break;
                                }
                j++;
            }
            i=y;
            j=x-1;
                        while( i>=0 && i<=7 && j>=0 && j<=7){
                                final int I = i;
                final int J = j;
                if(!possibleMove(team, y, x, i, j)){
                    j--;
                    continue;
                }
                if(allButtons[i][j].team==0){
                allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Rook(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
                                             turn++;
                                             
                                        }
                                    });
                                }else if(allButtons[i][j].team==team){
                                    break;
                                }else{
                                    allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent arg0){
                                            
                                             gridPane.getChildren().remove(allButtons[I][J]);
                                             gridPane.getChildren().remove(allButtons[Y][X]);
                                             allButtons[I][J] = new Rook(allButtons, team, teamMoves);
                                             gridPane.add(allButtons[I][J], J, I);
                                             allButtons[Y][X] = new CustomButton(allButtons);
                                             gridPane.add(allButtons[Y][X], X, Y);
                                             allButtons[Y][X].fire();
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
            allButtons[y][x].setStyle("-fx-background-color: gold");
        }
        }
    }
    }
}
class King extends CustomButton{
    LinkedHashSet<Integer> enemyTeamMoves;
    King(CustomButton allButtons[][],int team,LinkedHashSet teamMoves,LinkedHashSet<Integer> enemyTeamMoves){
        super(allButtons, team,teamMoves);
        this.enemyTeamMoves = enemyTeamMoves;
        this.setText("King");
        this.setStyle("-fx-background-color: gold;");
    }
    public void recolor(){
        this.setStyle("-fx-background-color: gold;");
    }
    public void movePiece(int team,int startRow,int startColumn,int endRow,int endColumn){
        gridPane.getChildren().remove(allButtons[endRow][endColumn]);
        gridPane.getChildren().remove(allButtons[startRow][startColumn]);
        allButtons[endRow][endColumn] = new King(allButtons, team,teamMoves,enemyTeamMoves);
        allButtons[startRow][startColumn] = new CustomButton(allButtons);  
        gridPane.add(allButtons[endRow][endColumn], endColumn, endRow);
        gridPane.add(allButtons[startRow][startColumn], startColumn, startRow);
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
                    System.out.println(checkMate(y, x, team, enemyTeamMoves));
                    int i=y-1;
                    int j=x-1;
                    final int Y = y;
                    final int X = x;

                    if(y>0){
                        
                        if(x==0){
                        j++;
                        }
                    while( j <= x+1){
                        if(j>7){
                            System.out.println("blocked");
                            break;
                        }
                        if(checkKingMove(i, j,team, enemyTeamMoves)){
                            j++;
                            continue;
                        }

                        final int I = i;
                        final int J = j;
                        if(allButtons[i][j].team==0){
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                    gridPane.getChildren().remove(allButtons[I][J]);
                                    gridPane.getChildren().remove(allButtons[Y][X]);
                                    allButtons[I][J] = new King(allButtons, team, teamMoves,enemyTeamMoves);
                                    gridPane.add(allButtons[I][J], J, I);
                                    allButtons[Y][X] = new CustomButton(allButtons);
                                    gridPane.add(allButtons[Y][X], X, Y);
                                    allButtons[Y][X].fire();
;
                                    turn++;                   
                                }
                            });
                        }else if(allButtons[i][j].team==team){
                        }else{
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                    gridPane.getChildren().remove(allButtons[I][J]);
                                    gridPane.getChildren().remove(allButtons[Y][X]);
                                    allButtons[I][J] = new King(allButtons, team, teamMoves,enemyTeamMoves);
                                    gridPane.add(allButtons[I][J], J, I);
                                    allButtons[Y][X] = new CustomButton(allButtons);
                                    gridPane.add(allButtons[Y][X], X, Y);
                                    allButtons[Y][X].fire();
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
                    while( j <= x+1){
                        if(j>7){
                            System.out.println("blocked");
                            break;
                        }
                        if(checkKingMove(i, j, team, enemyTeamMoves)){
                            j+=2;
                            continue;
                        }
                        final int I = i;
                        final int J = j;
                        if(allButtons[i][j].team==0){
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                    gridPane.getChildren().remove(allButtons[I][J]);
                                    gridPane.getChildren().remove(allButtons[Y][X]);
                                    allButtons[I][J] = new King(allButtons, team, teamMoves,enemyTeamMoves);
                                    gridPane.add(allButtons[I][J], J, I);
                                    allButtons[Y][X] = new CustomButton(allButtons);
                                    gridPane.add(allButtons[Y][X], X, Y);
                                    allButtons[Y][X].fire();
;
                                     turn++;               
                                }
                            });
                        }else if(allButtons[i][j].team==team){
                        }else{
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                    gridPane.getChildren().remove(allButtons[I][J]);
                                    gridPane.getChildren().remove(allButtons[Y][X]);
                                    allButtons[I][J] = new King(allButtons, team, teamMoves,enemyTeamMoves);
                                    gridPane.add(allButtons[I][J], J, I);
                                    allButtons[Y][X] = new CustomButton(allButtons);
                                    gridPane.add(allButtons[Y][X], X, Y);
                                    allButtons[Y][X].fire();
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
                    while( j <= x+1){
                        if(j>7){
                            System.out.println("blocked");
                            break;
                        }
                        if(checkKingMove(i, j,team, enemyTeamMoves)){
                            j++;
                            continue;
                        }
    
                        final int I = i;
                        final int J = j;
                        if(allButtons[i][j].team==0){
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){

                                    gridPane.getChildren().remove(allButtons[I][J]);
                                    gridPane.getChildren().remove(allButtons[Y][X]);
                                    allButtons[I][J] = new King(allButtons, team, teamMoves,enemyTeamMoves);
                                    gridPane.add(allButtons[I][J], J, I);
                                    allButtons[Y][X] = new CustomButton(allButtons);
                                    gridPane.add(allButtons[Y][X], X, Y);
                                    allButtons[Y][X].fire();

                                    turn++;                
                                }
                            });
                        }else if(allButtons[i][j].team==team){
                        }else{
                            allButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent arg0){
;
                                    gridPane.getChildren().remove(allButtons[I][J]);
                                    gridPane.getChildren().remove(allButtons[Y][X]);
                                    allButtons[I][J] = new King(allButtons, team, teamMoves,enemyTeamMoves);
                                    gridPane.add(allButtons[I][J], J, I);
                                    allButtons[Y][X] = new CustomButton(allButtons);
                                    gridPane.add(allButtons[Y][X], X, Y);
                                    allButtons[Y][X].fire();
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