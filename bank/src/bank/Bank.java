package bank;

import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> bankAccounts;
	
	/** Skapar en ny bank utan konton. */
	public Bank() {
		bankAccounts = new ArrayList<BankAccount>();
	}
	
	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med
	 * det givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	public int addAccount(String holderName, long idNr) {
		if (findHolder(idNr) == null) {
			BankAccount a = new BankAccount(holderName, idNr);
			bankAccounts.add(a);
			return bankAccounts.get(bankAccounts.lastIndexOf(a)).getAccountNumber();
		} 
		else if(findHolder(idNr).getName().toLowerCase().compareTo(holderName.toLowerCase())== 0){
			BankAccount a = new BankAccount(findHolder(idNr));
			bankAccounts.add(a);
			return bankAccounts.get(bankAccounts.lastIndexOf(a)).getAccountNumber();
		}
		
		else{
			return -1;

		}
//		
//		else{
//			System.out.println("Namn och id matcher inte");
//			
//		}
	}
	
	/**
	 * Returner den kontoinnehavarren som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */
	public Customer findHolder(long idNr) {
		for (BankAccount b : bankAccounts) {
			long id = b.getHolder().getIdNr();
			if (id == idNr) {
				return b.getHolder();
			}
		}
		return null;
	}
	
	/**
	 * Tar bort konto med nummer 'number' från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	public boolean removeAccount(int number) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getAccountNumber() == number) {
				bankAccounts.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returnerar en lista innehållande samtilga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	public ArrayList<BankAccount> getAllAccounts() {
		ArrayList<BankAccount> sortedAcc = new ArrayList<BankAccount>();
		for (BankAccount b : bankAccounts) {
			int pos = 0;
			String nameUnsorted = b.getHolder().getName();
			while (pos < sortedAcc.size()
					&& nameUnsorted.compareToIgnoreCase(sortedAcc.get(pos).getHolder().getName()) > 0) {
				pos++;
			}
			sortedAcc.add(pos, b);
		}
		return sortedAcc;
	}
	
	// if (sortedAcc.size() == 0) {
	// sortedAcc.add(pos, b);
	// }
	// String nameSorted = sortedAcc.get(pos).getHolder().getName();
	//
	//
	//
	/**
	 * söker upp och returnerar bankkontot med kontonummer 'accountNumber'.
	 * Returnerar null om inget sådant sådant konto finns.
	 */
	public BankAccount findByNumber(int accountNumber) {
		for (BankAccount b : bankAccounts) {
			if (accountNumber == b.getAccountNumber()) {
				return b;
			}
		}
		return null;
	}
	
	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'.
	 * kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> holderAccounts = new ArrayList<BankAccount>();
		for (BankAccount b : bankAccounts) {
			long idNrInList = b.getHolder().getIdNr();
			if (idNr == idNrInList) {
				holderAccounts.add(b);
			}
		}
		return holderAccounts;
	}
	
	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
	 * personer vars namn innehåller strängen 'namePart' inkluderas i
	 * resultatet, som returneras som en lista. Samma person kan förekomma flera
	 * gånger i resultatet. Sökningen är "case insesitive", det vil säga gör
	 * ingen skillnad på stora och små bokstäver-
	 */
	ArrayList<Customer> findByPartofName(String namePart) {
		// ArrayList<BankAccount> sortedList = getAllAccounts();
		ArrayList<Customer> containsNameList = new ArrayList<Customer>();
		long[] idnrList = new long[getAllAccounts().size()];
		int indexCount = 0;
		for (BankAccount b : getAllAccounts()) {
			String fullName = b.getHolder().getName().toLowerCase();
			if (fullName.contains(namePart.toLowerCase())) {
				boolean idExist = false;
				for (int i = 0; i < idnrList.length; i++) {
					if (idnrList[i] == b.getHolder().getIdNr()) {
						idExist = true;
					}
				}
				if (!idExist) {
					containsNameList.add(b.getHolder());
					idnrList[indexCount]=b.getHolder().getIdNr();
					indexCount ++;
					
				}
			}
		}
		return containsNameList;
	}
}
