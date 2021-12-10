package gamelogic;

import java.util.ArrayList;
import java.util.List;

import MainGame.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	
	private PlayerFish player;
	private EnemyFish enemyfish;
	
	public GameLogic(){
		this.gameObjectContainer = new ArrayList<Entity>();
	
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		player = new PlayerFish();
		enemyfish = new EnemyFish(1, 200 ,200);
		addNewObject(player);
		addNewObject(enemyfish);
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		enemyfish.move();
		player.move();
		
		
	}

}
