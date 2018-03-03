package ovn2;
import se.lth.cs.pt.window.SimpleWindow;

import java.awt.Color;


public class WindowApp {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(200,200,"App");
		w.setLineColor(Color.PINK);
		w.moveTo(100, 100);
		w.writeText("Hello Pink Panter!");
		while(true){
			w.waitForMouseClick();
			w.lineTo(w.getMouseX(), w.getMouseY());
			w.writeText("Helllo Pink Panter!");
		}
		
		

	}

}
