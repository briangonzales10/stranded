package sample;

import java.util.Objects;

import com.game.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.views.ViewManager;
import javafx.concurrent.Task;
import com.game.Main;

public class MenuMain extends Application {

    @Override
    public void start(Stage menuStage) throws Exception{

        ViewManager manager = new ViewManager();
        menuStage = manager.getMainStage();
       // Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        menuStage.setTitle("Stranded");
       // menuStage.setScene(new Scene(root, 300, 275, Color.GREENYELLOW));
        menuStage.show();
    }





    public static void main(String[] args) {
        launch(args);
    }
}
