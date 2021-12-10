package gamelogic;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import logic.Direction;

public class EnemyFish extends Fish {
	
	private int size;
	
	public EnemyFish(int size) {
		this.size = size;
		direction = Direction.LEFT;
	}
	
	public EnemyFish(int size, int x, int y) {
        this(size);
        this.x = x;
        this.y = y;
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

        if (x > 1400) {
            x = -width;
        }
        if (x + width < 0) {
            x = 1400;
        } else {
            if (y > 800 || y + height < 0) {
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
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(MainGame.RenderableHolder.enemyFishSprite, x, y);
	}

}
