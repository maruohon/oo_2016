package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BottleDispenser
{
	private static BottleDispenser instance = null;
	private List<Bottle> bottles = new ArrayList<Bottle>();
	private Map<Bottle, Integer> bottleCounts = new LinkedHashMap<Bottle, Integer>();
	private float money = 0;

	private BottleDispenser()
	{
		this.bottles.add(new Bottle("Pepsi Max", "Pepsi", 0, 0.5f, 1.8f));
		this.bottles.add(new Bottle("Pepsi Max", "Pepsi", 0, 0.5f, 1.8f));
		this.bottles.add(new Bottle("Pepsi Max", "Pepsi", 0, 1.5f, 2.2f));
		this.bottles.add(new Bottle("Pepsi Max", "Pepsi", 0, 1.5f, 2.2f));
		this.bottles.add(new Bottle("Pepsi Max", "Pepsi", 0, 1.5f, 2.2f));
		this.bottles.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 0.5f, 2.0f));
		this.bottles.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 0.5f, 2.0f));
		this.bottles.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 0.5f, 2.0f));
		this.bottles.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 1.5f, 2.5f));
		this.bottles.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 1.5f, 2.5f));
		this.bottles.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0, 1.5f, 2.5f));
		this.bottles.add(new Bottle("Fanta Zero", "Coca-Cola", 0, 0.5f, 1.95f));
		this.bottles.add(new Bottle("Fanta Zero", "Coca-Cola", 0, 0.5f, 1.95f));
		this.bottles.add(new Bottle("Fanta Zero", "Coca-Cola", 0, 0.5f, 1.95f));
		this.bottles.add(new Bottle("Fanta Zero", "Coca-Cola", 0, 0.5f, 1.95f));

		this.updateCounts();
	}

	public static BottleDispenser getInstance()
	{
		if (instance == null)
		{
			instance = new BottleDispenser();
		}

		return instance;
	}

	public float getCurrentMoney()
	{
		return this.money;
	}

	public void addMoney(float amount)
	{
		this.money += amount;
	}

	public String buyBottle(Bottle bottle)
	{
		Iterator<Bottle> iter = this.bottles.iterator();

		while (iter.hasNext())
		{
			Bottle bottleIter = iter.next();

			if (bottleIter.equals(bottle))
			{
				float price = bottleIter.getPrice();

				if (price <= this.money)
				{
					this.printReceipt(bottleIter);
					this.money -= price;
					iter.remove();
					this.updateCounts();

					return "Pullo '" + bottleIter.toString() + "' tipahti masiinasta!";
				}
				else
				{
					return "Eioo tarpeeks rahaa!";
				}
			}
		}

		return "Pyydettyä pulloa ei löytynyt!";
	}

	private void printReceipt(Bottle bottle)
	{
		File file = new File("kuitti.txt");
		String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String str = String.format("******* Kuitti ********\nPäiväys: %s\nTuote: %s, %.1f l\nHinta: %.2f €\n====================\n\n",
				strDate, bottle.getName(), bottle.getVolume(), bottle.getPrice());
		try
		{
			FileWriter fw = new FileWriter(file, true);
			fw.append(str);
			fw.close();
		}
		catch (IOException e)
		{
		}
	}

	public String returnMoney()
	{
		float amount = this.money;
		this.money = 0;

		return String.format("%.2f € tipahti masiinasta", amount);
	}

	public List<Bottle> getBottleTypes()
	{
		List<Bottle> list = new ArrayList<Bottle>();
		list.addAll(this.bottleCounts.keySet());
		return list;
	}

	public Map<Bottle, Integer> getBottleQuantities()
	{
		return this.bottleCounts;
	}

	private void updateCounts()
	{
		this.bottleCounts.clear();

		for (Bottle b : this.bottles)
		{
			Integer count = this.bottleCounts.get(b);

			if (count != null)
			{
				count = count + 1;
			}
			else
			{
				count = 1;
			}

			this.bottleCounts.put(b, count);
		}
	}
}
