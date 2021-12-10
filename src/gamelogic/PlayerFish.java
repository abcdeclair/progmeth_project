package gamelogic;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.Direction;
public class PlayerFish extends Entity implements Consumable{
	private int score = 0;
    private int size = 1;
    private int growth = 0;
    
    public PlayerFish() {
        super();
        width = height = 50;
        direction = Direction.LEFT;
    }
    
    public void resetForNewLevel() {
        size = 1;
        growth = 0;
        width = height = 50;
    }

    public void reset() {
        score = 0;
        resetForNewLevel();
    }
    
    @Override
    public void setPositon( int x, int y) {
        this.x = x - width / 2;
        this.y = y - height / 2;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore( int score) {
        this.score = score;
    }

    public int getSize() {
        return size;
    }

    public void setSize( int size) {
        this.size = size;
    }
    
    public int getGrowth() {
        return growth;
    }

    public void setGrowth( int growth) {
        this.growth = growth;
        if (this.growth >= 100) {
            width = height = width + 10;
            this.growth = 0;
            this.size++;
        }
    }
    
   

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (InputUtility.getKeyPressed(KeyCode.W)) {
			y -= 5;
		}
		else if (InputUtility.getKeyPressed(KeyCode.S)) {
			y += 5;
		}
		else if (InputUtility.getKeyPressed(KeyCode.A)) {
			x -= 5;
		} else if (InputUtility.getKeyPressed(KeyCode.D)) {
			x += 5;
		}
		
	}

	@Override
	public boolean consume(Entity e) {
		// TODO Auto-generated method stub
		if (e instanceof EnemyFish) {
			EnemyFish i = (EnemyFish)e;
			if (i.getSize() < getSize()) {
				e.isMarkedForDestroying();
				return true;
			}
		}
		return false;
	}


	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(MainGame.RenderableHolder.enemyFishSprite, x, y);
	}



}
