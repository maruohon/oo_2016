package masa;

public abstract class Account
{
	private String id;
	protected int balance;

	public Account(String accountId, int initialBalance)
	{
		this.id = accountId;
		this.balance = initialBalance;
	}

	public String getAccountId()
	{
		return this.id;
	}

	public int getBalance()
	{
		return this.balance;
	}

	public void printAccount()
	{
		System.out.println("Tilinumero: " + this.id + " Tilillä rahaa: " + this.balance);
	}

	public abstract int deposit(int amount);

	public abstract int withdraw(int amount);


	public static class BasicAccount extends Account
	{
		public BasicAccount(String accountId, int initialBalance)
		{
			super(accountId, initialBalance);
		}

		@Override
		public int deposit(int amount)
		{
			this.balance += amount;
			return amount;
		}

		@Override
		public int withdraw(int amount)
		{
			if (this.balance >= amount)
			{
				this.balance -= amount;
				return amount;
			}

			return 0;
		}
	}
}
