package GUI;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
