package gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import MainGame.InGame;
import MainGame.RenderableHolder;
import logic.Direction;

public class GameLogic {
	private List<Entity> gameObjectContainer;

	private PlayerFish player;
	private boolean isLose;
	private boolean isWin;
	GamePanel gamePanel;
	EndRound endingSene;

	public GameLogic() {
		this.gameObjectContainer = new ArrayList<Entity>();
		level3();
		Items item = new Items(1, 200);
		addNewObject(item);
		item = new Items(2, 100);
		addNewObject(item);
		item = new Items(3, 500);
		addNewObject(item);
		item = new Items(4, 600);
		addNewObject(item);
		item = new Items(5, 700);
		addNewObject(item);
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void killThead(Thread t) {
		
	}

	public void logicUpdate() {
		player.update(gamePanel);
		if (player.getSize() == 4) {
			isWin = true;
		}
		for (int idx = gameObjectContainer.size() - 1; idx >= 0; idx--) {
			Entity e = gameObjectContainer.get(idx);
			if (e.isDestroied) {
				gameObjectContainer.remove(e);
			} else {
				Thread t = new Thread() {
					public void run() {
						e.move();
						if (player.consume(e)) {
							Random random = new Random();
							if (e instanceof EnemyFish) {
								EnemyFish i = (EnemyFish) e;
								EnemyFish enemyfish = new EnemyFish(i.getSize(), 1600, random.nextInt(700));
								if (random.nextBoolean()) {
									enemyfish.direction = Direction.LEFT;
								} else {
									enemyfish.direction = Direction.RIGHT;
								}
								addNewObject(enemyfish);
							}
						}
						if (e instanceof EnemyFish) {
							EnemyFish i = (EnemyFish) e;
							if (i.consume(player)) {
								isLose = true;
							}
						}
					}
				};
				t.start();
			}
		}
		if (isLose) {
			endingSene.show("Lose");
			newGame();
			//InGame.getRetrybtn().setVisible(true);
		}
		if (isWin) {
			endingSene.show("Win");
		}

	}

	public void newGame() {
		gameObjectContainer.clear();
//		player.reset();
//		isLose = false;
//		isWin = false;
//		gamePanel.reset();
		endingSene.unshow();
		RenderableHolder.getInstance().getEntities().clear();
		gameObjectContainer = new ArrayList<Entity>();
		level1();
//		for (int in = gameObjectContainer.size() - 1; in >= 0; in--) {
//			Entity e = gameObjectContainer.get(in);
//			e.isMarkedForDestroying();
//		}
//		player.setMarkedForDestroying(false);
//		Random random = new Random();
//		Field field = new Field();
//		RenderableHolder.getInstance().add(field);
//		gamePanel = new GamePanel();
//		RenderableHolder.getInstance().add(gamePanel);
//		endingSene = new EndRound();
//		RenderableHolder.getInstance().add(endingSene);
//		isLose = false;
//		isWin = false;
//		Items item = new Items(1, random.nextInt(1400));
//		for (int i = 0; i < 50; i++) {
//			EnemyFish enemyfish = new EnemyFish(random.nextInt(3), random.nextInt(1400), random.nextInt(800));
//			if (random.nextBoolean()) {
//				enemyfish.direction = Direction.LEFT;
//			} else {
//				enemyfish.direction = Direction.RIGHT;
//			}
//			addNewObject(enemyfish);
//		}
//		addNewObject(item);
//		addNewObject(player);
	}

	public void level1() {
		this.gameObjectContainer.clear();
		RenderableHolder.getInstance().getEntities().clear();

		Random random = new Random();
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		gamePanel = new GamePanel();
		RenderableHolder.getInstance().add(gamePanel);
		endingSene = new EndRound();
		RenderableHolder.getInstance().add(endingSene);
		isLose = false;
		isWin = false;
		player = new PlayerFish();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				int n = random.nextInt(6);
				if (n>5 || n<=0) {
					n = 5;
				}
				Items item = new Items(n, random.nextInt(1400));
				addNewObject(item);
			}
		}, 15000, 15000);
		for (int i = 0; i < 10; i++) {
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(800));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 4; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(700));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 2; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(700));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		addNewObject(player);
	}
	
	
	public void level2() {
		this.gameObjectContainer.clear();
		RenderableHolder.getInstance().getEntities().clear();

		Random random = new Random();
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		gamePanel = new GamePanel();
		RenderableHolder.getInstance().add(gamePanel);
		endingSene = new EndRound();
		RenderableHolder.getInstance().add(endingSene);
		isLose = false;
		isWin = false;
		player = new PlayerFish();
		player.setSpeed(3);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				int n = random.nextInt(6);
				if (n>5 || n<=0) {
					n = 5;
				}
				Items item = new Items(n, random.nextInt(1400));
				addNewObject(item);
			}
		}, 15000, 15000);
		for (int i = 0; i < 8; i++) {
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(800));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 5; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(700));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 3; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(700));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		addNewObject(player);
	}
	
	public void level3() {
		this.gameObjectContainer.clear();
		RenderableHolder.getInstance().getEntities().clear();

		Random random = new Random();
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		gamePanel = new GamePanel();
		RenderableHolder.getInstance().add(gamePanel);
		endingSene = new EndRound();
		RenderableHolder.getInstance().add(endingSene);
		isLose = false;
		isWin = false;
		player = new PlayerFish();
		player.setSpeed(4);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				int n = random.nextInt(6);
				if (n>5 || n<=0) {
					n = 5;
				}
				Items item = new Items(n, random.nextInt(1400));
				addNewObject(item);
			}
		}, 15000, 15000);
		for (int i = 0; i < 8; i++) {
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(800));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 6; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(700));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 4; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(700));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		addNewObject(player);
	}
}
