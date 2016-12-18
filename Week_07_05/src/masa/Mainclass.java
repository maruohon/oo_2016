package masa;

import java.util.Scanner;

public class Mainclass
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Bank bank = new Bank();
		int selection = 0;

		do
		{
			printMainMenu();
			selection = scanner.nextInt();
			handleSelection(bank, selection, scanner);
		} while (selection != 0);
	}

	private static void handleSelection(Bank bank, int selection, Scanner scanner)
	{
		switch (selection)
		{
			case 1: // Lisää tavallinen tili
				createBasicAccount(bank, scanner);
				break;
			case 2: // Lisää luotollinen tili
				createCreditAccount(bank, scanner);
				break;
			case 3: // Tallenna tilille rahaa
				deposit(bank, scanner);
				break;
			case 4: // Nosta tililtä
				withdraw(bank, scanner);
				break;
			case 5: // Poista tili
				deleteAccount(bank, scanner);
				break;
			case 6: // Tulosta tili
				printAccount(bank, scanner);
				break;
			case 7: // Tulosta kaikki tilit
				printAllAccounts(bank);
				break;
			case 0: // Lopeta
				break;
			default:
				System.out.println("Valinta ei kelpaa.");
		}
	}

	private static void printMainMenu()
	{
		System.out.println();
		System.out.println("*** PANKKIJÄRJESTELMÄ ***");
		System.out.println("1) Lisää tavallinen tili");
		System.out.println("2) Lisää luotollinen tili");
		System.out.println("3) Tallenna tilille rahaa");
		System.out.println("4) Nosta tililtä");
		System.out.println("5) Poista tili");
		System.out.println("6) Tulosta tili");
		System.out.println("7) Tulosta kaikki tilit");
		System.out.println("0) Lopeta");
		System.out.print("Valintasi: ");
	}

	private static void createBasicAccount(Bank bank, Scanner scanner)
	{
		String accountId;
		int balance = 0;

		System.out.print("Syötä tilinumero: ");
		accountId = scanner.next();

		System.out.print("Syötä rahamäärä: ");
		balance = scanner.nextInt();

		bank.createBasicAccount(accountId, balance);
	}

	private static void createCreditAccount(Bank bank, Scanner scanner)
	{
		String accountId;
		int balance = 0;
		int credit = 0;

		System.out.print("Syötä tilinumero: ");
		accountId = scanner.next();

		System.out.print("Syötä rahamäärä: ");
		balance = scanner.nextInt();

		System.out.print("Syötä luottoraja: ");
		credit = scanner.nextInt();

		bank.createCreditAccount(accountId, balance, credit);
	}

	private static void deposit(Bank bank, Scanner scanner)
	{
		String accountId;
		int balance = 0;

		System.out.print("Syötä tilinumero: ");
		accountId = scanner.next();

		System.out.print("Syötä rahamäärä: ");
		balance = scanner.nextInt();

		bank.deposit(accountId, balance);
	}

	private static void withdraw(Bank bank, Scanner scanner)
	{
		String accountId;
		int balance = 0;

		System.out.print("Syötä tilinumero: ");
		accountId = scanner.next();

		System.out.print("Syötä rahamäärä: ");
		balance = scanner.nextInt();

		bank.withdraw(accountId, balance);
	}

	private static void deleteAccount(Bank bank, Scanner scanner)
	{
		String accountId;

		System.out.print("Syötä poistettava tilinumero: ");
		accountId = scanner.next();

		bank.deleteAccount(accountId);
	}

	private static void printAccount(Bank bank, Scanner scanner)
	{
		String accountId;

		System.out.print("Syötä tulostettava tilinumero: ");
		accountId = scanner.next();

		bank.printAccount(accountId);
	}

	private static void printAllAccounts(Bank bank)
	{
		bank.printAllAccounts();
	}
}

