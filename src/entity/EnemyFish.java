package entity;

import java.util.Random;

import entity.base.GameManager;
import entity.base.GameMapManager;
import entity.base.PlayerFish;
import logic.Direction;

public class EnemyFish extends Fish {
	
	private int size;
	
	public EnemyFish(int size) {
		this.size = size;
		direction = Direction.LEFT;
	}
	
	public EnemyFish(int size, Point position) {
        this(size);
        this.x = position.x;
        this.y = position.y;
    }

	@Override
	public void move() {
		// TODO Auto-generated method stub
		Random random = new Random();
        if (direction == Direction.LEFT) {
            x -= random.nextInt(1) + 1;
        } else if (direction == Direction.RIGHT) {
            x += random.nextInt(1) + 1;
        }

        if (random.nextInt(5) == 0) {
            if (random.nextBoolean()) {
                y++;
            } else {
                y--;
            }
        }

        if (x > GamePanel.RESOLUTION.width) {
            x = -width;
        }
        if (x + width < 0) {
            x = GamePanel.RESOLUTION.width;
        } else {
            if (y > GamePanel.RESOLUTION.height || y + height < 0) {
                setMarkedForDestroying(true);
            }
        }
        
        
	}
	
	public int getSize() {
        return size;
    }

    public void setSize( int size) {
        this.size = size;
    }

	@Override
	public void updateState(GameManager gameManager, GameMapManager gameMapManager, PlayerFish playerFish) {
		// TODO Auto-generated method stub
		if (size < playerFish.getSize() || playerFish.getFrenzy() == 100) {
            playerFish.setGrowth(playerFish.getGrowth() + (size + 1) * 5);
            playerFish.setFrenzy(playerFish.getFrenzy() + (size + 1) * 2);
            playerFish.setScore(playerFish.getScore() + (size + 1) * 5);
            setMarkedForDestroying(true);
        } else {
            playerFish.setLives(playerFish.getLives() - 1);
            playerFish.setFrenzy(0);
        }
	}
}
