package sample;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import javafx.event.ActionEvent;
import com.game.Main;

import javax.swing.*;


public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public TextField playerName;
    public Label displayAstroName;





    public void switchToStartGame(ActionEvent event) throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("playScreen.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Stranded Play Screen");

        submitName(event);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void startGameToFX() throws IOException, InterruptedException {
        Main.gameToFX();
    }



//    public void goBackToMainMenu(ActionEvent event){
//
//    }
//    public void runMain(){
//        Main startMain = new Main();
//        startMain();
//    }
    public String submitName(ActionEvent event){
        String name = playerName.getText();
        System.out.println("Player name is " + name);
//        displayAstroName.setText(name);
    return name;
    }





}
