package masa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Car
{
	private Map<Class<?>, List<CarPart>> parts = new LinkedHashMap<Class<?>, List<CarPart>>();

	public Car()
	{
		this.addPart(new Body());
		this.addPart(new Chassis());
		this.addPart(new Engine());
		this.addPart(new Wheel());
		this.addPart(new Wheel());
		this.addPart(new Wheel());
		this.addPart(new Wheel());
	}

	private void addPart(CarPart part)
	{
		List<CarPart> list = this.parts.get(part.getClass());

		if (list == null)
		{
			list = new ArrayList<CarPart>();
			this.parts.put(part.getClass(), list);
		}

		list.add(part);
	}

	public void print()
	{
		System.out.println("Autoon kuuluu:");

		for (Map.Entry<Class<?>, List<CarPart>> entry : this.parts.entrySet())
		{
			List<CarPart> list = entry.getValue();

			if (list.size() > 1)
			{
				System.out.println("\t" + list.size() + " " + list.get(0).getName());
			}
			else
			{
				System.out.println("\t" + list.get(0).getName());
			}
		}
	}

	private abstract class CarPart
	{
		private String name;

		public CarPart(String name)
		{
			this.name = name;
			System.out.println("Valmistetaan: " + name);
		}

		public String getName()
		{
			return this.name;
		}
	}

	private class Body extends CarPart
	{
		public Body()
		{
			super("Body");
		}
	}

	private class Chassis extends CarPart
	{
		public Chassis()
		{
			super("Chassis");
		}
	}

	private class Engine extends CarPart
	{
		public Engine()
		{
			super("Engine");
		}
	}

	private class Wheel extends CarPart
	{
		public Wheel()
		{
			super("Wheel");
		}
	}
}
