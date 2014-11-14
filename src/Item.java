interface Item{
	
	int reduceDamage();
		// if equipped, can reduce damage suffered by player
	int increaseDamage();
		// if equipped, can increase damage applied by player
	double buyPrice();
		// return buy price something like: valueOfItem * 1.2, same to sell(valueOfItem * 0.8). Verify to use an integer.
	double sellPrice();
	double weight();
	ItemTypes itemType();
}
