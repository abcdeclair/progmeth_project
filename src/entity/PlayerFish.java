package entity;
import entity.base.Entity;
import logic.Direction;

public class PlayerFish extends Entity{
	private int score = 0;
    private int size = 1;
    private int frenzy = 0;
    private int growth = 0;
    private int lives = 3;
    
    public PlayerFish() {
        super();
        width = height = 50;
        direction = Direction.LEFT;
    }
    
    public void resetForNewLevel() {
        size = 1;
        frenzy = 0;
        growth = 0;
        lives = 3;
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

    public int getFrenzy() {
        return frenzy;
    }

    public void setFrenzy( int frenzy) {
        if (this.frenzy == 100 && frenzy != 0) {
            return;
        }
        this.frenzy = frenzy; 
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

    public int getLives() {
        return lives;
    }

    public synchronized void setLives( int lives) {
        this.lives = lives;
    }
    
    @Override
    public void move() {
    }

    @Override
    public void updateState( GameManager gameManager, GameMapManager gameMapManager, PlayerFish playerFish) {
    }

}
