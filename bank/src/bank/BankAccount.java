package bank;

public class BankAccount {
	private Customer holder;
	private int accNr;
	private double amount;
	private static int nbrOfAcc;

	/**
	 * Skapar ett nytt bankkonto åt en innehavare med namn 'holderName' och id
	 * 'holderId'. Kontot tilldelas ett unikt kontonummer och innehåller
	 * inledingsvis 0 kr.
	 */
	public BankAccount(String holderName, long holderId) {
		holder = new Customer(holderName, holderId);
		nbrOfAcc++;
		accNr = 1000 + nbrOfAcc;
		// holder.getCustomerNr()*
		amount = 0.00;
	}

	/**
	 * Skapar ett nytt bankkonto med innehavare 'holder'. Kontot tilldelas ett
	 * unikt kontonummer och innehåller inledningsvis 0 kr.
	 */
	public BankAccount(Customer holder) {
		this.holder = holder;
		nbrOfAcc++;
		accNr = 1000 + nbrOfAcc;
		// holder.getCustomerNr()*
		amount = 0.00;
	}

	/** Tar reda på kontots innehavare. */
	public Customer getHolder() {
		return holder;
	}

	/** Tar reda på det kontonummer som identifierar detta konto. */
	public int getAccountNumber() {
		return accNr;
	}

	/** Tar reda på hur mycket pengar som finns på kontot. */
	public double getAmmount() {
		return amount;
	}

	/** Sätter in beloppet 'amount' på kontot. */
	public void deposit(double amount) {
		this.amount += amount;
	}

	private boolean overCharge(double amount) {
		if (this.amount - amount < 0) {
			return true;
		} else
			return false;
	}

	private double overChargeAmount(double amount) {
		if (overCharge(amount)) {
			return Math.abs(this.amount - amount);
		} else
			return 0;
	}

	/**
	 * Tar ut beloppet 'amount' på kontot. Om kontot saknar täckning blir saldot
	 * negativt.
	 */
	public void withdraw(double amount) {
		this.amount -= amount;

	}

	/** Returnerar en sträng representation av bankkontot. */
	public String toString() {
		String s = ("konto " + accNr + " (" + holder + ") : " + amount);
		return s;
	}

}

// public static class Test{
// public static void main(String[] args){
// BankAccount b = new BankAccount("Fredrik Nyberg",9111281100l);
// System.out.println(b);
// }
// }

// public boolean withdraw(double amount) {
// if (overCharge(amount)) {
// double amountOver = overChargeAmount(amount);
// if (amountOver > 100) {
// return false;
// } else {
// this.amount -= amount;
// return true;
// }
// }
// else{this.amount -= amount;
// return true;}
//
// }
