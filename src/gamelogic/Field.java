package gamelogic;

import javafx.scene.canvas.GraphicsContext;
import MainGame.*;

public class Field implements IRenderable {

	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(MainGame.RenderableHolder.mapSprite, 0, 0, 1400, 800);
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}

