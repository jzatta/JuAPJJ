class MagicDamageSkill implements Skill{
	private String name;
	private SkillTypes type;
	private int skillFactor;
	private String statToBuff;
//	private Console c;

	public MagicDamageSkill(String name,SkillTypes type, int skillFactor){
//		c = new Console();
		this.type = type;
		this.name = name;
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
