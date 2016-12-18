public class Mainclass
{
	public static void main(String[] args)
	{
		Dog dogRekku = new Dog("Rekku");
		Dog dogMusti = new Dog("Musti");
		dogRekku.speak("Hau!");
		dogMusti.speak("Vuh!");
	}
}

public class Dog
{
	private final String name;

	public Dog(String name)
	{
		this.name = name;
		System.out.println("Hei, nimeni on " + name + "!");
	}

	public void speak(String str)
	{
		System.out.println(this.name + ": " + str);
	}
}