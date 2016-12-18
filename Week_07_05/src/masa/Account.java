package masa;

public abstract class Account
{
	protected String id;
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

	public int deposit(int amount)
	{
		this.balance += amount;
		return amount;
	}

	public int withdraw(int amount)
	{
		if (this.getMaxWithdrawAmount() >= amount)
		{
			this.balance -= amount;
			return amount;
		}

		return 0;
	}

	public abstract int getMaxWithdrawAmount();


	public static class BasicAccount extends Account
	{
		public BasicAccount(String accountId, int initialBalance)
		{
			super(accountId, initialBalance);
		}

		@Override
		public int getMaxWithdrawAmount()
		{
			return this.balance;
		}
	}

	public static class CreditAccount extends Account
	{
		private int credit;

		public CreditAccount(String accountId, int initialBalance, int credit)
		{
			super(accountId, initialBalance);

			this.credit = credit;
		}

		@Override
		public int getMaxWithdrawAmount()
		{
			return this.balance + this.credit;
		}

		@Override
		public void printAccount()
		{
			System.out.println("Tilinumero: " + this.id +
					" Tilillä rahaa: " + this.balance +
					" Luottoraja: " + this.credit);
		}
	}
}
