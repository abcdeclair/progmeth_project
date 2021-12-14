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
	private int level;
	GamePanel gamePanel;
	EndRound endingSene;
	Thread t;


	RunningClass rc;

	public GameLogic() {
		MainGame.RenderableHolder.getInstance().getEntities().clear();
		//level = 1;
		this.gameObjectContainer = new ArrayList<Entity>();
		gameObjectContainer.clear();
		player = new PlayerFish();
		player.setPositon(60, 250);
		addNewObject(player);
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		gamePanel = new GamePanel();
		RenderableHolder.getInstance().add(gamePanel);
		endingSene = new EndRound();
		RenderableHolder.getInstance().add(endingSene);
		
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
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
//				rc = new RunningClass(e, player, this);
//				t = new Thread(rc);
////				Thread.yield();
//				t.start();
				e.move();
				if (player.consume(e)) {
					Random random = new Random();
					if (e instanceof EnemyFish) {
						EnemyFish i = (EnemyFish) e;
						EnemyFish enemyfish = new EnemyFish(i.getSize(), 1600, random.nextInt(530) + 170);
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
						setLose(true);
					}
				}
			}
		}
//		if (isLose) {
//			endingSene.show("Lose");
//			MainGame.InGame.getRetrybtn().setVisible(true);
//			
//		}
//		if (isWin) {
//			endingSene.show("Win");
//			MainGame.InGame.getRetrybtn().setVisible(true);
//			if(level == 1 && MainGame.InGame.getCurrentLevel()==1) {
//				MainGame.InGame.setCurrentLevel(2);
//			}
//			if(level == 2 && MainGame.InGame.getCurrentLevel()==2) {
//				MainGame.InGame.setCurrentLevel(3);
//			}
//		}
//		
		if (isLose) {
			endingSene.show("Lose");
			GUI.LevelMenuController.getRetrybtn().setVisible(true);
			
		}
		if (isWin) {
			endingSene.show("Win");
			GUI.LevelMenuController.getRetrybtn().setVisible(true);
			if(level == 1 && GUI.Menu.getCurrentLevel()==1) {
				GUI.Menu.setCurrentLevel(2);
			}
			if(level == 2 && GUI.Menu.getCurrentLevel()==2) {
				GUI.Menu.setCurrentLevel(3);
			}
		}

	}
	
	
	
	public void setLose(boolean isLose) {
		this.isLose = isLose;
	}

	public Thread getT() {
		return t;
	}
	
	public RunningClass getRc() {
		return rc;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void settingLevel() {
		if (level == 1) {
			level1();
		}
		else if (level == 2) {
			level2();
		}
		else if (level == 3) {
			level3();
		}
		else {
			System.out.println("error select level");
		}
	}
	

	public void level1() {

		Random random = new Random();
		isLose = false;
		isWin = false;
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
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 4; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 2; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		
	}
	
	
	public void level2() {

		Random random = new Random();
		isLose = false;
		isWin = false;
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
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 5; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 3; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		
	}
	
	public void level3() {

		Random random = new Random();
		isLose = false;
		isWin = false;
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
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 6; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 4; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		
	}
}
