package MainGame;



import java.io.IOException;

import drawing.GameScreen;
import gamelogic.GameLogic;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class InGame extends Application {
	private static Button retrybtn;
	private static int currentLevel = 1;
	
	public static int getCurrentLevel() {
		return currentLevel;
	}

	public static void setCurrentLevel(int currentLevel) {
		InGame.currentLevel = currentLevel;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Fish game");
		
		GameLogic logic = new GameLogic();
		logic.settingLevel();
		GameScreen gameScreen = new GameScreen(1400, 800);
		retrybtn = new Button("Retry");
		retrybtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			
				retrybtn.setVisible(false);
//				logic.getRc().stop();
//				animation.stop();
//				logic.getRc().sleep(100);
//				logic.getRc().interrupt();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("menuButton.fxml"));
				Parent root = new Parent() {
				};
				try {
					root = loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Scene scene = new Scene(root);
				Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				((Node) (event.getSource())).getScene().getWindow().hide();
				app_stage.setScene(scene);
				app_stage.show();
			}
		});
		retrybtn.setVisible(false);
		root.getChildren().add(gameScreen);
		root.getChildren().add(retrybtn);
		gameScreen.requestFocus();
		
		stage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
			}
		};
		animation.start();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		       @Override
		       public void handle(WindowEvent e) {
		          try {
					stop();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		          System.exit(0);
		       }
		    });
	}
	
	@Override
	public void stop() throws Exception {
	    super.stop(); //To change body of generated methods, choose Tools | Templates.
	    System.exit(0);
	}

	public static Button getRetrybtn() {
		return retrybtn;
	}
	
}
