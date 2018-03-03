package life;

public class Life {
	LifeBoard board;

	/** Skapar ett Life-spel med spelplanen board **/
	public Life(LifeBoard board) {
		this.board = board;

	}

	public boolean isEmpty() {
		boolean empty=true;
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				if(board.get(i, j)){
					empty=false;
				}
			}

		}
		return empty;
	}

	/** Skapar en ny generation **/
	public void newGeneration() {
		int boardRows = board.getRows();
		int boardCols = board.getCols();
		boolean newBoard[][] = new boolean[boardRows][boardCols];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				if (board.get(i, j)) {
					if (getNeighbrs(i, j) == 2 || getNeighbrs(i, j) == 3) {
						newBoard[i][j] = board.get(i, j);
					}
					if (getNeighbrs(i, j) >= 4) {
						newBoard[i][j] = !board.get(i, j);
					}
					if (getNeighbrs(i, j) == 0 || getNeighbrs(i, j) == 1) {
						newBoard[i][j] = !board.get(i, j);
					}
				}
				if (!board.get(i, j)) {
					if (getNeighbrs(i, j) == 3) {
						newBoard[i][j] = !board.get(i, j);
					}

				}
			}

		}
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				board.put(i, j, newBoard[i][j]);
			}
		}
		board.increaseGeneration();

	}

	/**
	 * Ändrar innehållet i rutan med index row, col från individ till tom eller
	 * tvärtom
	 **/
	public void flip(int row, int col) {
		boolean value = board.get(row, col);
		board.put(row, col, !value);

	}

	/** Kollar antalet grannar till en ruta **/
	private int getNeighbrs(int row, int col) {
		int nbrNeighbrs = 0;
		board.get(row, col);
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i == row && j == col) {
					j++;
				}
				if (board.get(i, j)) {
					nbrNeighbrs++;

				}

			}
		}
		return nbrNeighbrs;

	}
}