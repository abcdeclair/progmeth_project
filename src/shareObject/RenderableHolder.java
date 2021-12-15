package shareObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import shareObject.RenderableHolder;
import entity.EnemyFish;
import entity.Items;
import entity.PlayerFish;
import entity.base.Entity;
import gamelogic.EndRound;
import gamelogic.Field;
import gamelogic.GamePanel;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image mapSprite;
	public static Image enemyFish1Sprite;
	public static Image enemyFish2Sprite;
	public static Image enemyFish3Sprite;
	public static Image itemsSprite;
	public static Image playerSprite;
	public static Image homeButton;
	public static AudioClip  eatingSound;
	public static AudioClip  clickSound;
	public static AudioClip  winSound;
	public static AudioClip  loseSound;
	public static AudioClip  growUpSound;

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
		mapSprite = new Image(ClassLoader.getSystemResource("bgInGame.png").toString());
		enemyFish1Sprite = new Image(ClassLoader.getSystemResource("enemyfish1.png").toString());
		enemyFish2Sprite = new Image(ClassLoader.getSystemResource("enemyfish2.png").toString());
		enemyFish3Sprite = new Image(ClassLoader.getSystemResource("enemyfish3.png").toString());
		playerSprite = new Image(ClassLoader.getSystemResource("player.png").toString());
		itemsSprite = new Image(ClassLoader.getSystemResource("items1.png").toString());
		homeButton = new Image(ClassLoader.getSystemResource("homeButton.png").toString());
		eatingSound = new AudioClip(ClassLoader.getSystemResource("SoundEating.wav").toString());
		eatingSound.setVolume(0.3);
		clickSound = new AudioClip(ClassLoader.getSystemResource("clickSound.wav").toString());
		clickSound.setVolume(0.15);
		winSound = new AudioClip(ClassLoader.getSystemResource("winSound.m4a").toString());
		winSound.setVolume(0.3);
		loseSound = new AudioClip(ClassLoader.getSystemResource("loseSound.m4a").toString());
		loseSound.setVolume(0.3);
		growUpSound= new AudioClip(ClassLoader.getSystemResource("growUp.m4a").toString());
		growUpSound.setVolume(0.3);
	}

	public void add(IRenderable entity) {
//		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
//		for(IRenderable x: entities){
//			if(x instanceof PlayerFish) System.out.println("fish");
//			if(x instanceof EnemyFish) System.out.println("enemyfish");
//			if(x instanceof Field) System.out.println("field");
//			if(x instanceof GamePanel) System.out.println("panel");
//			if(x instanceof EndRound) System.out.println("endround");
//			if(x instanceof Items) System.out.println("item");
			
//		}
	}
	
	public void reset() {
		for(IRenderable x: entities){
			if (x instanceof Entity) {
				((Entity) x).isMarkedForDestroying();
			}
			if (x instanceof EndRound) {
				((EndRound) x).setDestroyed();
			}
			if (x instanceof GamePanel) {
				((GamePanel) x).setDestroyed();
			}
			if (x instanceof Field) {
				((Field) x).setDestroyed();
			}
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