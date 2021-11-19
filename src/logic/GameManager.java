package logic;

import java.util.ArrayList;
import java.util.List;

import entity.PlayerFish;

import entity.base.Entity;

public class GameManager {
	private boolean isGameRunning = false;
	private boolean isGamePaused = false;
	private boolean isGameOver = false;
	private boolean isGameWin = false;
	private GameMapManager gameMapManager;
	private List<Entity> gameObjects = new ArrayList<>();
	private PlayerFish playerFish;
	
	public GameManager() {
        gameMapManager = new GameMapManager();
    }
	
	public void initialize() {

        isGameRunning = true;
        isGamePaused = false;
        isGameOver = false;

        gameObjects.clear();
        gameObjects.addAll(gameMapManager.getMapObjects());

        playerFish = new PlayerFish();

    }
	
	public void startGame( boolean isNewGame) {
        if (isNewGame) {
            playerFish = new PlayerFish();
        }
        initialize();
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
	
	public boolean isGameWin() {
        return isGameWin;
    }
}
