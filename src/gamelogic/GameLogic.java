package gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import MainGame.InGame;
import MainGame.RenderableHolder;
import logic.Direction;

public class GameLogic {
	private List<Entity> gameObjectContainer;

	private PlayerFish player;
	private EnemyFish enemyfish;
	private Items item;
	private boolean isLose;
	private boolean isWin;
	private GamePanel gamePanel;
	private EndRound endingSene;

	public GameLogic() {
		this.gameObjectContainer = new ArrayList<Entity>();

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
		item = new Items(1, random.nextInt(1400));
		for (int i = 0; i < 50; i++) {
			enemyfish = new EnemyFish(random.nextInt(3), random.nextInt(1400), random.nextInt(800));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		addNewObject(item);
		addNewObject(player);
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
		for (int in = gameObjectContainer.size() - 1; in >= 0; in--) {
			Entity e = gameObjectContainer.get(in);
			if (e.isDestroied) {
				gameObjectContainer.remove(e);
			} else {
				Thread t = new Thread() {
					public void run() {
						e.move();
						if (player.consume(e)) {
							EnemyFish i = (EnemyFish) e;
							i.beEated(player);
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
			InGame.getRetrybtn().setVisible(true);
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
//		endingSene.unshow();
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
		item = new Items(1, random.nextInt(1400));
		for (int i = 0; i < 50; i++) {
			enemyfish = new EnemyFish(random.nextInt(3), random.nextInt(1400), random.nextInt(800));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			} else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		addNewObject(item);
		addNewObject(player);
	}

}
