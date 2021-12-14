package GUI;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import MainGame.IRenderable;
import MainGame.RenderableHolder;
import drawing.GameScreen;
import gamelogic.GameLogic;
import input.InputUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MenuController extends VBox implements Initializable {
	

	@FXML
	public Button playgameButton;

	@FXML
	private void PlaygameClick(ActionEvent event) throws IOException {
		MainGame.RenderableHolder.clickSound.play();
//		clickSound.setVolume(0.15);

//		FXMLLoader loader = new FXMLLoader(getClass().getResource("settingTask.fxml"));
//		Parent root = loader.load();
//		Scene scene = new Scene(root);
//		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		app_stage.setScene(scene);
//		app_stage.show();
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
//		stage.setScene(scene);
//		stage.setTitle("Fish game");
		((Node) (event.getSource())).getScene().getWindow().hide();
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		Menu.backgroundMusic.stop();

		GameLogic logic = new GameLogic();
		GameScreen gameScreen = new GameScreen(1400, 800);
		root.getChildren().add(gameScreen);
		gameScreen.requestFocus();

		app_stage.show();

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

	@FXML
	public Button settingButton;

	@FXML
	private void SettingClick(ActionEvent event) throws IOException {
		
		
		
		MainGame.RenderableHolder.clickSound.play();
//		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("settingTask.fxml"));
		Parent root = loader.load();

		SettingController settingControl = loader.getController();
		Scene scene = new Scene(root);
		Stage app_stage = new Stage();
		app_stage.initStyle(StageStyle.UNDECORATED);
		app_stage.setScene(scene);
		app_stage.setResizable(false);
		app_stage.show();

	}

	@FXML
	public Button howtoplayButton;

	@FXML
	public void HowtoPlayClick(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("howToPlayPage1.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		((Node) (event.getSource())).getScene().getWindow().hide();
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();

	}

	@FXML
	public Button exitButton;

	@FXML
	public void ExitClick(ActionEvent event) {
		Platform.exit();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}