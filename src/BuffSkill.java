import java.io.FileNotFoundException;
import java.io.IOException;

class BuffSkill implements Skill, Nameable{
	private String name;
	private int skillFactor;
	private String statToBuff;
	private IOManager c;
	private static NameGenerator skillNames = null;
	
	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		BuffSkill.skillNames = namer.namesListFor(BuffSkill.class);
	}

	public BuffSkill(String statToBuff, int skillFactor){
		c = new Console();
		if(skillNames != null) this.name = skillNames.getName();
		this. skillFactor = skillFactor;
		boolean validStat = false;
		String[] stats = new String[]{"STR","AGI","DEX","INTL","VIT","LUCK"};
		for(int i = 0; i < stats.length; i++){
			if(statToBuff.equalsIgnoreCase(stats[i])){
					validStat = true;
			}
		}
		if(validStat){
			this.statToBuff = statToBuff;
		}
		else
			this.statToBuff = null;
	}
		
	public void useSkill(Player p, Monster m){
		statToBuff.toUpperCase();
		Stats toBuff = null;
		for(Stats s: Stats.values()){
			if(statToBuff.equalsIgnoreCase(s.name())){
				toBuff = s;
			}
		}
			switch(toBuff){ 
			case STR:
				p.buffStr(skillFactor);
				c.showMessage("STR increased!");
				break;
			case AGI:
				p.buffAgi(skillFactor);
				c.showMessage("AGI increased!");
				break;
			case DEX:
				p.buffDex(skillFactor);
				c.showMessage("DEX increased!");
				break;
			case INTL:
				p.buffIntl(skillFactor);
				c.showMessage("INT increased!");
				break;
			case VIT:
				p.buffVit(skillFactor);
				c.showMessage("VIT increased!");
				break;
			case LUCK:
				p.buffLuck(skillFactor);
				c.showMessage("LUCK increased!");
				break;
			default:
				break;
		}
	}
	public String skillName(){
		return this.name;
	}
}
