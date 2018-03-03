package draw;
import se.lth.cs.pt.shapes.Shape;
import se.lth.cs.pt.window.SimpleWindow;

public class Circle extends Shape {
	private int radius; // cirkelns radie
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public void draw(SimpleWindow w) {
		final int CORNERS = 90;
		w.moveTo(x + radius, y);
		double conv = 2 * Math.PI / CORNERS;
		for (int k = 1; k <= CORNERS; k++) {
			w.lineTo((int) Math.round(x + radius * Math.cos(k * conv)), 
					 (int) Math.round(y + radius * Math.sin(k * conv)));
		}
	}
	
	public boolean near(int xc, int yc) {
		double dist = Math.abs(Math.hypot(xc - x, yc -y) - radius);
		return dist < 10;
	}
}
