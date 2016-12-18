package masa;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bank
{
	private final Map<String, Account> accounts = new LinkedHashMap<String, Account>();

	public void createBasicAccount(String accountId, int initialBalance)
	{
		Account account = new Account.BasicAccount(accountId, initialBalance);
		this.accounts.put(accountId, account);
		System.out.println("Tili luotu.");
	}

	public void createCreditAccount(String accountId, int initialBalance, int credit)
	{
		Account account = new Account.CreditAccount(accountId, initialBalance, credit);
		this.accounts.put(accountId, account);
		System.out.println("Tili luotu.");
	}

	public void deleteAccount(String accountId)
	{
		this.accounts.remove(accountId);
		System.out.println("Tili poistettu.");
	}

	public void deposit(String accountId, int amount)
	{
		Account account = this.accounts.get(accountId);

		if (account != null)
		{
			account.deposit(amount);
		}
	}

	public void withdraw(String accountId, int amount)
	{
		Account account = this.accounts.get(accountId);

		if (account != null)
		{
			account.withdraw(amount);
		}
	}

	public void printAccount(String accountId)
	{
		Account account = this.accounts.get(accountId);

		if (account != null)
		{
			account.printAccount();
		}
	}

	public void printAllAccounts()
	{
		System.out.println("Kaikki tilit:");

		for (Map.Entry<String, Account> entry : this.accounts.entrySet())
		{
			entry.getValue().printAccount();
		}
	}
}
