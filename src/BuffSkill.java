class BuffSkill implements Skill{
	private String name;
	private SkillTypes type;
	private int skillFactor;
	private String statToBuff;
	private Console c;

	public Skill(String name,SkillTypes type, int skillFactor){
		c = new Console();
		this.type = type;
		this.name = name;
		this.skillFactor = skillFactor;
		this.statToBuff = null; //brace yourself, NullPointerException is coming
	}
	//Buffing skills will require this different constructor because
	//you need to pick a stat to buff. However, I'm not sure this is 
	//the best way to do this, since you can also instance a buffing
	//skill with the other constructor, and the statToBuff variable
	//will remain null.
	public Skill(String name, String statToBuff, int skillFactor){
		c = new Console();
		this.name = name;
		this.type = SkillTypes.BUFFING;
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
		
	public void heal(Player p){
		if(type == SkillTypes.HEALING){
			int healAmt =p.getIntl()*skillFactor;
			p.heal(healAmt);
			c.showMessage("Healing "+healAmt+" HP");
		}
	
	}
	public void buff(Player p){
		if(type == SkillTypes.BUFFING){
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

	}
	public void magicDamage(Player p, Monster m){
		if(type == SkillTypes.MAGICDAMAGE){
			int absoluteDamage = p.getIntl()*skillFactor;
			int finalDamage = (int)(absoluteDamage - 0.25 * m.getIntl());
			m.damageIgnoreArmor(finalDamage);
			c.showMessage("Magic damage: "+finalDamage);
		}
	}
	public void physicalDamage(Player p, Monster m){
		if(type == SkillTypes.PHYSICALDAMAGE){
			int absoluteDamage = p.getStr()*skillFactor;
			int finalDamage = (int)(absoluteDamage/Math.sqrt(m.getVit()));
			m.damage(finalDamage);
			c.showMessage("Skill damage: "+finalDamage);
		}
	}
	public String getName(){
		return name;
	}
    public SkillTypes getSkillType(){
		return type;
	}
	public void dataDebug(){
		System.out.println(name+" "+type+" "+statToBuff);
	}
}	




