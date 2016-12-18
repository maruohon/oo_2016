public class Mainclass
{
	public static void main(String[] args)
	{
		Dog dog = new Dog("Rekku");
		dog = new Dog("Musti");
		dog.speak("Hau!");
		dog.speak("Vuh!");
	}
}

public class Dog
{
	public Dog(String name)
	{
		System.out.println("Hei, nimeni on " + name + "!");
	}

	public void speak(String str)
	{
		System.out.println(str);
	}
}