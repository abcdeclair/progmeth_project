package gamelogic;

import javafx.scene.canvas.GraphicsContext;
import shareObject.*;

public class Field implements IRenderable {
	private boolean isDestroyed;
	
	public void setDestroyed() {
		this.isDestroyed = true;
	}

	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(shareObject.RenderableHolder.mapSprite, 0, 0, 1400, 800);
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}

