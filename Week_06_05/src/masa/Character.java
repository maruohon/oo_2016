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
