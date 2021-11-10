package GUI;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class MenuController extends VBox{
	
	public MenuController() {
		Image imageview = new Image("woodclipart.png");
		setAlignment(Pos.CENTER);
		setPrefWidth(300);
		setSpacing(15);
		Canvas canvas = new Canvas(1400,800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		getChildren().addAll(canvas);
		gc.drawImage(imageview, 500, 250,400,500);
	}
	

}
