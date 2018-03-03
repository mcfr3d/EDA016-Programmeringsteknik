public class RaceTurtleTest {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		AbsentMindedTurtle r = new AbsentMindedTurtle(w, 2, 100);
		
		while(r.getX() < RaceWindow.X_END_POS) {
			r.raceStep();
			RaceWindow.delay(10);
		}
		
		System.out.println("I mål!");
		System.out.println(""+ r);
	}
}