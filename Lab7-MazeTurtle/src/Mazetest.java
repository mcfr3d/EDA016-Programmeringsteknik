import java.util.Scanner;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class Mazetest {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "turtlewalker");
		Turtle turt = new Turtle(w, 300, 300);
		Scanner scan = new Scanner(System.in);
/*		System.out.println("skriv in Maze nummer");
		int number = scan.nextInt();*/
		Maze maze = new Maze(2);
		maze.draw(w);
		MazeWalker walker = new MazeWalker(turt);
		walker.walk(maze);
	}
}
