package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import MainGame.RenderableHolder;
import drawing.GameScreen;
import gamelogic.GameLogic;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LevelMenuController extends StackPane implements Initializable {

	@FXML
	private ImageView level1Pic;

	@FXML
	private ImageView level2Pic;

	@FXML
	private ImageView level3Pic;

	@FXML
	private CheckBox level1CheckBox;

	@FXML
	private CheckBox level2CheckBox;

	@FXML
	private CheckBox level3CheckBox;

	Image levelLocked = new Image("file:res/levelLocked.png");
	Image levelUnlocked = new Image("file:res/levelUnlocked.png");
	Image levelCheck = new Image("file:res/levelcheck.png");
	private static Button retrybtn;

	private int getSelectedLevel() {
		if (level1CheckBox.isSelected()) {
			return 1;
		}
		else if (level2CheckBox.isSelected()) {
			return 2;
		}
		else if (level3CheckBox.isSelected()){
			return 3;
		}
		return 0;
	}

	@FXML
	private void level1Check(ActionEvent event) {
		if (level1CheckBox.isSelected()) {

			level1Pic.setImage(levelCheck);

			if (!level2CheckBox.isDisable()) {
				level2CheckBox.setSelected(false);
				level2Pic.setImage(levelUnlocked);
			}

			if (!level3CheckBox.isDisable()) {
				level3CheckBox.setSelected(false);
				level3Pic.setImage(levelUnlocked);
			}
		}

		else {
			level1Pic.setImage(levelUnlocked);
		}

	}

	@FXML
	private void level2Check(ActionEvent event) {
		if (level2CheckBox.isSelected()) {

			level2CheckBox.setSelected(true);
			level2Pic.setImage(levelCheck);

			if (!level1CheckBox.isDisable()) {
				level1CheckBox.setSelected(false);
				level1Pic.setImage(levelUnlocked);
			}

			if (!level3CheckBox.isDisable()) {
				level3CheckBox.setSelected(false);
				level3Pic.setImage(levelUnlocked);
			}
		}

		else {
			level2Pic.setImage(levelUnlocked);
		}
	}

	@FXML
	private void level3Check(ActionEvent event) {

		if (level3CheckBox.isSelected()) {

			level3CheckBox.setSelected(true);
			level3Pic.setImage(levelCheck);

			if (!level1CheckBox.isDisable()) {
				level1CheckBox.setSelected(false);
				level1Pic.setImage(levelUnlocked);
			}

			if (!level2CheckBox.isDisable()) {
				level2CheckBox.setSelected(false);
				level2Pic.setImage(levelUnlocked);
			}
		}

		else {
			level3Pic.setImage(levelUnlocked);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		if (Menu.getCurrentLevel() == 1) {
			level1Pic.setImage(levelUnlocked);
			level2Pic.setImage(levelLocked);
			level3Pic.setImage(levelLocked);
			level1CheckBox.setDisable(false);
			level2CheckBox.setDisable(true);
			level3CheckBox.setDisable(true);
			level1CheckBox.setSelected(false);
		}

		else if (Menu.getCurrentLevel() == 2) {
			level1Pic.setImage(levelUnlocked);
			level2Pic.setImage(levelUnlocked);
			level3Pic.setImage(levelLocked);
			level1CheckBox.setDisable(false);
			level2CheckBox.setDisable(false);
			level3CheckBox.setDisable(true);
			level1CheckBox.setSelected(false);
			level2CheckBox.setSelected(false);
		}

		else if (Menu.getCurrentLevel() == 3) {
			level1Pic.setImage(levelUnlocked);
			level2Pic.setImage(levelUnlocked);
			level3Pic.setImage(levelUnlocked);
			level1CheckBox.setDisable(false);
			level2CheckBox.setDisable(false);
			level3CheckBox.setDisable(false);
			level1CheckBox.setSelected(false);
			level2CheckBox.setSelected(false);
			level3CheckBox.setSelected(false);
		}
	}

	public void playGameClick(ActionEvent event) {
//		MainGame.RenderableHolder.clickSound.play();
////		clickSound.setVolume(0.15);
//
//		StackPane root = new StackPane();
//		Scene scene = new Scene(root);
//
//		
//
//		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		app_stage.setScene(scene);
//		Menu.backgroundMusic.stop();
//		app_stage.setTitle("Mobiew's Ocean");
//
//		GameLogic logic = new GameLogic();
//		GameScreen gameScreen = new GameScreen(1400, 800);
//		retrybtn = new Button("Retry");
//		retrybtn.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//
//				logic.newGame(); /// eclair help!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//				retrybtn.setVisible(false);
//			}
//		});
//		retrybtn.setVisible(false);
//		root.getChildren().add(gameScreen);
//		root.getChildren().add(retrybtn);
//		gameScreen.requestFocus();
//
//		app_stage.show();
//		((Node) (event.getSource())).getScene().getWindow().hide();
//
//		AnimationTimer animation = new AnimationTimer() {
//			public void handle(long now) {
//				gameScreen.paintComponent();
//				logic.logicUpdate();
//				RenderableHolder.getInstance().update();
//				InputUtility.updateInputState();
//			}
//		};
//		animation.start();
//
//		app_stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//			@Override
//			public void handle(WindowEvent e) {
//				try {
//					stop();
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				System.exit(0);
//			}
//		});

	}

//	public void stop() throws Exception {
//		this.stop(); // To change body of generated methods, choose Tools | Templates.
//		System.exit(0);
//		Platform.exit();
//	}

}
