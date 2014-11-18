public class Weapon implements Item{
	private int damageLevel;
	private int minimumLevel; // level the Player must have to equip the weapon
	private WeaponClass weaponClass;
	private int rarity;

	public Weapon(int damageLevel, int minimumLevel,WeaponClass weaponClass,int rarity){
		this.damageLevel = damageLevel;
		this.minimumLevel = minimumLevel;
		this.weaponClass = weaponClass;
		this.rarity = rarity;
	}
	public int reduceDamage(){
		return 0;
	}
	public int increaseDamage(){
		return damageLevel; //if equipped by the player
	}
	public double buyPrice(){
		return 1.2*damageLevel; //the better the item, the more gold it costs
	}
	public double sellPrice(){
		return damageLevel*0.8; // multiplier for the buy price of the weapon
		//TODO implement something that actually uses this price
		//TODO use the item rarity in this calculation somehow
	}
	public double weight(){
		switch(weaponClass){
			case DAGGER:
				return 2;
			case SWORD:
				return 5;
			case AXE:
				return 12;
			case TWO_HANDED_SWORD:
				return 20;
			case TWO_HANDED_AXE:
				return 30;
		}
		return 0;
	}
	public ItemTypes itemType(){
		return ItemTypes.Weapon;
	}
	public int rarity(){
		return rarity;
	}
	/*
	   public Carregador emprestaACaneta(){
	   	return carregador;
	   }
	  */
}




	
