import se.lth.cs.pt.window.SimpleWindow;

public class Test {

	public static void main(String[] args) {
		// * SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");*/
		Square sq = new Square(250, 250, 100);
		Point p2 = new Point(255, 240);
		Square sq2 = new Square(260,260,100);
		System.out.println(sq.contains(sq2));
	}

}
