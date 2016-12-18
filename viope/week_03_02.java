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


import java.util.ArrayList;

public class BottleDispenser
{
	private ArrayList<Bottle> bottles;
	private int money;

	public BottleDispenser()
	{
		this.money = 0;
		this.bottles = new ArrayList<Bottle>();

		for (int i = 0; i < 5; i++)
		{
			this.bottles.add(new Bottle());
		}
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

		if (this.bottles.size() <= 0)
		{
			System.out.println("Pullot loppu!");
			return;
		}

		Bottle bottle = this.bottles.remove(0);
		this.money -= 1;
		System.out.println("KACHUNK! " + bottle.getName() + " tipahti masiinasta!");
	}

	public void returnMoney()
	{
		this.money = 0;
		System.out.println("Klink klink. Sinne menivät rahat!");
	}
}


public class Bottle
{
	private String name;
	private String manufacturer;
	private int totalEnergy;

	public Bottle()
	{
		this.name = "Pepsi Max";
		this.manufacturer = "Pepsi";
		this.totalEnergy = 3;
	}

	public Bottle(String name, String manufacturer, int totalEnergy)
	{
		this.name = name;
		this.manufacturer = manufacturer;
		this.totalEnergy = totalEnergy;
	}

	public String getName()
	{
		return this.name;
	}

	public String getManufacturer()
	{
		return this.manufacturer;
	}

	public int getTotalEnergy()
	{
		return this.totalEnergy;
	}
}