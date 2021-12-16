package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HowToPlayPage1Controller extends StackPane {

	@FXML
	private Button nextPageButton;

	@FXML
	public void nextPageClick(ActionEvent event) throws IOException {

		shareObject.RenderableHolder.clickSound.play();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("howToPlayPage2.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		((Node) (event.getSource())).getScene().getWindow().hide();
		app_stage.setScene(scene);
		app_stage.show();

	}

	@FXML
	private Button homeButton;

	@FXML
	public void homeClick(ActionEvent event) throws IOException {

		shareObject.RenderableHolder.clickSound.play();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuButton.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		((Node) (event.getSource())).getScene().getWindow().hide();
		app_stage.setScene(scene);
		app_stage.show();

	}

}
