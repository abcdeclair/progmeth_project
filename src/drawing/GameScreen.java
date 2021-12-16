package drawing;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import shareObject.IRenderable;
import shareObject.RenderableHolder;

public class GameScreen extends Canvas {

	public GameScreen(double width, double height) {
		super(width, height);
		this.setVisible(true);
		addListerner();
	}

	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});

	}

	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		try {
			for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
				// System.out.println(entity.getZ());
				if (entity.isVisible() && !entity.isDestroyed()) {
					entity.draw(gc);
				}
			}
		} catch (Exception e) {
//			System.out.println("");
		}

		// System.out.println("===============");
		// System.out.println("===============");

	}

}
