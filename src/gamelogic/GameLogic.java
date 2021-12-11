package gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import MainGame.RenderableHolder;
import logic.Direction;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	
	private PlayerFish player;
	private EnemyFish enemyfish;
	private Items item;
	
	public GameLogic(){
		this.gameObjectContainer = new ArrayList<Entity>();
		
		Random random = new Random();
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		player = new PlayerFish();
		item = new Items(1,random.nextInt(1400));
		for (int i=0 ; i<20; i++) {
			enemyfish = new EnemyFish(random.nextInt(3), random.nextInt(1400) ,random.nextInt(800));
			if (random.nextBoolean()) {
				enemyfish.direction = Direction.LEFT;
			}
			else {
				enemyfish.direction = Direction.RIGHT;
			}
			addNewObject(enemyfish);
		}
		addNewObject(item);
		addNewObject(player);
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		
		player.update();
		for (Entity e : gameObjectContainer) {
			e.move();
			if(player.consume(e)){
				EnemyFish i = (EnemyFish)e;
				i.beEated(player);
			}
		}
		
	}

}
