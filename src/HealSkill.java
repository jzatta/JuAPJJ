class HealSkill implements Skill{
	private String name;
	private int skillFactor;
	private Console c;

	public HealSkill(String name,SkillTypes type, int skillFactor){
		c = new Console();
		this.name = name;
		this.skillFactor = skillFactor;
	}
	public void useSkill(Player p, Monster m){
		int healAmt =p.getIntl()*skillFactor;
		p.heal(healAmt);
		c.showMessage("Healing "+healAmt+" HP");
	}
	public String skillName(){
		return this.name;
	}
	public String getName(){
		return name;
	}
}
