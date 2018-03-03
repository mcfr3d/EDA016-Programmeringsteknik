import se.lth.cs.pt.window.SimpleWindow;

public class DrawThreeSquares {
        public static void main(String[] args) {
                SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
                Square sq = new Square(250, 250, 100);
                //Square sq = new Square(300,300,200);/
                //Square sq = null;/
                sq.draw(w);
                sq.move(20, -50);
                sq.draw(w);
                sq.move(-50, 30);
                sq.draw(w);
        }
}

