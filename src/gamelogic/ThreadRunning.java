package gamelogic;

import java.util.Random;

import direction.Direction;
import entity.EnemyFish;
import entity.PlayerFish;
import entity.base.Entity;

public class ThreadRunning implements Runnable{
	private Entity e;
	private	PlayerFish player;
	GameLogic logic;
	private volatile boolean exit = false;
	
	   public void stop() {
	      exit = true;
	      System.out.println("Stop");
	   }

	public ThreadRunning(Entity e, PlayerFish player, GameLogic logic) {
		// TODO Auto-generated constructor stub
		this.e = e;
		this.player = player;
		this.logic = logic;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (!exit) {
			e.move();
			if (player.consume(e)) {
				Random random = new Random();
				if (e instanceof EnemyFish) {
					EnemyFish i = (EnemyFish) e;
					EnemyFish enemyfish = new EnemyFish(i.getSize(), 1600, random.nextInt(530) + 170);
					if (random.nextBoolean()) {
						enemyfish.setDirection(Direction.LEFT);
					} else {
						enemyfish.setDirection(Direction.RIGHT);
					}
					logic.addNewObject(enemyfish);
				}
			}
			if (e instanceof EnemyFish) {
				EnemyFish i = (EnemyFish) e;
				if (i.consume(player)) {
					logic.setLose(true);
				}
			}
		}
	}
	

}
