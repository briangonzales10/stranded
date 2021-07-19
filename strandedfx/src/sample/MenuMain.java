package sample;

import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

import com.game.Main;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.views.ViewManager;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MenuMain extends Application {

    @Override
    public void start(Stage menuStage) throws Exception{
        music();
        ViewManager manager = new ViewManager();
        menuStage = manager.getMainStage();
       // Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        menuStage.setTitle("Stranded");
       // menuStage.setScene(new Scene(root, 300, 275, Color.GREENYELLOW));
        menuStage.show();

//        Media media = new Media("menu_song.mp3");

//        File file = new File("menu_song.mp3");
//        String path = file.getAbsolutePath();
//        System.out.println(path);
//        Media media = new Media(new File(path).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setAutoPlay(true);

    }
    MediaPlayer mediaPlayer;
    public void music() {
        String s = "src/sample/models/resources/menu_song.mp3";
        String path = Paths.get(s).toUri().toString();
        System.out.println(path);
        Media h = new Media(path);
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();

    }




    public static void main(String[] args) {
        launch(args);

    }
}
