package life;

import java.util.concurrent.TimeUnit;

public class LifeController {
	public static void main(String[] args) {
		LifeBoard board = new LifeBoard(30, 30);
		LifeView window = new LifeView(board);
		Life life= new Life(board);
		window.drawBoard();
	
		
		while (true) {	
			switch(window.getCommand()){
			case 1: life.flip(window.getRow(), window.getCol());window.update();; break;
			case 2: for(int i=0;i<1000;i++){life.newGeneration();window.update();try {
			    Thread.sleep(100);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}}; break;
			case 3: System.exit(0); break;
			
				
			}
		}
	}


	}
//board.put(8, 8, true);
//board.put(8, 9, true);
//board.put(8, 10, true);
//board.put(9, 8, true);
//board.put(9, 10, true);
//board.put(10, 8, !true);
//board.put(10, 9, !true);
//board.put(10, 10, !true);
//int ngbh = life.getNeighbrs(9, 9);
//System.out.println(ngbh);