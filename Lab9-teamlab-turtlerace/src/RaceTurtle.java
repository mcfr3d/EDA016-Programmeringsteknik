import java.awt.Color;
import java.util.Random;
 
public class RaceTurtle extends ColorTurtle{
        private static Random rand = new Random();
        private int nbr;
       
        public RaceTurtle(RaceWindow w, int nbr) {
                super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr), getColor(nbr));
                this.nbr = nbr;
                penDown();
                left(-90); //turns to the right
        }
       
        public void raceStep(){
                forward(rand.nextInt(6) + 1);
        }
       
        public String toString(){
                return "Nummer " + nbr;
        }
       
        public static Random getRandom(){
                return rand;
        }
       
        private static Color getColor(int nbr){ //sets turtle color based on starting number
                Color col;
               
                switch(nbr){
                        case 1: col = Color.BLUE; break;
                        case 2: col = Color.PINK; break;
                        case 3: col = Color.GREEN; break;
                        case 4: col = Color.RED; break;
                        case 5: col = Color.CYAN; break;
                        case 6: col = Color.YELLOW; break;
                        case 7: col = Color.ORANGE; break;
                        case 8: col = Color.MAGENTA; break;
                        default: col = Color.BLACK; break;
                }
                return col;
               
        }
       
}