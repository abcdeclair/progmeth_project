package GUI;


import javafx.scene.media.Media;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Menu extends Application{
	
	public static final String bgm = "/originalsoundtrack.mp3";
	public static AudioClip backgroundMusic;
	public void start(Stage primaryStage) throws Exception {
		// TODO
		
		backgroundMusic = new AudioClip(getClass().getResource(bgm).toExternalForm());
		backgroundMusic.setCycleCount(AudioClip.INDEFINITE);
		backgroundMusic.play();

		Parent root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
		Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Mobiews_Ocean");
	    primaryStage.setResizable(false);
	    primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
