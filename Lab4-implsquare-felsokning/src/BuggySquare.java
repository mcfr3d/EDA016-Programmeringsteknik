import se.lth.cs.pt.window.SimpleWindow;

public class BuggySquare {
	private int x;		// x- och y-koordinat för 
	private int y;		// övre vänstra hörnet
	private int side;	// sidlängd

	/** Skapar en kvadrat med övre vänstra hörnet i x,y  
	    och med sidlängden side. */
	public BuggySquare(int x, int y, int side) {
		this.x = x;
		y = y;
	}
	
	/** Ritar kvadraten i fönstret w. */
	public void draw(SimpleWindow w) {
		w.moveTo(x, y) ;
		w.lineTo(x, y + side);
		w.lineTo(x + side, y + side);
		w.lineTo(x + side, y);
		w.lineTo(x, y);
	}
	
	/** Raderar bilden av kvadraten i fönstret w. */
    public void erase(SimpleWindow w) {
		w.setLineColor(java.awt.Color.white);
		draw(w);
		w.setLineColor(java.awt.Color.black);
  	}		
    
    /** Flyttar kvadraten avståndet dx i x-led, dy i y-led. */
	public void move(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}

	/** Tar reda på x-koordinaten för kvadratens läge */
	public int getX() {
		return x;
	}
	
	/** Tar reda på y-koordinaten för kvadratens läge */
	public int getY() {
		return y;
	}
	
	/** Tar reda på kvadratens area */
	public int getArea() {
		return side * side;
	}
}
