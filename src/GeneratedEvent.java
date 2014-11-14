interface GeneratedEvent{
	boolean active();
	boolean damage(int damage);
	int attack();
	boolean dropsItem(int luck);
	Item pickUpItem(int luck);
	String getInteraction();
}