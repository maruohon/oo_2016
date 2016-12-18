import java.util.Scanner;

public class Mainclass
{
	public static void main(String[] args)
	{
		String name = readInput("Anna koiralle nimi");
		Dog dog = new Dog(name);

		String say = readInput("Mitä koira sanoo");
		dog.speak(say);
	}

	private static String readInput(String prompt)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print(prompt + ": ");
		return scanner.nextLine();
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