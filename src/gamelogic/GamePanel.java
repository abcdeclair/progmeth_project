package gamelogic;


import MainGame.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GamePanel implements IRenderable{
	
	private int prog;
	private int score;
	
	public GamePanel() {
		prog = 0;
		score = 0;
	}
	public void update(int score, int growth, int size) {
		if (size == 1) {
			prog = 0;
		}
		else if (size == 2) {
			prog = 100;
		}
		else if (size == 3) {
			prog = 200;
		}
		prog += growth;
		this.score = score;
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 2;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setLineWidth(2.0);
		gc.setFill(Color.GREEN);
		gc.fillRoundRect(50, 50, prog, 10, 10, 10);
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font("Times New Roman", FontWeight.LIGHT,20));
		gc.fillText(String.valueOf(score), 50, 30);
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
	public void reset() {
		// TODO Auto-generated method stub
		prog = 0;
		score = 0;
	}
	
	
}
