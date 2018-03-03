package draw;
import se.lth.cs.pt.shapes.Shape;
import se.lth.cs.pt.window.SimpleWindow;

public class Triangle extends Shape {
	private int side;

	public Triangle(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}

	public void draw(SimpleWindow w) {
		w.moveTo(x, y);
		w.lineTo(x + side, y);
		w.lineTo(x + side / 2, (int) Math.round(y - Math.sin(Math.PI / 3)
				* side));
		w.lineTo(x, y);
	}

	public boolean near(int xc, int yc) {
		int xMid = x + side / 2;
		int yMid = (int) (y - Math.sin(Math.PI / 3) * side);
		return nearLine(xc, yc, x, x + side, y, y)
				|| nearLine(xc, yc, x, xMid, y, yMid)
				|| nearLine(xc, yc, x + side, xMid, y, yMid);

	}

	private boolean nearLine(int xc, int yc, int x1, int x2, int y1, int y2) {
		double dist1 = Math.hypot(xc - x1, yc - y1);
		double dist2 = Math.hypot(xc - x2, yc - y2);
		return dist1 + dist2 - side < 10;
	}
}
