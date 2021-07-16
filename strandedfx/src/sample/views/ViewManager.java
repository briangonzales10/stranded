package sample.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.models.StrandedButton;

public class ViewManager {

    private static final int HEIGHT = 775;
    private static final int WIDTH = 1050;
    private static final int MENU_BUTTONS_START_X = 100;
    private static final int MENU_BUTTONS_START_Y = 225;

    private ArrayList<StrandedButton> buttonList;

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;


    public ViewManager(){
        buttonList = new ArrayList<>();
        //creating main window to hold all children
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT, Color.RED);
        mainStage = new Stage();
        //setting scene
        mainStage.setScene(mainScene);

        mainStage.setResizable(false);

        //creating buttons
        createButton();

        //creating Background from method
        createBackGround();

        createLogo();
    }

    //method to get main stage
    public  Stage getMainStage(){
        return mainStage;
    }


    private void createSTARTButtons(){
        StrandedButton button = new StrandedButton("Play");
        mainPane.getChildren().add(button);

        button.setLayoutX(200);
        button.setLayoutY(300);
    }


    private void addMenuButton(StrandedButton button){

        button.setLayoutY(MENU_BUTTONS_START_Y + buttonList.size() * 100);
        button.setLayoutX(MENU_BUTTONS_START_X);
        buttonList.add(button);
        mainPane.getChildren().add(button);
    }

    private void createButton(){

        createPlayButton();
        createScoreButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    private void createPlayButton(){
        StrandedButton scoreButton = new StrandedButton("PLAY");
        addMenuButton(scoreButton);

        scoreButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Stage primaryStage = new Stage();
                //Group root = new Group();
                Parent root = null;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../chooseAstronauts.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene chooseAstronauts = new Scene(root, Color.BLACK);

                primaryStage.setTitle("Create Play test");
                primaryStage.setResizable(false);
                primaryStage.setScene(chooseAstronauts);
                primaryStage.setWidth(WIDTH);
                primaryStage.setHeight(HEIGHT);
                primaryStage.show();
            }
        });
    }

    private void createScoreButton(){
        StrandedButton scoreButton = new StrandedButton("SCORE");
        addMenuButton(scoreButton);
    }

    private void createHelpButton(){

        StrandedButton helpButton = new StrandedButton("HELP");
        addMenuButton(helpButton);
    }

    private void createCreditsButton(){

        StrandedButton credButton = new StrandedButton("CREDITS");
        addMenuButton(credButton);
    }

    private void createExitButton(){
        StrandedButton exitButton = new StrandedButton("EXIT");
        addMenuButton(exitButton);
    }

    private void createBackGround(){
        Image mainBackImage = new Image("sample/views/resources/mainBackground.png",1000,800,false,true);
        BackgroundImage background = new BackgroundImage(mainBackImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                                                         BackgroundPosition.DEFAULT,null);

        mainPane.setBackground(new Background(background));
    }

    private void createLogo(){
        ImageView logo = new ImageView("sample/views/resources/logo.png");
        logo.setLayoutX(325);
        logo.setLayoutY(20);
        logo.setFitWidth(650);
        logo.setPreserveRatio(true);

        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DropShadow dropshad = new DropShadow();

                dropshad.setColor(Color.ORANGE);
                logo.setEffect(dropshad);
            }
        });
        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(null);
            }
        });

        mainPane.getChildren().add(logo);
    }
}
