import java.io.FileNotFoundException;
import java.io.IOException;

class PhysicalDamageSkill implements Skill{
	private String name;
	private int skillFactor;
	private String statToBuff;
	private static NameGenerator skillNames = null;
	
	public void startItself(Scenario scene) throws FileNotFoundException, IOException{
		this.skillNames = scene.namesListFor(PhysicalDamageSkill.class);
	}

	public PhysicalDamageSkill(int skillFactor){
		if(skillNames != null) this.name = skillNames.getName();
		this.skillFactor = skillFactor;
	}
	
	public void useSkill(Player p, Monster m){
		int absoluteDamage = p.getStr()*skillFactor;
		int finalDamage = (int)(absoluteDamage/Math.sqrt(m.getVit()));
		m.damage(finalDamage);
// 		c.showMessage("Skill damage: "+finalDamage); // ver para: postar mesagem em outro lugar
	}
	
	public String skillName(){
		return name;
	}
}	



