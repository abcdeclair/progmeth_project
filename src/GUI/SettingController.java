package GUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SettingController extends StackPane {

	@FXML
	public Button backToMainButton;

	@FXML
	public CheckBox musicCheckBox;

	@FXML
	public CheckBox soundCheckBox;

	@FXML
	private void backToMainMenu(ActionEvent event) {

		((Node)(event.getSource())).getScene().getWindow().hide();
	}

}
