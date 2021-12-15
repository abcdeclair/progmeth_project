package entity.base;


public abstract class Fish extends Entity {
	private int animetionPosX = 1;
	private int animetiontimer = 0;
	
    public Fish() {
    	super();
    	animetionPosX = 1;
    	animetiontimer = 0;
    	
    }
    
    public int getAnimetionPosX() {
		return animetionPosX;
	}

	public void setAnimetionPosX(int animetionPosX) {
		this.animetionPosX = animetionPosX;
	}

	public int getAnimetiontimer() {
		return animetiontimer;
	}

	public void setAnimetiontimer(int animetiontimer) {
		this.animetiontimer = animetiontimer;
	}
}
