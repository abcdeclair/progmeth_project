package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import direction.Direction;
import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Fish;
import gamelogic.GamePanel;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class PlayerFish extends Fish implements Consumable {
	private int score = 0;
	private int growth = 0;
	private List<Items> status;
	private float speed = 2;
	private int bonus = 1;

	public PlayerFish() {
		super();
		status = new ArrayList<Items>();
		Items i = new Items(2, -20);
		status.add(i);
		width = 76;
		height = 52;
		direction = Direction.LEFT;
	}

	public void resetForNewLevel() {
		setSize(1);
		growth = 0;
		width = 76;
		height = 52;

	}

	public void reset() {
		score = 0;
		status.clear();
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

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		if (growth < 0)
			growth = 0;
		this.growth = growth;
		if (this.growth >= 100) {
			width *= 1.5;
			height *= 1.5;
			this.growth = 0;
			setSize(getSize() + 1);
			if (getSize() != 4) {
				shareObject.RenderableHolder.growUpSound.play();
			}

		}
	}

	public boolean checkStatusType1() {
		for (Items i : status) {
			if (i.getType() == 1) {
				return true;
			}
		}
		return false;
	}

	public void removeStatusType1(Items i) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				status.remove(i);
				speed /= 1.5;
			}
		}, 5000);
	}

	public void removeStatusType4(Items i) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				status.remove(i);
				bonus /= 2;
			}
		}, 5000);
	}

	public boolean checkStatusType2() {
		for (Items i : status) {
			if (i.getType() == 2) {
				if (checkStatusType1()) {
					return true;
				}
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					public void run() {
						status.remove(i);
					}
				}, 1500);
				return true;
			}
		}
		return false;
	}

	public boolean checkStatusType3() {
		for (Items i : status) {
			if (i.getType() == 3) {
				// status.remove(i);
				return true;
			}
		}
		return false;
	}

	public void update(GamePanel gamePanel) {
//		if (growth > 100) {
//			setSize(2);
//		}
//		else if (growth > 200) {
//			setScore(3);
//		}
		gamePanel.update(score, growth, getSize(), status);
//		for (Items i : status) {
//			System.out.println(i.type);
//		}

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (InputUtility.getKeyPressed(KeyCode.W) && 170 <= y) {
			y -= speed / 2;
		} else if (InputUtility.getKeyPressed(KeyCode.S) && y <= 800 - height) {
			y += speed / 2;
		}
		if (InputUtility.getKeyPressed(KeyCode.A) && 0 <= x) {
			x -= speed;
			if (getAnimationtimer() == 10) {
				setAnimationPosX((getAnimetionPosX() + 126) % 1890);
				setAnimationtimer(0);
			}
			setAnimationtimer(getAnimationtimer() + 1);
			direction = Direction.LEFT;
		} else if (InputUtility.getKeyPressed(KeyCode.D) && x <= 1400 - width) {
			x += speed;
			if (getAnimationtimer() == 10) {
				setAnimationPosX((getAnimetionPosX() + 126) % 1890);
				setAnimationtimer(0);
			}
			setAnimationtimer(getAnimationtimer() + 1);
			direction = Direction.RIGHT;
		}

	}

	@Override
	public boolean consume(Entity e) {
		// TODO Auto-generated method stub
		if (!isDestroyed && !e.isDestroyed() && e instanceof EnemyFish && x <= e.getX() + e.getWidth()
				&& x + width >= e.getX() && y <= e.getY() + e.getHeight() && y + height >= e.getY()) {
			EnemyFish i = (EnemyFish) e;
			if ((i.getSize() <= getSize() || checkStatusType1()) && getSize() < 4) {
//				e.isMarkedForDestroying();
				setScore(score + 20 * bonus);
				setGrowth(growth + 20 * bonus);
				shareObject.RenderableHolder.eatingSound.play();
				return true;
			}
		}
		if (!isDestroyed && !e.isDestroyed() && e instanceof Items && x <= e.getX() + e.getWidth()
				&& x + width >= e.getX() && y <= e.getY() + e.getHeight() && y + height >= e.getY() && getSize() < 4) {
			Items i = (Items) e;
			e.isMarkedForDestroying();
			if (i.type == 1) {
				status.add(i);
				speed *= 1.5;
				removeStatusType1(i);
			} else if (i.type == 3) {
				setGrowth(growth + 50);
			} else if (i.type == 4) {
				status.add(i);
				bonus *= 2;
				removeStatusType4(i);
			} else if (i.type == 5) {
				setGrowth(growth - 50);
			} else {
				status.add(i);
			}
			shareObject.RenderableHolder.eatingSound.play();
			return true;

		}
		return false;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		WritableImage croppedImage = new WritableImage(shareObject.RenderableHolder.playerSprite.getPixelReader(),
				getAnimetionPosX(), 214, 125, 104);
		if (direction == Direction.RIGHT) {

			gc.drawImage(croppedImage, 0, 0, croppedImage.getWidth(), croppedImage.getHeight(), x + width, y,
					-getWidth(), getHeight());
		} else {
			gc.drawImage(croppedImage, x, y, width, height);
		}
//		WritableImage croppedImage = new WritableImage(MainGame.RenderableHolder.playerSprite.getPixelReader(),
//				250, 414, 500, 500);
//		gc.drawImage(croppedImage, x, y, 300, 300);

//		gc.drawImage(croppedImage, x, y, width, height);

//		gc.setLineWidth(2.0);
//		gc.setFill(Color.GREEN);
//		gc.fillRoundRect(x, y, width, height, 10, 10);
	}

}
