import java.io.FileNotFoundException;
import java.io.IOException;

class BuffSkill implements java.io.Serializable, Skill, Nameable{
	private String name;
	private int skillFactor;
	private String statToBuff;
	private static NameGenerator skillNames = null;
	
	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		BuffSkill.skillNames = namer.namesListFor(BuffSkill.class);
	}
    
    public BuffSkill(String statToBuff, String name, int skillFactor){
        String[] stats = new String[]{"STR","AGI","DEX","INTL","VIT","LUCK"};
        for(int i = 0; i < stats.length; i++){
            if(stats[i].equalsIgnoreCase(statToBuff)){
                this.statToBuff = statToBuff;
            }
        }
        this.name = name;
        this.skillFactor = skillFactor;
    }
    public void levelUp(){
        this.skillFactor+=5;
    }
    
	public BuffSkill(String statToBuff, int skillFactor){
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
				Master.ioManager.showMessage("STR increased!");
				break;
			case AGI:
				p.buffAgi(skillFactor);
				Master.ioManager.showMessage("AGI increased!");
				break;
			case DEX:
				p.buffDex(skillFactor);
				Master.ioManager.showMessage("DEX increased!");
				break;
			case INTL:
				p.buffIntl(skillFactor);
				Master.ioManager.showMessage("INT increased!");
				break;
			case VIT:
				p.buffVit(skillFactor);
				Master.ioManager.showMessage("VIT increased!");
				break;
			case LUCK:
				p.buffLuck(skillFactor);
				Master.ioManager.showMessage("LUCK increased!");
				break;
			default:
				break;
		}
	}
	public String skillName(){
		return this.name;
	}
}
