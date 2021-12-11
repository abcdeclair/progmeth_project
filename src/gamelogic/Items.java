package gamelogic;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;

public class Items extends Entity{
	
	int type;
	int posX;
	int posY;
	
	public Items(int type, int x) {
		this.type = type;
		this.x = x;
		this.y = 800;
		this.width = 50;
		this.height = 50;
	}
	
	public int getType() {
		return type;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.itemsSprite.getPixelReader(),
				1, 116, 40, 40);
		gc.drawImage(croppedImage, x, y, width, height);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		Random random = new Random();
		y -= random.nextInt(1) + 1;
	}

}
