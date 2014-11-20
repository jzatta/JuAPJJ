class JulianoTester{
	public static void main(String[] args){
		/*NameGenerator q = new NameGenerator();
		q.addNoun("Sala");
		q.addAdjective("do terror");
		Scenario s = new Scenario(q);*/
		Scenario s = new Scenario(".");
		Room r = s.getRoom(1);
		System.out.println(r.roomName());
		Monster.addItselfRoom(r,s,1);
		GeneratedEvent e = r.getEvent();
		Monster m = (Monster)e;
		System.out.println(m.dataDebug());
	}
}
