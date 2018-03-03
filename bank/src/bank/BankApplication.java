package bank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplication {
	private Scanner scan = new Scanner(System.in);
	private Bank bank;
	private String name;
	private int menuChoice;

	public BankApplication(String name) {
		this.name = name;
		bank = new Bank();
	}

	public Bank getBank() {
		return bank;
	}

	private void printMenu() {
		System.out.println("----------------------------------------------------");
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in ");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");
		System.out.print("val: ");
		menuChoice = scan.nextInt();
	}

	private void case1() {
		long id = 0;
		do {
			try {
				System.out.print("id :");
				id = scan.nextLong();
			} catch (InputMismatchException e) {
				// System.out.print("id :");
			}
			scan.nextLine(); // clears the buffer
		} while (id <= 0);
		int length = String.valueOf(id).length();
		if (length < 10 || length > 10) {
			System.out.println("id-nummer måste vara 10 siffor");

		} else if (bank.findAccountsForHolder(id).size() == 0) {
			System.out.println("Inga kunder med det ID-nummret");
		} else {
			for (BankAccount b : bank.findAccountsForHolder(id)) {
				System.out.println(b);
			}
		}

	}

	private void case2() {
		System.out.print("namn: ");
		scan.nextLine();
		String namn = scan.nextLine();
		if (bank.findByPartofName(namn).size() == 0) {
			System.out.println("Inga kunder med det namnet");
		} else {
			for (Customer c : bank.findByPartofName(namn)) {
				System.out.println(c);
			}
		}
	}

	// private void case3() {
	// System.out.print("konto :");
	// int kontoNr = scan.nextInt();
	// scan.nextLine();
	// if (bank.findByNumber(kontoNr) == null) {
	// System.out.println("ej giltigt kontonummer, försök igen");
	// } else {
	// System.out.print("belopp :");
	// double amount = scan.nextDouble();
	// if (amount < 0) {
	// System.out.println("Kan bara sätta in positiva belopp, försök igen");
	// } else {
	// bank.findByNumber(kontoNr).deposit(amount);
	// System.out.println(bank.findByNumber(kontoNr));
	// }
	// }
	// }

	private void case3() {
		int kontoNr = 0;
		do {
			try {
				System.out.print("konto :");
				kontoNr = scan.nextInt();
			} catch (InputMismatchException e) {
				// System.out.print("id :");
			}
			scan.nextLine(); // clears the buffer
		} while (kontoNr <= 0);
		if (bank.findByNumber(kontoNr) == null) {
			System.out.println("ej giltigt kontonummer, försök igen");
		} else {
			double amount = 0;

			do {
				try {
					System.out.print("belopp :");
					amount = scan.nextDouble();
				} catch (InputMismatchException e) {
					// System.out.print("id :");
				}
				scan.nextLine(); // clears the buffer
			} while (amount == 0);

			if (amount < 0) {
				System.out.println("Kan bara sätta in positiva belopp, försök igen");
			} else {
				bank.findByNumber(kontoNr).deposit(amount);
				System.out.println(bank.findByNumber(kontoNr));
			}
		}
	}

	private void case4() {
		System.out.print("från konto :");
		int kontoNr = scan.nextInt();
		scan.nextLine();

		if (bank.findByNumber(kontoNr) == null) {
			System.out.println("Felaktigt konto nummer, vänligen försök igen");
		} else {
			System.out.print("belopp :");
			double amount = scan.nextDouble();
			if ((bank.findByNumber(kontoNr).getAmmount() - amount) < -100) {
				System.out.println("Transaktionen misslyckades, endast " + bank.findByNumber(kontoNr).getAmmount()
						+ " kr på kontot!");
			} else {
				bank.findByNumber(kontoNr).withdraw(amount);
				System.out.println(bank.findByNumber(kontoNr));
			}

		}
	}

	private void case5() {
		System.out.print("från konto :");
		int kontoFrom = scan.nextInt();
		scan.nextLine();
		if (bank.findByNumber(kontoFrom) == null) {
			System.out.println("Felaktigt konto nummer, vänligen försök igen");
		} else {
			System.out.print("Till konto :");
			int kontoTo = scan.nextInt();
			scan.nextLine();
			if (bank.findByNumber(kontoTo) == null) {
				System.out.println("Felaktigt konto nummer, vänligen försök igen");
			} else {
				System.out.print("belopp :");
				double amount = scan.nextDouble();
				if (amount > bank.findByNumber(kontoFrom).getAmmount()) {
					System.out.println("Transaktionen mislyckades, för lite pengar på konto: " + kontoFrom);
				} else {
					bank.findByNumber(kontoFrom).withdraw(amount);
					bank.findByNumber(kontoTo).deposit(amount);
				}
				System.out.println(bank.findByNumber(kontoFrom));
				System.out.println(bank.findByNumber(kontoTo));
			}
		}
	}

	private void case6() {
		System.out.print("namn: ");
		scan.nextLine();
		String namn = scan.nextLine();
		long id = 0;
		do {
			try {
				System.out.print("id :");
				id = scan.nextLong();
			} catch (InputMismatchException e) {
				// System.out.print("id :");
			}
			scan.nextLine(); // clears the buffer
		} while (id <= 0);
		int length = String.valueOf(id).length();
		if (length < 10 || length > 10) {
			System.out.println("id-nummer måste vara 10 siffor");

		} else {
			int kontoNr = bank.addAccount(namn, id);
			if (kontoNr < 0) {
				System.out.println("namn och id matchar inte");
			} else {
				System.out.println("Konto skapat: " + kontoNr);
			}
		}
	}

	private void case7() {
		System.out.print("konto :");
		int kontoNr = scan.nextInt();
		scan.nextLine();
		if (bank.findByNumber(kontoNr) == null) {
			System.out.println("Felaktigt konto nummer, vänligen försök igen");
		} else {
			boolean gone = bank.removeAccount(kontoNr);
			if (!gone) {
				System.out.println("Felaktigt kontonummer!");
			}
		}
	}

	private void case8() {
		for (BankAccount b : bank.getAllAccounts()) {
			System.out.println(b);
		}
	}

	public void runApplication() {
		printMenu();
		switch (menuChoice) {
		case 1:
			case1();
			break;
		case 2:
			case2();
			break;
		case 3:
			case3();
			break;
		case 4:
			case4();
			break;
		case 5:
			case5();
			;
			break;
		case 6:
			case6();
			break;
		case 7:
			case7();
			;
			break;
		case 8:
			case8();
			break;
		case 9:
			scan.close();
			System.exit(0);
			break;
		default: {
			System.out.println("Det där är inte ett giltigt val, försök igen");
		}
			;
			break;
		}
		runApplication();
	}

	public static void main(String[] args) {
		BankApplication swedbank = new BankApplication("Swedbank");

		swedbank.runApplication();
	}
}

// Bank bank = swedbank.getBank();
// swedbank.accountAdder();

// private void printFinalLine() {
// System.out.println("----------------------------------------------------");
// }

// public void accountAdder() {
// bank.addAccount("Göran Svensson", 747531);
// bank.addAccount("Albert Ainsten", 923141);
// bank.addAccount("Xanor Xanax", 831293);
// bank.addAccount("Göran Svensson", 747531);
// }

// private void case1() {
// System.out.print("id :");
// long id = scan.nextLong();
// if (bank.findAccountsForHolder(id).size() == 0) {
// System.out.println("Inga kunder med det ID-nummret");
// } else {
// for (BankAccount b : bank.findAccountsForHolder(id)) {
// System.out.println(b);
// }
// }
// }

// private void case6() {
// System.out.print("namn: ");
// scan.nextLine();
// String namn = scan.nextLine();
// System.out.print("id :");
// long id = scan.nextLong();
// int kontoNr = bank.addAccount(namn, id);
// System.out.println("Konto skapat: " + kontoNr);
// }

// private void case4() {
// System.out.print("från konto :");
// int kontoNr = scan.nextInt();
// scan.nextLine();
//
// if (bank.findByNumber(kontoNr) == null) {
// System.out.println("Felaktigt konto nummer, vänligen försök igen");
// } else {
// System.out.print("belopp :");
// double amount = scan.nextDouble();
// if (bank.findByNumber(kontoNr).withdraw(amount)) {
// ;
// System.out.println(bank.findByNumber(kontoNr));
// } else {
// System.out.println("Transaktionen misslyckades, endast " +
// bank.findByNumber(kontoNr).getAmmount()
// + " kr på kontot!");
// }
// }
// }