import java.io.FileNotFoundException;
import java.io.IOException;

class MagicDamageSkill implements java.io.Serializable, Skill, Nameable{
	private String name;
	private int skillFactor;
	private String statToBuff;
//	private Console c;
	private static NameGenerator skillNames = null;
	
	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		MagicDamageSkill.skillNames = namer.namesListFor(MagicDamageSkill.class);
	}
    public MagicDamageSkill(String name, int skillFactor){
        this.name = name;
        this.skillFactor=skillFactor;
    }

	public MagicDamageSkill(int skillFactor){
//		c = new Console();
		if(skillNames != null) this.name = skillNames.getName();
		this.skillFactor = skillFactor;
	}

	public void useSkill(Player p, Monster m){
		int absoluteDamage = p.getIntl()*skillFactor;
		int finalDamage = (int)(absoluteDamage - 0.25 * m.getIntl());
		m.damageIgnoreArmor(finalDamage);
		//c.showMessage("Magic damage: "+finalDamage);
	}
	public String skillName(){
		return this.name;
	}
	public String getName(){
		return name;
	}
}
