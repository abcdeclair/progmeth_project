package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SettingController extends StackPane implements Initializable {

	@FXML
	public Button backToMainButton;

	@FXML
	public CheckBox musicCheckBox;

	@FXML
	public CheckBox soundCheckBox;
	
	@FXML
	private ImageView checkMusic;
	
	@FXML
	private ImageView checkSound;
	

	@FXML
	private void backToMainMenu(ActionEvent event) {
		
		MainGame.RenderableHolder.clickSound.play();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	private void soundCheckClick() {
		if (soundCheckBox.isSelected()) {
			if (!Menu.soundPlayed) {
				MainGame.RenderableHolder.eatingSound.setVolume(0.3);
				MainGame.RenderableHolder.clickSound.setVolume(0.15);
				checkSound.setVisible(true);
			}
			Menu.soundPlayed = true;
		

			System.out.println("play");
		} else {
			MainGame.RenderableHolder.eatingSound.setVolume(0);
			MainGame.RenderableHolder.clickSound.setVolume(0);
			Menu.soundPlayed = false;
			System.out.println("stop");
			checkSound.setVisible(false);
		}

	}

	@FXML
	private void musicCheckClick(ActionEvent event) {

		if (musicCheckBox.isSelected()) {
			if (!Menu.musicPlayed) {
				
				MainGame.RenderableHolder.clickSound.play();
				Menu.backgroundMusic.play();
				checkMusic.setVisible(true);
			}
			Menu.musicPlayed = true;
		

			System.out.println("play");
		} else {
			
			MainGame.RenderableHolder.clickSound.play();
			Menu.backgroundMusic.stop();
			Menu.musicPlayed = false;
			System.out.println("stop");
			checkMusic.setVisible(false);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		checkMusic.setVisible(Menu.musicPlayed);
		musicCheckBox.setSelected(Menu.musicPlayed);
		
		checkSound.setVisible(Menu.soundPlayed);
		soundCheckBox.setSelected(Menu.soundPlayed);
		
	}

}
