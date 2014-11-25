import java.io.FileNotFoundException;
import java.io.IOException;

class HealSkill implements java.io.Serializable, Skill, Nameable{
	private String name;
	private int skillFactor;
	private static NameGenerator skillNames = null;
    	
	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		HealSkill.skillNames = namer.namesListFor(HealSkill.class);
	}
    
    public HealSkill(String name, int skillFactor){
        this.name = name;
        this.skillFactor = skillFactor;
    }
    public void levelUp(){
        this.skillFactor+=5;
    }
	public HealSkill(int skillFactor){
		if(skillNames != null) this.name = skillNames.getName();
		this.skillFactor = skillFactor;
	}
	public void useSkill(Player p, Monster m){
		int healAmt =p.getIntl()*skillFactor;
		p.heal(healAmt);
		Master.ioManager.showMessage("Healing "+healAmt+" HP");
	}
	public String skillName(){
		return this.name;
	}
}
