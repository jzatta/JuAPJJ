class Scenario{
	NameGenerator monsterNames;
	NameGenerator itemNames;
	NameGenerator roomNames;
	
	public Scenario(File templates){
		// Load templates from file
	}
	
	public getRoom(int level){
		return new Room(getRoomName(),level);
	}
	
	public String getRoomName(){
		return room.getName();
	}
	
	public String getMonsterName(){
		// generate name based on templates from file
	}
	
	// TODO methods and attributes to others types of names
}