class BuffSkill implements Skill{
	private String name;
	private int skillFactor;
	private String statToBuff;
	private Console c;

	public BuffSkill(String name, String statToBuff, int skillFactor){
		c = new Console();
		this.name = name;
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
		String[] stats = new String[]{"STR","AGI","DEX","INTL","VIT","LUCK"};
		int index = -1;
		for(int i = 0; i < stats.length; i++){
			if(statToBuff.equalsIgnoreCase(stats[i])){
				index = i;
			}
		} //se tivesse um enum de stats, não precisava desse for. Porém, preguiça
		switch(index){ 
			case 0:
				p.buffStr(skillFactor);
				c.showMessage("STR increased!");
				break;
			case 1:
				p.buffAgi(skillFactor);
				c.showMessage("AGI increased!");
				break;
			case 2:
				p.buffDex(skillFactor);
				c.showMessage("DEX increased!");
				break;
			case 3:
				p.buffIntl(skillFactor);
				c.showMessage("INT increased!");
				break;
			case 4:
				p.buffVit(skillFactor);
				c.showMessage("VIT increased!");
				break;
			case 5:
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
