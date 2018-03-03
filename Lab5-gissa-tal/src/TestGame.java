import java.util.Scanner;

public class TestGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Välkommen till spelet gissa nummret");
		System.out.println("Skriv först in dit min värde och sedan ditt max värde");
		int min = scan.nextInt();
		int max = scan.nextInt();
		NumberToGuess nbr = new NumberToGuess(min, max);
		System.out.println("SKriv nu in din gissning:");
		boolean correct = false;
		int nbrOfGuesses = 0;
		int correctAnswer = 0;
		while (!correct) {
			int guess = scan.nextInt();
			correctAnswer = guess;
			nbrOfGuesses++;
			if (nbr.isEqual(guess)) {
				correct = true;
			}

			else if (nbr.isBiggerThan(guess)) {
				System.out.println("Det var fel. Talet är större än: " + guess);
				System.out.println("Skriv in din nya gissning: ");
				/*
				 * System.out.println(nbr.getRndNbr()+ "min:" + nbr.getMin() +
				 * "max:" + nbr.getMax());
				 */
			} else {
				System.out.println("Det var fel. Talet är mindre än: " + guess);
				System.out.println("Skriv in din nya gissning: ");
				/*
				 * System.out.println(nbr.getRndNbr()+ "min:" + nbr.getMin() +
				 * "max:" + nbr.getMax());
				 */
			}
		}

		if (nbr.isEqual(correctAnswer)) {
			System.out.println("Det är korrekt! Talet är: " + correctAnswer);
			System.out.println("Antal gissningar:" + nbrOfGuesses);

		} else {
			System.out.println("Något gick fel");
		}

	}

}
