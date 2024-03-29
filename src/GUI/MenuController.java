package GUI;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import shareObject.IRenderable;
import shareObject.RenderableHolder;

public class MenuController extends VBox implements Initializable {

	@FXML
	private Button playgameButton;

	@FXML
	private void playgameClick(ActionEvent event) throws IOException {

		shareObject.RenderableHolder.clickSound.play();
//		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("levelMenu.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		((Node) (event.getSource())).getScene().getWindow().hide();
		app_stage.setScene(scene);
		app_stage.show();
	}

	@FXML
	private Button settingButton;

	@FXML
	public void settingClick(ActionEvent event) throws IOException {

		shareObject.RenderableHolder.clickSound.play();
//		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("settingTask.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		Stage app_stage = new Stage();
		app_stage.initStyle(StageStyle.UNDECORATED);
		app_stage.setScene(scene);
		app_stage.setResizable(false);
		app_stage.show();

	}

	@FXML
	private Button howtoplayButton;

	@FXML
	public void howtoPlayClick(ActionEvent event) throws IOException {

		shareObject.RenderableHolder.clickSound.play();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("howToPlayPage1.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		((Node) (event.getSource())).getScene().getWindow().hide();
		app_stage.setScene(scene);
		app_stage.show();

	}

	@FXML
	private Button exitButton;

	@FXML
	public void exitClick(ActionEvent event) {
		Platform.exit();
		System.exit(0);

	}

	@FXML
	private Button creditButton;

	@FXML
	public void creditClick(ActionEvent event) throws IOException {
		
		shareObject.RenderableHolder.clickSound.play();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("creditPage.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		((Node) (event.getSource())).getScene().getWindow().hide();
		app_stage.setScene(scene);
		app_stage.show();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}