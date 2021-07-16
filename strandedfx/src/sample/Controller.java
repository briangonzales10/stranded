package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import javafx.event.ActionEvent;


public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToStartGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("playScreen.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Stranded Play Screen");
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

//    public void goBackToMainMenu(ActionEvent event){
//
//    }
//    public void runMain(){
//        Main startMain = new Main();
//        startMain();
//    }



}
