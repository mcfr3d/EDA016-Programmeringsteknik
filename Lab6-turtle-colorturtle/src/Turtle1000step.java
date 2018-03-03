import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class Turtle1000step {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "turtlewalker");
		Random rand = new Random();
		Turtle turt = new Turtle(w, 300, 300);
		for (int i = 0; i < 1000; i++) {
			turt.penDown();
			int stepLength = rand.nextInt(10) + 1;
			int turnDeegre = rand.nextInt(360 + 1) - 180;
			turt.forward(stepLength);
			turt.left(turnDeegre);
			w.delay(10);
		}
	}
}