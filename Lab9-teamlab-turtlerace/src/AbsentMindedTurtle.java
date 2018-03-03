import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {
	private int absentDegree;
	private Random rand = RaceTurtle.getRandom();
	
	public AbsentMindedTurtle(RaceWindow w, int nbr, int absentDegree) {
		super(w, nbr);
		this.absentDegree = absentDegree;
	}
	
	public void raceStep() {
		int absentRoll = rand.nextInt(100) + 1;
		if (absentDegree < absentRoll || absentDegree == 0) {
			super.raceStep();
		}
	}
	
	public String toString() {
		return super.toString() + "- AbsentMindedTurtle " + "(" + absentDegree + " % Frånvarande)";
	}
}
// int counter = 0;
// public int getTimes() {
// return counter;
// }
//
// public static void main(String[] args) {
// Random rand = RaceTurtle.getRandom();
// int times = 100000;
// RaceWindow w = new RaceWindow();
// AbsentMindedTurtle turt = new AbsentMindedTurtle(w, 1, 99);
//
// for (int i = 0; i < times; i++) {
// turt.raceStep();
// }
// int time = turt.getTimes();
// System.out.println("antal gånger den gick fram" + time + "av"+ times);
// }
// }
