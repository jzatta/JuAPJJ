package rpg.system;

public class Main {
	

	public static void main(String[] args) {
		Player p = new Player();
		p.addSkill(new HealingSkill("Teste",32,32));
		Combat c = new Combat();
		//p.setLuck(14);
		//Combat.fight(p, new Mob(70,5,5,5,5,5,5));
		//testeCrit(p);
		//System.out.println(p.listSkills());
		c.fight(p, c.generateRandomEnemy(1));
	}
	public static void testeCrit(Player p){
		int criticos = 0;
		for(int i = 0; i < 100; i++){
			int criticalChance = p.getLuck();
			int criticalTest = (int)(Math.random()*100);
			if(criticalTest < criticalChance){
				criticos++;
			}
		}
		System.out.println(criticos);
	}
	public static void testeRandomMob(int level, Combat c){
		Mob test = c.generateRandomEnemy(level);
		System.out.println(test.toString());
	}

}
