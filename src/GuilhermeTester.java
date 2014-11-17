public class GuilhermeTester{
	public static void main(String[] pao){
		Player p = new Player("Guilérme");
	 	NameGenerator ng = new NameGenerator();
		String[] nouns = 
			new String[]{"Faustão","Henrizes","Chokito","Shogun","Alexis","Hazael","Elefante","Mauro","Truylio","Dracula","Pão","Passainho"};
		String[] adjectives = new String[]{"Bobo","Feio","Tosco","Nojento","Gigante","Colossal","Maravilhoso","Fabuloso","Buffado","Glorioso"};
		for(int i = 0; i < nouns.length; i++){
			ng.addNoun(nouns[i]);
		}
		for(int i = 0; i < adjectives.length; i++){
			ng.addAdjective(adjectives[i]);
		}
		Skill buffDeStr = new Skill("Buff de STR","STR",5);
		Skill curaGenerica = new Skill("Cura tosca",SkillTypes.HEALING,50);
		Skill danoMagico = new Skill("Fogo no rabo",SkillTypes.MAGICDAMAGE,20);
		Skill danoFisico = new Skill("Tacar o piru",SkillTypes.PHYSICALDAMAGE,35);
		p.addSkill(buffDeStr);
		p.addSkill(curaGenerica);
		p.addSkill(danoMagico);
		p.addSkill(danoFisico);
		Monster m = new Monster(ng.getName(),2);
		Combat c = new Combat(p,m);
		c.fight();
	
		}
}
