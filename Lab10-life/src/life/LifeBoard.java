package life;

public class LifeBoard {
	private boolean[][] board;
	private int genCount;
	
	/**
	 * Skapar en spelplan med rows rader och cols kolonner. Spelplanen är från
	 * början tom, dvs alla rutorna är tomma och generationsräknaren är 1.
	 */
	public LifeBoard(int rows, int cols) {
		board = new boolean[rows][cols];
		genCount = 1;
	}
	
	/**
	 * Undersöker om det finns en individ i rutan med index row,col, Om index
	 * row,col hamnar utanför spelplanen returneras false.
	 */
	public boolean get(int row, int col) {
		if (row < 0 || col < 0) {
			return false;
		}
		if (row < getRows() && col < getCols()) {
			return board[row][col];
		} else
			return false;
	}
	
	/** Lagrar värdet val i rutan med index row,col. */
	public void put(int row, int col, boolean val) {
		board[row][col] = val;
	}
	
	/** Tar reda på antalet rader. */
	public int getRows() {
		return board.length;
	}
	
	/** Tar reda på antalet kolonner. */
	public int getCols() {
		return board[0].length;
	}
	
	/** Tar reda på aktuellt generationsnummer. */
	public int getGeneration() {
		return genCount;
	}
	

	
	/** Ökar generationsnumret med ett. */
	public void increaseGeneration() {
		genCount++;
	}
}
