import java.util.Scanner;

public class Mainclass
{
	public static void main(String[] args)
	{
		BottleDispenser bd = new BottleDispenser();
		int selection = 0;

		do
		{
			printMenu();
			selection = getSelection();
			handleSelection(selection, bd);
		} while (selection != 0);
	}

	private static int getSelection()
	{
		System.out.print("Valintasi: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private static void handleSelection(int selection, BottleDispenser bd)
	{
		switch (selection)
		{
			case 0:
				break;
			case 1:
				bd.addMoney();
				break;
			case 2:
				bd.listBottles();
				selection = getSelection();
				bd.buyBottle(selection);
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
	}

	private static void printMenu()
	{
		System.out.println("\n*** LIMSA-AUTOMAATTI ***");
		System.out.println("1) Lisää rahaa koneeseen");
		System.out.println("2) Osta pullo");
		System.out.println("3) Ota rahat ulos");
		System.out.println("4) Listaa koneessa olevat pullot");
		System.out.println("0) Lopeta");
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

public class BottleDispenser
{
	private ArrayList<Bottle> bottles;
	private float money;

	public BottleDispenser()
	{
		this.money = 0;
		this.bottles = new ArrayList<Bottle>();

		this.bottles.add(new Bottle("Pepsi Max", "Pepsi", 0, 0.5f, 1.8f));
		this.bottles.add(new Bottle("Pepsi Max", "Pepsi", 0, 1.5f, 2.2f));
		this.bottles.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 0.5f, 2.0f));
		this.bottles.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 1.5f, 2.5f));
		this.bottles.add(new Bottle("Fanta Zero", "Coca-Cola", 0, 0.5f, 1.95f));
		this.bottles.add(new Bottle("Fanta Zero", "Coca-Cola", 0, 0.5f, 1.95f));
	}

	public void addMoney()
	{
		this.money += 1;
		System.out.println("Klink! Lisää rahaa laitteeseen!");
	}

	public void buyBottle(int index)
	{
		index -= 1; // Turn the human readable index into 0-indexed form

		if (this.bottles.size() <= 0)
		{
			System.out.println("Pullot loppu!");
			return;
		}

		if (this.bottles.size() <= index)
		{
			System.out.println("Viallinen pullon valinta!");
			return;
		}

		Bottle bottle = this.bottles.get(index);

		if (this.money < bottle.getPrice())
		{
			System.out.println("Syötä rahaa ensin!");
			return;
		}

		bottle = this.bottles.remove(index);
		this.money -= bottle.getPrice();

		System.out.println("KACHUNK! " + bottle.getName() + " tipahti masiinasta!");
	}

	public void returnMoney()
	{
		System.out.printf("Klink klink. Sinne menivät rahat! Rahaa tuli ulos %.2f€\n", this.money);
		this.money = 0;
	}

	public void listBottles()
	{
		for (int i = 0; i < this.bottles.size(); i++)
		{
			Bottle bottle = this.bottles.get(i);
			System.out.println((i + 1) + ". Nimi: " + bottle.getName());
			System.out.println("\tKoko: " + bottle.getVolume() + "\tHinta: " + bottle.getPrice());
		}
	}
}