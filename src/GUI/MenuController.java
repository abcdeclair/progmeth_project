package GUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuController extends VBox implements Initializable {

	@FXML
	public Button playgameButton;

	@FXML
	private void PlaygameClick(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("settingTask.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();

	}

	@FXML
	public Button settingButton;

	@FXML
	private void SettingClick(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("settingTask.fxml"));
		Parent root = loader.load();

		SettingController settingControl = loader.getController();
		Scene scene = new Scene(root);
		Stage app_stage = new Stage();
		app_stage.setScene(scene);
		app_stage.setResizable(false);
		app_stage.show();

	}

	@FXML
	public Button creditButton;

	@FXML
	public void CreditClick() {

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