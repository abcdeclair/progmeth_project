package gamelogic;


import java.util.ArrayList;
import java.util.List;

import MainGame.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GamePanel implements IRenderable{
	
	private int prog;
	private int score;
	private List<Items> status;
	
	public GamePanel() {
		prog = 0;
		score = 0;
		status = new ArrayList<Items>();
	}
	public void update(int score, int growth, int size, List<Items> status) {
		if (size == 1) {
			prog = 0;
			prog += growth;
		}
		else if (size == 2) {
			prog = 100;
			prog += growth;
		}
		else if (size == 3) {
			prog = 200;
			prog += growth;
		}
		else {
			prog = 300;
		}
		this.score = score;
		this.status = status;
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 2;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setLineWidth(2.0);
		gc.setFill(Color.GREEN);
		gc.fillRoundRect(42, 107, prog*1.3, 10, 10, 10);
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font("Times New Roman", FontWeight.LIGHT,50));
		gc.fillText(String.valueOf(score), 1100, 65);
		for (Items i : status) {
			if (i.type == 1) {
				WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.itemsSprite.getPixelReader(),
						i.posX, i.posY, 40, 40);
				gc.drawImage(croppedImage, 1170, 90, i.width, i.height);
			}
			else if (i.type == 2) {
				WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.itemsSprite.getPixelReader(),
						i.posX, i.posY, 40, 40);
				gc.drawImage(croppedImage, 1100, 90, i.width, i.height);
			}
			else if (i.type == 4) {
				WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.itemsSprite.getPixelReader(),
						i.posX, i.posY, 40, 40);
				gc.drawImage(croppedImage, 1240, 90, i.width, i.height);
			}
		}
		
	}
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	public void reset() {
		// TODO Auto-generated method stub
		prog = 0;
		score = 0;
	}
	
	
}
