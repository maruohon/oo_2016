package masa;

import java.util.Scanner;

public class Mainclass
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int selection = 0;

		do
		{
			printMainMenu();
			selection = scanner.nextInt();
			handleSelection(selection, scanner);
		} while (selection != 0);
	}

	private static void handleSelection(int selection, Scanner scanner)
	{
		switch (selection)
		{
			case 1: // Lisää tavallinen tili
				createBasicAccount(scanner);
				break;
			case 2: // Lisää luotollinen tili
				createCreditAccount(scanner);
				break;
			case 3: // Tallenna tilille rahaa
				deposit(scanner);
				break;
			case 4: // Nosta tililtä
				withdraw(scanner);
				break;
			case 5: // Poista tili
				deleteAccount(scanner);
				break;
			case 6: // Tulosta tili
				printAccount(scanner);
				break;
			case 7: // Tulosta kaikki tilit
				printAllAccounts();
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

	private static void createBasicAccount(Scanner scanner)
	{
		String accountId;
		int balance = 0;

		System.out.print("Syötä tilinumero: ");
		accountId = scanner.next();

		System.out.print("Syötä rahamäärä: ");
		balance = scanner.nextInt();

		System.out.println("Tilinumero: " + accountId);
		System.out.println("Rahamäärä: " + balance);
	}

	private static void createCreditAccount(Scanner scanner)
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

		System.out.println("Tilinumero: " + accountId);
		System.out.println("Rahamäärä: " + balance);
		System.out.println("Luotto: " + credit);
	}

	private static void deposit(Scanner scanner)
	{
		String accountId;
		int balance = 0;

		System.out.print("Syötä tilinumero: ");
		accountId = scanner.next();

		System.out.print("Syötä rahamäärä: ");
		balance = scanner.nextInt();

		System.out.println("Tilinumero: " + accountId);
		System.out.println("Rahamäärä: " + balance);
	}

	private static void withdraw(Scanner scanner)
	{
		String accountId;
		int balance = 0;

		System.out.print("Syötä tilinumero: ");
		accountId = scanner.next();

		System.out.print("Syötä rahamäärä: ");
		balance = scanner.nextInt();

		System.out.println("Tilinumero: " + accountId);
		System.out.println("Rahamäärä: " + balance);
	}

	private static void deleteAccount(Scanner scanner)
	{
		String accountId;

		System.out.print("Syötä poistettava tilinumero: ");
		accountId = scanner.next();

		System.out.println("Tilinumero: " + accountId);
	}

	private static void printAccount(Scanner scanner)
	{
		String accountId;

		System.out.print("Syötä tulostettava tilinumero: ");
		accountId = scanner.next();

		System.out.println("Tilinumero: " + accountId);
	}

	private static void printAllAccounts()
	{
		System.out.println("Tulostaa kaiken");
	}
}
