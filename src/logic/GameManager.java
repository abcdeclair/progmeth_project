package logic;

import java.util.ArrayList;
import java.util.List;

import entity.PlayerFish;

import entity.base.Entity;

public class GameManager {
	private static final long REFRESH_INTERVAL_MS = 25;
	private long startTime;
	private boolean isGameRunning = false;
	private boolean isGamePaused = false;
	private boolean isGameOver = false;
	private boolean isInLevelTransition = false;
	private boolean readyForSpecialFish = false;
	private boolean shouldAddBubble = false;
	private GamePanel gamePanel;
	private GameMapManager gameMapManager;
	private Thread gameThread;
	private List<Entity> gameObjects = new ArrayList<>();
	private PlayerFish playerFish;
	
	public GameManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        gameMapManager = new GameMapManager();
    }
	
	public void initialize() {

        isGameRunning = true;
        isGamePaused = false;
        isGameOver = false;

        gameObjects.clear();
        gameObjects.addAll(gameMapManager.getMapObjects());

        if (playerFish == null) {
            playerFish = new PlayerFish();
        } else if (isInLevelTransition) {
            playerFish.resetForNewLevel();
            isInLevelTransition = false;
        } else {
            playerFish.reset();
        }

        this.gamePanel.setLevel(playerFish, gameObjects, gameMapManager.getLevel());
    }
	
	public void startGame( boolean isNewGame) {
        if (isNewGame) {
            playerFish = new PlayerFish();
            gameMapManager.setLevel(0);
        }
        initialize();
        if (gameThread != null && gameThread.isAlive()) {
            gameThread.interrupt();
        }
        gameThread = new Thread(new GameLoop());
        gameThread.start();
    }
	
	public void stopGame() {
        isGamePaused = false;
        isGameRunning = false;
    }
	
	public void pauseGame() {
        isGamePaused = true;
    }
	
	public void resumeGame() {
        isGamePaused = false;
    }
	
	public int getScore() {
        return playerFish.getScore();
    }
	
	public boolean isGameOver() {
        return isGameOver;
    }
	
	public boolean isGamePaused() {
        return isGamePaused;
    }
	
	public boolean isGameRunning() {
        return isGameRunning;
    }
}
