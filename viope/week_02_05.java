import java.util.Scanner;

public class Mainclass
{
	public static void main(String[] args)
	{
		String name = readInput("Anna koiralle nimi");
		Dog dog = new Dog(name);

		String say;
		do
		{
			say = readInput("Mitä koira sanoo");
		}
		while (! dog.speak(say));

	}

	private static String readInput(String prompt)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}
}


import java.util.Scanner;

public class Dog
{
	private String name;
	private String says;

	public Dog(String name)
	{
		if (name.trim().isEmpty())
		{
			this.name = "Doge";
		}
		else
		{
			this.name = name;
		}

		this.says = "Much wow!";
		System.out.println("Hei, nimeni on " + name);
	}

	public boolean speak(String str)
	{
		if (str.trim().isEmpty())
		{
			System.out.println(this.name + ": " + this.says);
			return false;
		}

		Scanner scanner = new Scanner(str);

		while (scanner.hasNext())
		{
			if (scanner.hasNextBoolean())
			{
				this.say("boolean", scanner.next());
			}
			else if (scanner.hasNextInt())
			{
				this.say("integer", scanner.next());
			}
			else
			{
				System.out.println(scanner.next());
			}
		}


		return true;
	}

	private void say(String type, String value)
	{
		System.out.println("Such " + type + ": " + value);
	}
}