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

		
	public void heal(Player p){
		int healAmt =p.getIntl()*skillFactor;
		p.heal(healAmt);
//		c.showMessage("Healing "+healAmt+" HP");
	}
	public void magicDamage(Player p, Monster m){
		int absoluteDamage = p.getIntl()*skillFactor;
		int finalDamage = (int)(absoluteDamage - 0.25 * m.getIntl());
		m.damageIgnoreArmor(finalDamage);
	//	c.showMessage("Magic damage: "+finalDamage);
		}

	public String skillName(){
		return name;
	}
	public void useSkill(Combat c){

	}
}	




