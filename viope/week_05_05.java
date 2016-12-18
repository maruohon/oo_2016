package masa;

import java.util.Scanner;

public class Mainclass
{
	private static Character character = null;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int selection = 0;

		do
		{
			printMainMenu();
			selection = scanner.nextInt();
			handleSelection(selection, scanner);
		} while (selection != 0);
	}

	private static void handleSelection(int selection, Scanner scanner)
	{
		switch (selection)
		{
			case 1: // Create character
				createCharacter(scanner);
				break;
			case 2: // Fight
				if (character != null)
				{
					character.fight();
				}
				break;
		}
	}

	private static void createCharacter(Scanner scanner)
	{
		int characterSel = 0;
		int weaponSel = 0;
		Character.WeaponBehaviour weapon = null;

		while (characterSel < 1 || characterSel > 4)
		{
			printCharacterCreationMenu();
			characterSel = scanner.nextInt();
		}

		while (weaponSel < 1 || weaponSel > 4)
		{
			printWeaponCreationMenu();
			weaponSel = scanner.nextInt();
		}

		switch (weaponSel)
		{
			case 1: weapon = new Character.KnifeBehaviour();	break;
			case 2: weapon = new Character.AxeBehaviour();		break;
			case 3: weapon = new Character.SwordBehaviour();	break;
			case 4: weapon = new Character.ClubBehaviour();		break;
		}

		switch (characterSel)
		{
			case 1: character = new Character.King(weapon);		break;
			case 2: character = new Character.Knight(weapon);	break;
			case 3: character = new Character.Queen(weapon);	break;
			case 4: character = new Character.Troll(weapon);	break;
		}
	}

	private static void printMainMenu()
	{
		System.out.println("*** TAISTELUSIMULAATTORI ***");
		System.out.println("1) Luo hahmo");
		System.out.println("2) Taistele hahmolla");
		System.out.println("0) Lopeta");
		System.out.print("Valintasi: ");
	}

	private static void printCharacterCreationMenu()
	{
		System.out.println("Valitse hahmosi: ");
		System.out.println("1) Kuningas");
		System.out.println("2) Ritari");
		System.out.println("3) Kuningatar");
		System.out.println("4) Peikko");
		System.out.print("Valintasi: ");
	}

	private static void printWeaponCreationMenu()
	{
		System.out.println("Valitse aseesi: ");
		System.out.println("1) Veitsi");
		System.out.println("2) Kirves");
		System.out.println("3) Miekka");
		System.out.println("4) Nuija");
		System.out.print("Valintasi: ");
	}
}



package masa;

public abstract class Character
{
	protected WeaponBehaviour weapon;

	public Character(WeaponBehaviour weapon)
	{
		this.weapon = weapon;
	}

	public abstract void fight();

	public static class King extends Character
	{
		public King(WeaponBehaviour weapon)
		{
			super(weapon);
		}

		@Override
		public void fight()
		{
			System.out.println("King tappelee aseella " + this.weapon.getName());
		}
	}

	public static class Queen extends Character
	{
		public Queen(WeaponBehaviour weapon)
		{
			super(weapon);
		}

		@Override
		public void fight()
		{
			System.out.println("Queen tappelee aseella " + this.weapon.getName());
		}
	}

	public static class Knight extends Character
	{
		public Knight(WeaponBehaviour weapon)
		{
			super(weapon);
		}

		@Override
		public void fight()
		{
			System.out.println("Knight tappelee aseella " + this.weapon.getName());
		}
	}

	public static class Troll extends Character
	{
		public Troll(WeaponBehaviour weapon)
		{
			super(weapon);
		}

		@Override
		public void fight()
		{
			System.out.println("Troll tappelee aseella " + this.weapon.getName());
		}
	}

	public static abstract class WeaponBehaviour
	{
		private String name;

		public WeaponBehaviour(String name)
		{
			this.name = name;
		}

		public String getName()
		{
			return this.name;
		}

		public abstract void useWeapon();
	}

	public static class AxeBehaviour extends WeaponBehaviour
	{
		public AxeBehaviour()
		{
			super("Axe");
		}

		@Override
		public void useWeapon()
		{
		}
	}

	public static class SwordBehaviour extends WeaponBehaviour
	{
		public SwordBehaviour()
		{
			super("Sword");
		}

		@Override
		public void useWeapon()
		{
		}
	}

	public static class KnifeBehaviour extends WeaponBehaviour
	{
		public KnifeBehaviour()
		{
			super("Knife");
		}

		@Override
		public void useWeapon()
		{
		}
	}

	public static class ClubBehaviour extends WeaponBehaviour
	{
		public ClubBehaviour()
		{
			super("Club");
		}

		@Override
		public void useWeapon()
		{
		}
	}
}
