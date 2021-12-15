package entity.base;

import java.awt.Rectangle;

import direction.Direction;
import shareObject.IRenderable;

public abstract class Entity implements IRenderable{
	protected int x;
	protected int y;
	protected int z;
	protected int width;
	protected int height;
	protected Direction direction;
	protected boolean isDestroied;
	private boolean isVisible;

	public Entity() {
		isDestroied = false;
		isVisible = true;
		z = 0;
	}

	public void setZ(int z) {
		this.z = z;
	}


	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setDirection(Direction changeDirection) {
		direction = changeDirection;
	}
	
	public abstract void move();
	

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

    public Direction getDirection() {
		return direction;
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
    


    
    public boolean isMarkedForDestroying() {
    	isVisible = false;
    	isDestroied = true;
        return isDestroied;
    }

    public void setMarkedForDestroying( boolean isMarkedForDestroying) {
        this.isDestroied = isMarkedForDestroying;
        this.isVisible = !isMarkedForDestroying;
    }

    @Override
	public boolean isDestroyed(){
		return isDestroied;
	}
	
	@Override
	public boolean isVisible(){
		return isVisible;
	}
	
	@Override
	public int getZ(){
		return z;
	}

}
