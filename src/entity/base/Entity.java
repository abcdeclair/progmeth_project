package entity.base;

import java.awt.Rectangle;

import logic.Direction;

public abstract class Entity {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Direction direction;
	protected boolean isControlledByAi;
	protected boolean isDestroied;

	public Entity() {
		isControlledByAi = false;
		isDestroied = false;
	}

	public Rectangle getBoundingBox() {
		return new Rectangle(x, y, width, height);
	}

	public boolean intersects(Rectangle rectangle) {
		return getBoundingBox().intersects(rectangle);
	}

	public void setDirection(Direction changeDirection) {
		direction = changeDirection;
	}
	
	public abstract void move();
	
	public abstract void updateState( GameManager gameManager, GameMapManager gameMapManager, PlayerFish playerFish);

	public void setPositon( int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX( int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY( int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth( int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight( int height) {
        this.height = height;
    }
    
    public boolean isControlledByAi() {
        return isControlledByAi;
    }

    public void setControlledByAi( boolean isControlledByAi) {
        this.isControlledByAi = isControlledByAi;
    }
    
    public boolean isMarkedForDestroying() {
        return isDestroied;
    }

    public void setMarkedForDestroying( boolean isMarkedForDestroying) {
        this.isDestroied = isMarkedForDestroying;
    }


}
