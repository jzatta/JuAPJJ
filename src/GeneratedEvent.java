interface GeneratedEvent{
	boolean active();
	boolean damage(int damage);
	int attack();
	boolean dropsItem(int luck);
	Item pickUpItem(int luck);
	String getInteraction();
	
	boolean addItselfRoom(Room room, int potential);
	void setuptScenario(Scenario scene);
	void setupLevel(int level);
}
