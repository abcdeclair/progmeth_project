package entity.base;

public abstract class Fish extends Entity {
	private int animationPosX;
	private int animationtimer;

	public Fish() {
		super();
		animationPosX = 1;
		animationtimer = 0;

	}

	public int getAnimetionPosX() {
		return animationPosX;
	}

	public void setAnimationPosX(int animationPosX) {
		this.animationPosX = animationPosX;
	}

	public int getAnimationtimer() {
		return animationtimer;
	}

	public void setAnimationtimer(int animationtimer) {
		this.animationtimer = animationtimer;
	}
}
