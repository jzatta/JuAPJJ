package rpg.system;

public class HealingSkill extends Skill implements Healable{
	
	public HealingSkill(String name, int id, int cost){		
		super(name,id,cost,"healing");		
	}
	
	public int heal(int healingFactor){
		return healingFactor+(int)(Math.random()*100)%20;
	}
	

}
