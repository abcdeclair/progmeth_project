package GUI;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class MenuController extends VBox{
	
	@FXML
	public Button playgameButton;

	@FXML
	private void PlaygameClick() {
		
		System.out.println("Hello");

	}

	@FXML
	public Button settingButton;

	@FXML
	private void SettingClick() {

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

}