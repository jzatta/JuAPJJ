import java.io.FileNotFoundException;
import java.io.IOException;

class HealSkill implements Skill{
	private String name;
	private int skillFactor;
	private Console c;
	private static NameGenerator skillNames = null;
	
	public static void configureItself(Scenario scene) throws FileNotFoundException, IOException{
		HealSkill.skillNames = scene.namesListFor(HealSkill.class);
	}

	public HealSkill(int skillFactor){
		c = new Console();
		if(skillNames != null) this.name = skillNames.getName();
		this.skillFactor = skillFactor;
	}
	public void useSkill(Player p, Monster m){
		int healAmt =p.getIntl()*skillFactor;
		p.heal(healAmt);
		c.showMessage("Healing "+healAmt+" HP");
	}
	public String skillName(){
		return this.name;
	}
	public String getName(){
		return name;
	}
}
