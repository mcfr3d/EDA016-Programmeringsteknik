import java.util.Random;

import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class TwoColorWalking {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "turtlewalker");
		Random rand = new Random();
		ColorTurtle turt1 = new ColorTurtle(w, 250, 250, Color.blue);
		ColorTurtle turt2 = new ColorTurtle(w, 350, 350, Color.red);
		int distX = turt1.getX() - turt2.getX();
		int distY = turt1.getY() - turt2.getY();
		int distance = (int) Math.round(Math.hypot(distX, distY));
		while (distance >= 50) {
			turt1.penDown();
			int stepLength = rand.nextInt(10) + 1;
			int turnDeegre = rand.nextInt(360 + 1) - 180;
			turt1.forward(stepLength);
			if (turt1.getX() > w.getWidth() || turt1.getX() < 0 || turt1.getY() < 0 || turt1.getY() > w.getHeight()) {
				turt1.left(180);
				turt1.forward(stepLength);
			} else {
				turt1.left(turnDeegre);
			}
			turt2.penDown();
			int stepLength2 = rand.nextInt(10) + 1;
			int turnDeegre2 = rand.nextInt(360 + 1) - 180;
			turt2.forward(stepLength2);
			if (turt2.getX() > w.getWidth() || turt2.getX() < 0 || turt2.getY() < 0 || turt2.getY() > w.getHeight()) {
				turt2.left(180);
				turt2.forward(stepLength2);
			} else {
				turt2.left(turnDeegre2);
			}
			distX = turt1.getX() - turt2.getX();
			distY = turt1.getY() - turt2.getY();
			distance = (int) Math.round(Math.hypot(distX, distY));
			w.delay(10);
		}
	}
}
/*
 * if(stepLength + turt1.getX()>w.getWidth() || stepLength +
 * turt1.getY()>w.getHeight())
 */
/*
 * while(turt1.getX()>w.getWidth()|| turt1.getY()>w.getHeight()){
 * 
 * turt1.penDown();
 * 
 * int stepLength2 = rand.nextInt(10) + 1;
 * 
 * int turnDeegre2 = rand.nextInt(360 + 1) - 180;
 * 
 * turt1.forward(stepLength2);
 * 
 * turt1.left(turnDeegre2);
 * 
 * }
 */
/*
 * while(turt2.getX()>w.getWidth()|| turt2.getY()>w.getHeight()){
 * 
 * turt2.penDown();
 * 
 * int stepLength2 = rand.nextInt(10) + 1;
 * 
 * int turnDeegre2 = rand.nextInt(360 + 1) - 180;
 * 
 * turt2.forward(stepLength2);
 * 
 * turt2.left(turnDeegre2);
 * 
 * }
 */