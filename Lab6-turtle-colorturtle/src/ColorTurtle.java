import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class ColorTurtle extends Turtle {
	private Color color;
	
	public ColorTurtle(SimpleWindow w, int x, int y, Color color) {
		super(w, x, y);
		this.color = color;
	}
	
	public void forward(int n) {
		Color savedColor = w.getLineColor();
		w.setLineColor(color);
		super.forward(n);
		w.setLineColor(savedColor);
	}
}