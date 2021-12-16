package GUI;

import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import drawing.GameScreen;
import gamelogic.GameLogic;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import shareObject.RenderableHolder;

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
	GameLogic logic = new GameLogic();
	AnimationTimer animation;
	GameScreen gameScreen = new GameScreen(1400, 800);

//	public void getSelectedLevel() {
//		if (level1CheckBox.isSelected()) {
//			logic.setLevel(1);
//		}
//		else if (level2CheckBox.isSelected()) {
//			logic.setLevel(2);
//		}
//		else if (level3CheckBox.isSelected()){
//			logic.setLevel(3);
//		}
//		logic.setLevel(1);
//	}

	@FXML
	public void level1Check(ActionEvent event) {
		if (level1CheckBox.isSelected()) {

			shareObject.RenderableHolder.clickSound.play();

			level1Pic.setImage(levelCheck);
			logic.setLevel(1);

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
			shareObject.RenderableHolder.clickSound.play();
			level1Pic.setImage(levelUnlocked);
		}

	}

	@FXML
	public void level2Check(ActionEvent event) {
		if (level2CheckBox.isSelected()) {
			shareObject.RenderableHolder.clickSound.play();

			level2CheckBox.setSelected(true);
			level2Pic.setImage(levelCheck);
			logic.setLevel(2);

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

			shareObject.RenderableHolder.clickSound.play();
			level2Pic.setImage(levelUnlocked);
		}
	}

	@FXML
	public void level3Check(ActionEvent event) {

		if (level3CheckBox.isSelected()) {

			shareObject.RenderableHolder.clickSound.play();

			level3CheckBox.setSelected(true);
			level3Pic.setImage(levelCheck);
			logic.setLevel(3);

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
			shareObject.RenderableHolder.clickSound.play();
			level3Pic.setImage(levelUnlocked);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if (Main.getCurrentLevel() == 1) {
			level1Pic.setImage(levelUnlocked);
			level2Pic.setImage(levelLocked);
			level3Pic.setImage(levelLocked);
			level1CheckBox.setDisable(false);
			level2CheckBox.setDisable(true);
			level3CheckBox.setDisable(true);
			level1CheckBox.setSelected(false);
		}

		else if (Main.getCurrentLevel() == 2) {
			level1Pic.setImage(levelUnlocked);
			level2Pic.setImage(levelUnlocked);
			level3Pic.setImage(levelLocked);
			level1CheckBox.setDisable(false);
			level2CheckBox.setDisable(false);
			level3CheckBox.setDisable(true);
			level1CheckBox.setSelected(false);
			level2CheckBox.setSelected(false);
		}

		else if (Main.getCurrentLevel() == 3) {
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
		shareObject.RenderableHolder.clickSound.play();
		if (level1CheckBox.isSelected() || level2CheckBox.isSelected() || level3CheckBox.isSelected()) {

			shareObject.RenderableHolder.clickSound.play();

			StackPane root = new StackPane();
			Scene scene = new Scene(root);
			((Node) (event.getSource())).getScene().getWindow().hide();
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(scene);
//		Menu.backgroundMusic.stop();
			app_stage.setTitle("Mobiew's Ocean");
			logic.settingLevel();
			retrybtn = new Button("Retry");
			retrybtn.setOpacity(0);
			retrybtn.setCursor(Cursor.HAND);
			retrybtn.setPrefWidth(100);
			retrybtn.setPrefHeight(100);
			retrybtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {

					retrybtn.setVisible(false);
					logic.reset();
					logic.getRc().stop();
					animation.stop();
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

//				Thread.currentThread().interrupt();
//				logic.getT().interrupt();
//				logic.getT().suspend();

				}
			});
			retrybtn.setVisible(false);
			root.getChildren().add(gameScreen);
			root.getChildren().add(retrybtn);
			gameScreen.requestFocus();
			app_stage.show();

			animation = new AnimationTimer() {
				public void handle(long now) {
					gameScreen.paintComponent();
					logic.logicUpdate();
					RenderableHolder.getInstance().update();

				}
			};
			animation.start();
		}
	}

	public static Button getRetrybtn() {
		return retrybtn;
	}

}
