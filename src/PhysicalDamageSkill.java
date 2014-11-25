import java.io.FileNotFoundException;
import java.io.IOException;

class PhysicalDamageSkill implements java.io.Serializable, Skill, Nameable{
	private String name;
	private int skillFactor;
	private String statToBuff;
	private static NameGenerator skillNames = null;
	
	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		PhysicalDamageSkill.skillNames = namer.namesListFor(PhysicalDamageSkill.class);
	}
    public PhysicalDamageSkill(String name, int skillFactor){
        this.name = name;
        this.skillFactor = skillFactor;
    }
    public void levelUp(){
        this.skillFactor+=5;
    }
	public PhysicalDamageSkill(int skillFactor){
		if(skillNames != null) this.name = skillNames.getName();
		this.skillFactor = skillFactor;
	}
	
	public void useSkill(Player p, Monster m){
		int absoluteDamage = p.getStr()*skillFactor;
		int finalDamage = (int)(absoluteDamage/Math.sqrt(m.getVit()));
		m.damage(finalDamage);
		Master.ioManager.showMessage("Skill damage: "+finalDamage); // ver para: postar mesagem em outro lugar
	}
	
	public String skillName(){
		return name;
	}
}	




