import java.util.Scanner;

public class Mainclass
{
	public static void main(String[] args)
	{
		BottleDispenser bd = new BottleDispenser();
		int action = 0;

		do
		{
			action = getAction();

			switch (action)
			{
				case 0:
					break;
				case 1:
					bd.addMoney();
					break;
				case 2:
					bd.buyBottle();
					break;
				case 3:
					bd.returnMoney();
					break;
				case 4:
					bd.listBottles();
					break;
				default:
					break;
			}

		} while (action != 0);
	}

	private static int getAction()
	{
		printMenu();
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private static void printMenu()
	{
		System.out.println("\n*** LIMSA-AUTOMAATTI ***");
		System.out.println("1) Lisää rahaa koneeseen");
		System.out.println("2) Osta pullo");
		System.out.println("3) Ota rahat ulos");
		System.out.println("4) Listaa koneessa olevat pullot");
		System.out.println("0) Lopeta");
		System.out.print("Valintasi: ");
	}
}


public class Bottle
{
	private String name;
	private String manufacturer;
	private float volume;
	private float price;
	private int totalEnergy;

	public Bottle()
	{
		this.name = "Pepsi Max";
		this.manufacturer = "Pepsi";
		this.volume = 0.5f;
		this.price = 1.8f;
		this.totalEnergy = 3;
	}

	public Bottle(String name, String manufacturer, int totalEnergy, float volume, float price)
	{
		this.name = name;
		this.manufacturer = manufacturer;
		this.totalEnergy = totalEnergy;
		this.volume = volume;
		this.price = price;
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

	public float getVolume()
	{
		return this.volume;
	}

	public float getPrice()
	{
		return this.price;
	}
}


import java.util.ArrayList;
import java.util.Locale;

public class BottleDispenser
{
	private ArrayList<Bottle> bottles;
	private float money;

	public BottleDispenser()
	{
		this.money = 0;
		this.bottles = new ArrayList<Bottle>();

		for (int i = 0; i < 6; i++)
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
		if (this.bottles.size() <= 0)
		{
			System.out.println("Pullot loppu!");
			return;
		}

		Bottle bottle = this.bottles.get(0);

		if (this.money < bottle.getPrice())
		{
			System.out.println("Syötä rahaa ensin!");
			return;
		}

		bottle = this.bottles.remove(0);
		this.money -= bottle.getPrice();

		System.out.println("KACHUNK! " + bottle.getName() + " tipahti masiinasta!");
	}

	public float returnMoney()
	{
		float amount = this.money;
		this.money = 0;

		//System.out.printf("Rahaa tuli ulos %.2f€\n", amount);
		System.out.println("Klink klink. Sinne menivät rahat!");

		return amount;
	}

	public void listBottles()
	{
		for (int i = 0; i < this.bottles.size(); i++)
		{
			Bottle bottle = this.bottles.get(i);
			System.out.print(String.format(Locale.ROOT, "%d. Nimi: %s\n\tKoko: %.1f\tHinta: %.1f\n",
				(i + 1), bottle.getName(), bottle.getVolume(), bottle.getPrice()));
		}
	}
}