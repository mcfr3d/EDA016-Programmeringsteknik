package draw;
import se.lth.cs.pt.shapes.Shape;
import se.lth.cs.pt.window.SimpleWindow;

import java.util.Scanner;
import java.util.ArrayList;

public class ShapeList {
	private ArrayList<Shape> shapes;
	
	/** Skapar en tom lista */
	public ShapeList() {
		shapes = new ArrayList<Shape>();
	}
	
	public void read(Scanner scan) {
		while (scan.hasNext()) {
			String type = scan.next();
			int x = scan.nextInt();
			int y = scan.nextInt();
			int size = scan.nextInt();
			if (type.equals("S")) {
				shapes.add(new Square(x, y, size));
			} else if (type.equals("T")) {
				shapes.add(new Triangle(x, y, size));
			} else if (type.equals("C")) {
				shapes.add(new Circle(x, y, size));
			}
		}
	}
	
	/** Lägger in figuren s i listan */
	public void insert(Shape s) {
		shapes.add(s);
	}
	
	/** Ritar upp figurerna i listan i fönstret w */
	public void draw(SimpleWindow w) {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(w);
		}
	}
	
	/** Tar reda på en figur som ligger nära punkten xc,yc (null om ingen
		sådan figur finns i listan */
	public Shape findHit(int xc, int yc) {
		int i = 0;
		while (i < shapes.size() && ! shapes.get(i).near(xc, yc)) {
			i++;
		}
		return i < shapes.size() ? shapes.get(i) : null;
	}
}
