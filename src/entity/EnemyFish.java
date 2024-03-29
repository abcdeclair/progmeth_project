package entity;

import java.util.Random;

import direction.Direction;
import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Fish;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;

public class EnemyFish extends Fish implements Consumable {

	public EnemyFish(int size) {
		this.setSize(size);
		if (size == 1) {
			width = 60;
			height = 45;
		} else if (size == 2) {
			width = 125;
			height = 105;

		} else if (size == 3) {
			width = 250;
			height = 90;
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
			if (getSize() == 1) {
				if (getAnimationtimer() == 10) {
					setAnimationPosX((getAnimetionPosX() + 66) % 990);
					setAnimationtimer(0);
				}
				setAnimationtimer(getAnimationtimer() + 1);
			} else if (getSize() == 2) {
				if (getAnimationtimer() == 10) {
					setAnimationPosX((getAnimetionPosX() + 201) % 3015);
					setAnimationtimer(0);
				}
				setAnimationtimer(getAnimationtimer() + 1);

			} else if (getSize() == 3) {
				if (getAnimationtimer() == 10) {
					setAnimationPosX((getAnimetionPosX() + 271) % 3794);
					setAnimationtimer(0);
				}
				setAnimationtimer(getAnimationtimer() + 1);
			}

		} else if (direction == Direction.RIGHT) {
			x += random.nextInt(1) + 1;
			if (getSize() == 1) {
				if (getAnimationtimer() == 10) {
					setAnimationPosX((getAnimetionPosX() + 66) % 990);
					setAnimationtimer(0);
				}
				setAnimationtimer(getAnimationtimer() + 1);
			} else if (getSize() == 2) {
				if (getAnimationtimer() == 10) {
					setAnimationPosX((getAnimetionPosX() + 201) % 3015);
					setAnimationtimer(0);
				}
				setAnimationtimer(getAnimationtimer() + 1);

			} else if (getSize() == 3) {
				if (getAnimationtimer() == 10) {
					setAnimationPosX((getAnimetionPosX() + 271) % 3794);
					setAnimationtimer(0);
				}
				setAnimationtimer(getAnimationtimer() + 1);
			}
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
			if (y > 800 || y + height < 170) {
				setMarkedForDestroying(true);
			}
		}

	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if (getSize() == 1) {
			WritableImage croppedImage = new WritableImage(
					shareObject.RenderableHolder.enemyFish1Sprite.getPixelReader(), getAnimetionPosX(), 1, 65, 45);
			if (direction == Direction.RIGHT) {

				gc.drawImage(croppedImage, 0, 0, croppedImage.getWidth(), croppedImage.getHeight(), x + width, y,
						-getWidth(), getHeight());
			} else {
				gc.drawImage(croppedImage, x, y, width, height);
			}
		} else if (getSize() == 2) {
			WritableImage croppedImage = new WritableImage(
					shareObject.RenderableHolder.enemyFish2Sprite.getPixelReader(), getAnimetionPosX(), 363, 200, 180);
			if (direction == Direction.RIGHT) {

				gc.drawImage(croppedImage, 0, 0, croppedImage.getWidth(), croppedImage.getHeight(), x + width, y,
						-getWidth(), getHeight());
			} else {
				gc.drawImage(croppedImage, x, y, width, height);
			}
		} else if (getSize() == 3) {
			WritableImage croppedImage = new WritableImage(
					shareObject.RenderableHolder.enemyFish3Sprite.getPixelReader(), getAnimetionPosX(), 122, 270, 120);
			if (direction == Direction.RIGHT) {

				gc.drawImage(croppedImage, 0, 0, croppedImage.getWidth(), croppedImage.getHeight(), x + width, y,
						-getWidth(), getHeight());
			} else {
				gc.drawImage(croppedImage, x, y, width, height);
			}
		}

//		gc.setLineWidth(2.0);
//		gc.setFill(Color.GREEN);
//		gc.fillRoundRect(getX(), getY(), getWidth(), getHeight(), 10,10);
	}

	@Override
	public boolean consume(Entity e) {
		// TODO Auto-generated method stub
		if (!e.isDestroyed() && e instanceof PlayerFish && x <= e.getX() + e.getWidth() && x + width >= e.getX()
				&& y <= e.getY() + e.getHeight() && y + height >= e.getY()) {
			PlayerFish i = (PlayerFish) e;
			if (i.getSize() < getSize() && !i.checkStatusType2() && !i.checkStatusType1()) {
				e.isMarkedForDestroying();
				// MainGame.RenderableHolder.eatingSound.play();
				return true;
			}
		}
		return false;
	}

}
