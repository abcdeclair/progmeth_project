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
	public Button nextPageButton;
	
	@FXML
	private void nextPageClick(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("howToPlayPage2.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		((Node) (event.getSource())).getScene().getWindow().hide();
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();
	}
	
	@FXML
	public Button homeButton;
	
	@FXML
	private void homeClick(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuButton.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		((Node) (event.getSource())).getScene().getWindow().hide();
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();
		
	}

}
