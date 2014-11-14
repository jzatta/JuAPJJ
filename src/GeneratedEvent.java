Interface GeneratedEvent{
	boolean actived();
	int attack(int damage);
	int counterAttack();
	boolean hasItem(int luck);
	Item pickUpItem(int luck);
}