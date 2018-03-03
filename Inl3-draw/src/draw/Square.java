package draw;
import se.lth.cs.pt.shapes.Shape;
import se.lth.cs.pt.window.SimpleWindow;

public class Square extends Shape {
	private int side;

	public Square(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}

	public void draw(SimpleWindow w) {
		w.moveTo(x, y);
		w.lineTo(x + side, y);
		w.lineTo(x + side, y + side);
		w.lineTo(x, y + side);
		w.lineTo(x, y);
	}

	public boolean near(int xc, int yc) {
		return nearLine(xc, yc, x, x + side, y, y)
				|| nearLine(xc, yc, x, x + side, y + side, y + side)
				|| nearLine(xc, yc, x, x, y, y + side)
				|| nearLine(xc, yc, x + side, x + side, y, y + side);
	}

	private boolean nearLine(int xc, int yc, int x1, int x2, int y1, int y2) {
		double dist1 = Math.hypot(xc - x1, yc - y1);
		double dist2 = Math.hypot(xc - x2, yc - y2);
		return dist1 + dist2 - side < 10;
	}
}
