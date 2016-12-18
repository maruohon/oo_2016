package application;

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

	@Override
	public String toString()
	{
		return String.format("%s, %.1f l, %.2f €", this.name, this.volume, this.price);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(volume);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bottle other = (Bottle) obj;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(volume) != Float.floatToIntBits(other.volume))
			return false;
		return true;
	}
}
