package gamelogic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import shareObject.IRenderable;

public class EndRound implements IRenderable{

	private boolean show;
	private boolean isDestroyed = false;
	String endingText ;
	
	public EndRound() {
		show = false;
		endingText = "";
	}
	
	public void unshow() {
		show = false;
		
	}
	
	public void show(String status) {
		show = true;
		endingText = status;
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font("Times New Roman", FontWeight.BOLD, 60));
		gc.fillText(endingText, 640, 300);
		gc.drawImage(shareObject.RenderableHolder.homeButton, 650, 350);
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;
	}

	public void setDestroyed() {
		this.isDestroyed = true;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return show;
	}
	
}
