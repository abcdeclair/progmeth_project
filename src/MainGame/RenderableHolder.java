package MainGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import MainGame.RenderableHolder;
import gamelogic.EnemyFish;
import gamelogic.PlayerFish;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image mapSprite;
	public static Image enemyFish1Sprite;
	public static Image enemyFish2Sprite;
	public static Image enemyFish3Sprite;
	public static Image itemsSprite;
	public static Image itemsSprite2;
	public static Image playerSprite;
	public static AudioClip  eatingSound;
	public static AudioClip  clickSound;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		mapSprite = new Image(ClassLoader.getSystemResource("bg.png").toString());
		enemyFish1Sprite = new Image(ClassLoader.getSystemResource("enemyfish1.png").toString());
		enemyFish2Sprite = new Image(ClassLoader.getSystemResource("enemyfish2.png").toString());
		enemyFish3Sprite = new Image(ClassLoader.getSystemResource("enemyfish3.png").toString());
		playerSprite = new Image(ClassLoader.getSystemResource("player.png").toString());
		itemsSprite = new Image(ClassLoader.getSystemResource("items1.png").toString());
		itemsSprite2 = new Image(ClassLoader.getSystemResource("item2.png").toString());
		eatingSound = new AudioClip(ClassLoader.getSystemResource("SoundEating.wav").toString());
		eatingSound.setVolume(0.3);
		clickSound = new AudioClip(ClassLoader.getSystemResource("clicksound.mp3").toString());
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
		for(IRenderable x: entities){
			if(x instanceof PlayerFish) System.out.println("fish");
			if(x instanceof EnemyFish) System.out.println("enemyfish");
			//if(x instanceof Field) System.out.println("field");
			
		}
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}