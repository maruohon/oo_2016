package masa;

public class Bank
{
	public void createBasicAccount(String accountId, int balance)
	{
		System.out.println("Pankkiin lisätään: " + accountId + "," + balance);
	}

	public void createCreditAccount(String accountId, int balance, int credit)
	{
		System.out.println("Pankkiin lisätään: " + accountId + "," + balance + "," + credit);
	}

	public void deleteAccount(String accountId)
	{
		System.out.println("Tili poistettu.");
	}

	public void deposit(String accountId, int balance)
	{
		System.out.println("Talletetaan tilille: " + accountId + " rahaa " + balance);
	}

	public void withdraw(String accountId, int balance)
	{
		System.out.println("Nostetaan tililtä: " + accountId + " rahaa " + balance);
	}

	public void printAccount(String accountId)
	{
		System.out.println("Etsitään tiliä: " + accountId);
	}

	public void printAllAccounts()
	{
		System.out.println("Kaikki tilit:");
	}
}
