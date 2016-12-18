public class Mainclass
{
	public static void main(String[] args)
	{
		BottleDispenser bd = new BottleDispenser();
		bd.addMoney();
		bd.buyBottle();
		bd.buyBottle();
		bd.addMoney();
		bd.addMoney();
		bd.buyBottle();
		bd.returnMoney();
	}
}


public class BottleDispenser
{
	private int bottles;
	private int money;

	public BottleDispenser()
	{
		this.bottles = 5;
		this.money = 0;
	}

	public void addMoney()
	{
		this.money += 1;
		System.out.println("Klink! Lisää rahaa laitteeseen!");
	}

	public void buyBottle()
	{
		if (this.money <= 0)
		{
			System.out.println("Syötä rahaa ensin!");
			return;
		}

		if (this.bottles <= 0)
		{
			System.out.println("Pullot loppu!");
			return;
		}

		this.bottles -= 1;
		this.money -= 1;
		System.out.println("KACHUNK! Pullo tipahti masiinasta!");
	}

	public void returnMoney()
	{
		this.money = 0;
		System.out.println("Klink klink. Sinne menivät rahat!");
	}
}