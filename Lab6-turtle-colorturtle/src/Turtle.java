import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	protected boolean draw;
	protected double x;
	protected double y;
	protected SimpleWindow w;
	protected double angle = 90;

	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.x = x;
		this.y = y;
		this.w = w;

	}

	/** Sänker pennan. */
	public void penDown() {
		draw = true;
		w.moveTo((int)Math.round(x),(int)Math.round(y));
	}
		


	/** Lyfter pennan. */
	public void penUp() {
		draw = false;

	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo((int)Math.round(x),(int)Math.round(y));
		double a = Math.toRadians(angle);
		x += n * Math.cos(a);
		y -= n * Math.sin(a);
			
		if(draw){
			w.lineTo((int) Math.round(x),(int) Math.round(y));
		}
		w.moveTo((int)Math.round(x),(int)Math.round(y));

	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		angle += beta;
	}

	

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		w.moveTo(newX, newY);
		x = w.getX();
		y = w.getY();
	
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		angle = 90;

	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int)Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int)Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return (int)Math.round(angle);
	}
}