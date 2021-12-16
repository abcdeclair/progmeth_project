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
		
		shareObject.RenderableHolder.clickSound.play();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	private void soundCheckClick() {
		if (soundCheckBox.isSelected()) {
			if (!Main.soundPlayed) {
				shareObject.RenderableHolder.eatingSound.setVolume(0.3);
				shareObject.RenderableHolder.clickSound.setVolume(0.15);
				shareObject.RenderableHolder.winSound.setVolume(0.3);
				shareObject.RenderableHolder.loseSound.setVolume(0.3);
				shareObject.RenderableHolder.growUpSound.setVolume(0.3);
				checkSound.setVisible(true);
			}
			Main.soundPlayed = true;
		

			System.out.println("play");
		} else {
			shareObject.RenderableHolder.eatingSound.setVolume(0);
			shareObject.RenderableHolder.clickSound.setVolume(0);
			shareObject.RenderableHolder.winSound.setVolume(0);
			shareObject.RenderableHolder.loseSound.setVolume(0);
			shareObject.RenderableHolder.growUpSound.setVolume(0);
			Main.soundPlayed = false;
			System.out.println("stop");
			checkSound.setVisible(false);
		}

	}

	@FXML
	private void musicCheckClick(ActionEvent event) {

		if (musicCheckBox.isSelected()) {
			if (!Main.musicPlayed) {
				
				shareObject.RenderableHolder.clickSound.play();
				Main.backgroundMusic.play();
				checkMusic.setVisible(true);
			}
			Main.musicPlayed = true;
		

			System.out.println("play");
		} else {
			
			shareObject.RenderableHolder.clickSound.play();
			Main.backgroundMusic.stop();
			Main.musicPlayed = false;
			System.out.println("stop");
			checkMusic.setVisible(false);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		checkMusic.setVisible(Main.musicPlayed);
		musicCheckBox.setSelected(Main.musicPlayed);
		
		checkSound.setVisible(Main.soundPlayed);
		soundCheckBox.setSelected(Main.soundPlayed);
		
	}

}
