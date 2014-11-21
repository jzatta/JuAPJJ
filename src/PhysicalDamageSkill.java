class PhysicalDamageSkill implements Skill{
	private String name;
	private int skillFactor;
	private String statToBuff;
	private static NameGenerator skillNames = null;
	
	public static void startItself(Scenario scene) throws FileNotFoundException, IOException{
		this.skillNames = scene.namesListFor(PhysicalDamageSkill.class);
	}

	public PhysicalDamageSkill(int skillFactor){
		this.name = skillNames.getName();
		this.skillFactor = skillFactor;
	}
	
	public void useSkill(Combat c){
		int absoluteDamage = p.getStr()*skillFactor;
		int finalDamage = (int)(absoluteDamage/Math.sqrt(m.getVit()));
		c.physicalDamage(finalDamage);
// 		c.showMessage("Skill damage: "+finalDamage); // ver para: postar mesagem em outro lugar
	}
	
	public String skillName(){
		return name;
	}
}	




