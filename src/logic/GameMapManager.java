package logic;

import java.util.ArrayList;
import java.util.List;

import entity.EnemyFish;
import entity.base.Entity;
public class GameMapManager {
	private int level = 0;
    private int initialNumberOfFish = 4;

    public GameMapManager() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel( int level) {
        this.level = level;
    }

    public int getNumberOfFish() {
        return initialNumberOfFish;
    }

    public void setNumberOfFish( int numberOfFish) {
        this.initialNumberOfFish = numberOfFish;
    }

    public List<Entity> getMapObjects() {
        level++;
        initialNumberOfFish += 2;

        List<Entity> initialGameObjects = new ArrayList<>();
        int spaceBetweenFish = GamePanel.RESOLUTION.height / (initialNumberOfFish + 1);

        switch (level) {
        case 1:
            for (int i = 0; i < initialNumberOfFish; i++) {
                boolean onLeft = i % 2 == 0;
                EnemyFish enemyFish = new EnemyFish(0);
                if (onLeft) {
                    enemyFish.setPositon(-enemyFish.getWidth(), (i + 1) * spaceBetweenFish);
                    enemyFish.setDirection(Direction.RIGHT);
                } else {
                    enemyFish.setPositon(GamePanel.RESOLUTION.width + enemyFish.getWidth(), i * spaceBetweenFish + 10);
                    enemyFish.setDirection(Direction.LEFT);
                }
                initialGameObjects.add(enemyFish);
            }
            return initialGameObjects;
        case 2:
            for (int i = 0; i < initialNumberOfFish; i++) {
                boolean onLeft = i % 2 == 0;
                EnemyFish enemyFish = new EnemyFish(0);
                if (onLeft) {
                    enemyFish.setPositon(-enemyFish.getWidth(), (i + 1) * spaceBetweenFish);
                    enemyFish.setDirection(Direction.RIGHT);
                } else {
                    enemyFish.setPositon(GamePanel.RESOLUTION.width + enemyFish.getWidth(), i * spaceBetweenFish + 10);
                    enemyFish.setDirection(Direction.LEFT);
                }
                initialGameObjects.add(enemyFish);
            }
            return initialGameObjects;
        case 3:
            for (int i = 0; i < initialNumberOfFish; i++) {
                boolean onLeft = i % 2 == 0;
                EnemyFish enemyFish = new EnemyFish(0);
                if (onLeft) {
                    enemyFish.setPositon(-enemyFish.getWidth(), (i + 1) * spaceBetweenFish);
                    enemyFish.setDirection(Direction.RIGHT);
                } else {
                    enemyFish.setPositon(GamePanel.RESOLUTION.width + enemyFish.getWidth(), i * spaceBetweenFish + 10);
                    enemyFish.setDirection(Direction.LEFT);
                }
                initialGameObjects.add(enemyFish);
            }
            return initialGameObjects;
        default:
            return null;
        }

    }

}