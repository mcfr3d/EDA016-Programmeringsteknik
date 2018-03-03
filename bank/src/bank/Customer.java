package bank;

public class Customer {
	private String name;
	private long idNr;
	private static int nbrCustomers;
	private int customerNr;
	
	/**
	 * Skapar en kund (kontoinnehavare) med namnet 'name' och id-nummer 'idNr'
	 * kunden tilldelas också ett unikt kundnummer.
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		nbrCustomers++;
		customerNr = nbrCustomers;
	}
	
	/** Tar reda på kundens namn. */
	public String getName() {
		return name;
	}
	
	/** Tar reda på kundens personnummer. */
	public long getIdNr() {
		return idNr;
	}
	
	/** Tar reda på kundens kundnummer. */
	public int getCustomerNr() {
		return customerNr;
	}
	
	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		String cNr = String.format("%03d", customerNr);
		String s = (name + ", id " + idNr + ", kundnr " + cNr);
		return s;
	}
	// public static class Test{
	// public static void main(String[] args){
	// Customer c = new Customer("Fredrik Nyberg",9111281100l);
	// System.out.println(c);
	// }
}
