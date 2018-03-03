import java.util.ArrayList;

public class TurtleRace {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> raceList = new ArrayList<RaceTurtle>();
		for (int i = 1; i <=8; i++) {
			raceList.add(new RaceTurtle(w, i));
		}
		ArrayList<RaceTurtle> finishPos = new ArrayList<RaceTurtle>();
		while (!raceList.isEmpty()) {
			
			for (int i = 0; i < raceList.size(); i++) {
				if(raceList.get(i).getX()>= RaceWindow.X_END_POS){
				finishPos.add(raceList.get(i));
				raceList.remove(i);
				}
			}
			
			for (int i = 0; i < raceList.size(); i++) {
				raceList.get(i).raceStep();
			}
			RaceWindow.delay(10);
		}

		System.out.println("I mål!");
		for(int i = 0; i<3; i ++){
			System.out.println("På plats "+(i+1)+":"+ finishPos.get(i));
			
		}
		
	}
}