package gamelogic;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import logic.Direction;

public class PlayerFish extends Entity implements Consumable {
	private int score = 0;
	private int size = 1;
	private int growth = 0;

	public PlayerFish() {
		super();
		width = 76;
		height = 52;
		direction = Direction.LEFT;
	}

	public void resetForNewLevel() {
		size = 1;
		growth = 0;
		width = 50;
		height = 50;
	}

	public void reset() {
		score = 0;
		resetForNewLevel();
	}

	@Override
	public void setPositon(int x, int y) {
		this.x = x - width / 2;
		this.y = y - height / 2;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
		if (this.growth >= 100) {
			width *= 2; 
			height *= 2;
			this.growth = 0;
			this.size++;
		}
	}

	public void update() {
//		if (growth > 100) {
//			setSize(2);
//		}
//		else if (growth > 200) {
//			setScore(3);
//		}
		System.out.println(score);

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (InputUtility.getKeyPressed(KeyCode.W) && 0 <= y) {
			y -= 5;
		} else if (InputUtility.getKeyPressed(KeyCode.S) && y <= 800-height) {
			y += 5;
		}
		if (InputUtility.getKeyPressed(KeyCode.A) && 0 <= x) {
			x -= 5;
			direction = Direction.LEFT;
		} else if (InputUtility.getKeyPressed(KeyCode.D) && x <= 1400-width) {
			x += 5;
			direction = Direction.RIGHT;
		}

	}

	@Override
	public boolean consume(Entity e) {
		// TODO Auto-generated method stub
		if (!e.isDestroied && e instanceof EnemyFish && x <= e.x+e.width && x+width>=e.x && y <= e.y+e.height && y+height >= e.y) {
			EnemyFish i = (EnemyFish) e;
			if (i.getSize() <= getSize()) {
				e.isMarkedForDestroying();
				setScore(score+i.getSize()*20);
				setGrowth(growth+i.getSize()*10/getSize());
				return true;
			}
		}
		if (!e.isDestroied && e instanceof Items && x <= e.x+e.width && x+width>=e.x && y <= e.y+e.height && y+height >= e.y) {
			Items i = (Items) e;
			if (i.getType() == 1) {
				e.isMarkedForDestroying();
				setSize(10);
				return true;
			}
		}
		return false;
	}
	

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.playerSprite.getPixelReader(), 1, 1, 125, 105);
//		if (direction == Direction.RIGHT) {
//			
//			gc.drawImage(croppedImage, x, y, width, height, x, 0,-width,height);
//		}
//		else {
//			gc.drawImage(croppedImage, x, y, width, height);
//		}
		gc.drawImage(croppedImage, x, y, width, height);
		
//		gc.setLineWidth(2.0);
//		gc.setFill(Color.GREEN);
//		gc.fillRoundRect(x, y, width, height, 10, 10);
	}

}
