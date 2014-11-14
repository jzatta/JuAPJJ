Interface GeneratedEvent{
	boolean actived();
	boolean attack(int damage);
	int counterAttack();
	boolean hasItem(int luck);
	Item pickUpItem(int luck);
}