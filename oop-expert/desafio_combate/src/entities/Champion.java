package entities;

public class Champion {
	private String name;
	private int life;
	private int attack;
	private int armor;

	public Champion(String name, int life, int attack, int armor) {
		this.name = name;
		this.life = life;
		this.attack = attack;
		this.armor = armor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLife() {
		return life;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public void takeDamage(Champion other) {
		int calculatedDamage = other.getAttack() - armor;
		int finalDamage = calculatedDamage <= 0 ? 1 : calculatedDamage;
		int calculatedLife = life - finalDamage;
		life = calculatedLife <= 0 ? 0 : calculatedLife;
	}
	
	public String status() {
		String currentState = life == 0 ? "(morreu)" : "";
		return name + ": " + life + " de vida " + currentState;
	}
}
