import se.lth.cs.pt.maze.Maze;

public class MazeWalker {
	private Turtle turtle;
	
	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}
	
	/**
	 * Låter sköldpaddan vandra genom labyrubteb maze, från ingånen till
	 * utgången.
	 */
	public void walk(Maze maze) {
		turtle.jumpTo(maze.getXEntry(), maze.getYEntry());
		turtle.turnNorth();
		turtle.penDown();
		int step = 10;
		turtle.forward(step);
		/*while (!maze.atExit(turtle.getX(), turtle.getY())) {
			int direction = turtle.getDirection();
			int xpos = turtle.getX();
			int ypos = turtle.getY();
			if (!maze.wallInFront(direction, xpos, ypos)) {
				turtle.forward(step);
			}
			if (!maze.wallAtLeft(direction, xpos, ypos)) {
				turtle.left(direction + 90);
				turtle.forward(step);
			}
			if (maze.wallAtLeft(direction, xpos, ypos) && maze.wallInFront(direction, xpos, ypos)) {
				turtle.left(direction + 270);
			}
			if (maze.wallAtLeft(direction, xpos, ypos) && !maze.wallInFront(direction, xpos, ypos)) {
				turtle.forward(step);
			} else {
				turtle.forward(step);
			}
		}
		System.out.println("Du är i mål");*/
	}
}
