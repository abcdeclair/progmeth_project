package gamelogic;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import logic.Direction;

public class EnemyFish extends Fish {

	private int size;

	public EnemyFish(int size) {
		this.size = size;
		if (size == 1) {
			width = 60;
			height = 45;
		}
		else if(size == 2) {
			width = 125;
			height = 105;
		}
		
		direction = Direction.LEFT;
	}

	public EnemyFish(int size, int x, int y) {
		this(size);
		this.x = x;
		this.y = y;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		Random random = new Random();
		if (direction == Direction.LEFT) {
			x -= random.nextInt(1) + 1;
		} else if (direction == Direction.RIGHT) {
			x += random.nextInt(1) + 1;
		}

		if (random.nextInt(5) == 0) {
			if (random.nextBoolean()) {
				y++;
			} else {
				y--;
			}
		}

		if (x > 1400) {
			x = -width;
		}
		if (x + width < 0) {
			x = 1400;
		} else {
			if (y > 800 || y + height < 0) {
				setMarkedForDestroying(true);
			}
		}

	}

	public void beEated(PlayerFish player) {
		// player.hitByMine();
		// RenderableHolder.explosionSound.play();
		this.isMarkedForDestroying();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if (getSize() == 1) {
			WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.enemyFish1Sprite.getPixelReader(),
					1, 1, 60, 45);
			gc.drawImage(croppedImage, x, y, width, height);
		}
		else if(getSize() == 2) {
			WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.enemyFish2Sprite.getPixelReader(),
					1, 1, 180, 170);
			gc.drawImage(croppedImage, x, y, width, height);
		}

//		gc.setLineWidth(2.0);
//		gc.setFill(Color.GREEN);
//		gc.fillRoundRect(getX(), getY(), getWidth(), getHeight(), 10,10);
	}

}
