import java.util.*;

public class NumberToGuess{
	private Random rand = new Random();
	private int max;
	private int min;
	private int randNbr;
	
	/** Skapar ett objekt med ett slumpmässigt valt heltal i 
	    intervallet [min, max]. */
	public NumberToGuess(int min, int max) {
		this.min = min;
		this.max = max;
		randNbr = rand.nextInt((this.max - this.min) + 1) + this.min;
	}

	/** Tag reda på minsta möjliga värde talet kan ha. */
	public int getMin() {
		return min;
	}

	/** Tag reda på största möjliga värde talet kan ha. */
	public int getMax() {
		return max;
	}

	/** Tar reda på om talet är lika med guess. */
	public boolean isEqual(int guess) {
		if(guess == randNbr){
			return true;
		}
		else{
			return false;
		}
	}

	/** Tar reda på om talet är större än guess. */
	public boolean isBiggerThan(int guess) {
		if( randNbr > guess){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	/** Tar reda på om talet är mindre än guess. */
	public boolean isSmallerThan(int guess) {
		if( randNbr < guess){
			return true;
		}
		else{
			return false;
		}
	}
	
	/** Tar reda på vilket det hemliga nummret är. */
	public int getRndNbr() {
		return randNbr;
	}
}
