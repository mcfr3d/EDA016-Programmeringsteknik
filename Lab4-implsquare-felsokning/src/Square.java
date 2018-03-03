import se.lth.cs.pt.window.SimpleWindow;

public class Square {
	private Point location;
	private int side; // sidlängd
	
	/**
	 * Skapar en kvadrat med övre, vänstra hörnet i x,y och med sidlängden side.
	 */
	public Square(int x, int y, int side) {
		this.location = new Point(x, y);
		this.side = side;
	}
	
	/** Ritar kvadraten i fönstret w. */
	public void draw(SimpleWindow w) {
		int x = location.getX();
		int y = location.getY();
		w.moveTo(x, y);
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
		location.move(dx, dy);
	}
	
	/** Tar reda på x-koordinaten för kvadratens läge. */
	public int getX() {
		return location.getX();
	}
	
	/** Tar reda på y-koordinaten för kvadratens läge. */
	public int getY() {
		return location.getY();
	}
	
	/** Ändra kvadratens sida till side. */
	public void setSide(int side) {
		this.side = side;
	}
	
	/** Tar reda på kvadratens sida. */
	public int getSide() {
		return side;
	}
	
	/** Tar reda på kvadratens area. */
	public int getArea() {
		return side * side;
	}
	
	/** Returnerar true om denna kvadrat innesluter punkten (x,y). */
	public boolean contains(int x, int y) {
		int xpos = location.getX();
		int ypos = location.getY();
		if (x >= xpos && x <= (xpos + side) && y >= ypos && y <= (ypos + side)) {
			return true;
		} else {
			return false;
		}
	}
	
	/** Returnerar true om denna kvadrat innesluter punkten p. */
	public boolean contains(Point p) {
		if (contains(p.getX(), p.getY())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returnerar true om denna kvadrat innesluter alla punkter i kvadraten sq.
	 */
	public boolean contains(Square sq) {
		if (contains(sq.getX(), sq.getY())&&contains(sq.getX()+sq.getSide(), sq.getY()+sq.getSide())) {
				return true;
			}
	 else {
			return false;
		}
	}
}
/*
 * Point locationSide = new Point((xpos+side),(ypos+side)); if(sq.getSide()<=
 * sq.location.distanceTo(locationSide))
 */
/*
 * if (sq.getX() == xpos && sq.getY() == ypos && sq.getSide() <= side) { return
 * true; } else
 */
/*
 * if(sq.getSide()<= xpos-sq.getX() && sq.getSide()<=ypos-sq.getY()){ }
 */