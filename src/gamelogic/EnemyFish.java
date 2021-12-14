package gamelogic;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;

import logic.Direction;

public class EnemyFish extends Fish implements Consumable {

	private int size;

	public EnemyFish(int size) {
		this.size = size;
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
			if (size == 1) {
				if (getAnimetiontimer() == 10) {
					setAnimetionPosX((getAnimetionPosX() + 66) % 990);
					setAnimetiontimer(0);
				}
				setAnimetiontimer(getAnimetiontimer()+1);
			} else if (size == 2) {
				if (getAnimetiontimer() == 10) {
					setAnimetionPosX((getAnimetionPosX() + 201) % 3015);
					setAnimetiontimer(0);
				}
				setAnimetiontimer(getAnimetiontimer()+1);

			} else if (size == 3) {
				if (getAnimetiontimer() == 10) {
					setAnimetionPosX((getAnimetionPosX() + 271) % 3794);
					setAnimetiontimer(0);
				}
				setAnimetiontimer(getAnimetiontimer()+1);
			}

		} else if (direction == Direction.RIGHT) {
			x += random.nextInt(1) + 1;
			if (size == 1) {
				if (getAnimetiontimer() == 10) {
					setAnimetionPosX((getAnimetionPosX() + 66) % 990);
					setAnimetiontimer(0);
				}
				setAnimetiontimer(getAnimetiontimer()+1);
			} else if (size == 2) {
				if (getAnimetiontimer() == 10) {
					setAnimetionPosX((getAnimetionPosX() + 201) % 3015);
					setAnimetiontimer(0);
				}
				setAnimetiontimer(getAnimetiontimer()+1);

			} else if (size == 3) {
				if (getAnimetiontimer() == 10) {
					setAnimetionPosX((getAnimetionPosX() + 271) % 3794);
					setAnimetiontimer(0);
				}
				setAnimetiontimer(getAnimetiontimer()+1);
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

	public void beEated(PlayerFish player) {
		// player.hitByMine();
		MainGame.RenderableHolder.eatingSound.play();
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
					getAnimetionPosX(), 1, 65, 45);
			if (direction == Direction.RIGHT) {

				gc.drawImage(croppedImage, 0, 0, croppedImage.getWidth(), croppedImage.getHeight(), x + width, y,
						-getWidth(), getHeight());
			} else {
				gc.drawImage(croppedImage, x, y, width, height);
			}
		} else if (getSize() == 2) {
			WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.enemyFish2Sprite.getPixelReader(),
					getAnimetionPosX(), 363, 200, 180);
			if (direction == Direction.RIGHT) {

				gc.drawImage(croppedImage, 0, 0, croppedImage.getWidth(), croppedImage.getHeight(), x + width, y,
						-getWidth(), getHeight());
			} else {
				gc.drawImage(croppedImage, x, y, width, height);
			}
		} else if (getSize() == 3) {
			WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.enemyFish3Sprite.getPixelReader(),
					getAnimetionPosX(), 122, 270, 120);
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
		if (!e.isDestroied && e instanceof PlayerFish && x <= e.x + e.width && x + width >= e.x && y <= e.y + e.height
				&& y + height >= e.y) {
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
