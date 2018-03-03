package draw;
import se.lth.cs.pt.window.SimpleWindow;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ShapeTest {
	public static void main(String[] args) {
		final String dataFilename = "shapedata.txt";
		Scanner scan = null;
		try {
			scan = new Scanner(new File(dataFilename));
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open " + dataFilename +
					" for reading");
			System.exit(1);
		}
		ShapeList shapes = new ShapeList();
		shapes.read(scan);
		scan.close();
		SimpleWindow w = new SimpleWindow(600, 600, "ShapeTest");
		
		shapes.draw(w);
		
		CommandDispatcher disp = new CommandDispatcher(w, shapes);
		disp.mainLoop();
	}
}
