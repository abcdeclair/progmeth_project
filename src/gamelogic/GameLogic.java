package gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import direction.Direction;
import entity.EnemyFish;
import entity.Items;
import entity.PlayerFish;
import entity.base.Entity;
import shareObject.RenderableHolder;

public class GameLogic {
	private static List<Entity> gameObjectContainer = new ArrayList<Entity>();

	private PlayerFish player;
	private boolean isLose;
	private boolean isWin;
	private int level;
	GamePanel gamePanel;
	EndRound endingSene;
	Thread t;
	ThreadRunning rc;
	Timer timer = new Timer();
	
	

	public GameLogic() {
//		MainGame.RenderableHolder.getInstance().getEntities().clear();
		//level = 1;
//		this.gameObjectContainer = new ArrayList<Entity>();
		initialize();
		player.setPositon(60, 250);
		addNewObject(player);
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		gamePanel = new GamePanel();
		RenderableHolder.getInstance().add(gamePanel);
		endingSene = new EndRound();
		RenderableHolder.getInstance().add(endingSene);
		
	}
	
	public void initialize() {
        isLose = false;
        isWin = false;
        shareObject.RenderableHolder.getInstance().reset();
        shareObject.RenderableHolder.getInstance().update();
        gameObjectContainer.clear();
        
        if (player == null) {
            player = new PlayerFish();
        } else {
            player.reset();
        }
    }
	
	public void reset() {
		isLose = false;
        isWin = false;
        timer.cancel();
        shareObject.RenderableHolder.getInstance().reset();
        shareObject.RenderableHolder.getInstance().update();
        gameObjectContainer.clear();
        
        if (player == null) {
            player = new PlayerFish();
        } else {
            player.reset();
        }
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	

	public void logicUpdate() {
		player.update(gamePanel);
		if (!isWin && player.getSize() == 4) {
			isWin = true;
			shareObject.RenderableHolder.winSound.play();
		}
		for (int idx = gameObjectContainer.size() - 1; idx >= 0; idx--) {
			Entity e = gameObjectContainer.get(idx);
			if (e.isDestroyed()) {
				gameObjectContainer.remove(e);
			} else {
				rc = new ThreadRunning(e, player, this);
				t = new Thread(rc);
//				Thread.yield();
				t.start();
//				e.move();
//				if (player.consume(e)) {
//					Random random = new Random();
//					if (e instanceof EnemyFish) {
//						EnemyFish i = (EnemyFish) e;
//						EnemyFish enemyfish = new EnemyFish(i.getSize(), 1600, random.nextInt(530) + 170);
//						if (random.nextBoolean()) {
//							enemyfish.setDirection(Direction.LEFT);
//						} else {
//							enemyfish.setDirection(Direction.RIGHT);
//						}
//						addNewObject(enemyfish);
//					}
//				}
//				if (e instanceof EnemyFish) {
//					EnemyFish i = (EnemyFish) e;
//					if (i.consume(player)) {
//						setLose(true);
//					}
//				}
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
			if(level == 1 && GUI.Main.getCurrentLevel()==1) {
				GUI.Main.setCurrentLevel(2);
			}
			if(level == 2 && GUI.Main.getCurrentLevel()==2) {
				GUI.Main.setCurrentLevel(3);
			}
		}

	}
	
	
	
	public void setLose(boolean isLose) {
		this.isLose = isLose;
		shareObject.RenderableHolder.loseSound.play();
	}

	public Thread getT() {
		return t;
	}
	
	public ThreadRunning getRc() {
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
		timer.schedule(new TimerTask() {
			public void run() {
				int n = random.nextInt(6);
				if (n>5 || n<=0) {
					n = 5;
				}
				Items item = new Items(n, random.nextInt(1400));
				addNewObject(item);
			}
		}, 8000, 8000);
		
		for (int i = 0; i < 10; i++) {
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 4; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 2; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		
	}
	
	
	public void level2() {

		Random random = new Random();
		isLose = false;
		isWin = false;
		player.setSpeed(3);
		timer.schedule(new TimerTask() {
			public void run() {
				int n = random.nextInt(6);
				if (n>5 || n<=0) {
					n = 5;
				}
				Items item = new Items(n, random.nextInt(1400));
				addNewObject(item);
			}
		}, 8000, 8000);
		for (int i = 0; i < 8; i++) {
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 5; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 3; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		
	}
	
	public void level3() {

		Random random = new Random();
		isLose = false;
		isWin = false;
		player.setSpeed(4);
		timer.schedule(new TimerTask() {
			public void run() {
				int n = random.nextInt(6);
				if (n>5 || n<=0) {
					n = 5;
				}
				Items item = new Items(n, random.nextInt(1400));
				addNewObject(item);
			}
		}, 8000, 8000);
		for (int i = 0; i < 8; i++) {
			EnemyFish enemyfish = new EnemyFish(1, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 6; i++) {
			EnemyFish enemyfish = new EnemyFish(2, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		for (int i = 0; i < 4; i++) {
			EnemyFish enemyfish = new EnemyFish(3, random.nextInt(1400), random.nextInt(530)+170);
			if (random.nextBoolean()) {
				enemyfish.setDirection(Direction.LEFT);
			} else {
				enemyfish.setDirection(Direction.RIGHT);
			}
			addNewObject(enemyfish);
		}
		
	}
}
