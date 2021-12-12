package MainGame;



import drawing.GameScreen;
import gamelogic.GameLogic;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InGame extends Application {
	private static Button retrybtn;
	
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
		GameScreen gameScreen = new GameScreen(1400, 800);
		retrybtn = new Button("Retry");
		retrybtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				logic.newGame();
				retrybtn.setVisible(false);
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
	}

	public static Button getRetrybtn() {
		return retrybtn;
	}
	
}
