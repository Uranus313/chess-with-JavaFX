import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox{
    public static void show(String title,String message){
        Stage stage = new Stage();
        VBox layout = new VBox();
        Label label = new Label(message);
        Button closeButton = new Button("close");
        closeButton.setOnAction(e -> stage.close());
        layout.getChildren().addAll(label,closeButton);
        Scene scene = new Scene(layout);
        layout.setAlignment(Pos.CENTER);
        stage.setMinHeight(200);
        stage.setMinWidth(200);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}