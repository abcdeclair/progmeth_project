package GUI;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu extends Application{
	
	public void start(Stage primaryStage) {
		// TODO
		Image imageview = new Image("testtest.png");
		StackPane root = new StackPane();
		MenuController menuControl = new MenuController();
		Canvas canvas = new Canvas(1400,800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().addAll(canvas);
		gc.drawImage(imageview, 0, 0,1400,800);
		
		Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Mobiews_Ocean");
	    //primaryStage.setResizable(false);
	    primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
