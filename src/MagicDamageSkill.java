class MagicDamageSkill implements Skill{
	private String name;
	private SkillTypes type;
	private int skillFactor;
	private String statToBuff;
	private Console c;

	public MagicDamageSkill(String name,SkillTypes type, int skillFactor){
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
	public MagicDamageSkill(String name, String statToBuff, int skillFactor){
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
    public SkillTypes getSkillType(){
		return type;
	}
	public void dataDebug(){
		System.out.println(name+" "+type+" "+statToBuff);
	}
}
