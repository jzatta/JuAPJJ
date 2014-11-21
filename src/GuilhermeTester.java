import java.util.*;

public class GuilhermeTester{
	//A bagunça abaixo é só para propositos de teste e não foi feita visando posterior reuso e/ou depuração e/ou compreensão.
	public static void main(String[] pao){
		Player p = new Player("Guilérme");
	 	NameGenerator ng = new NameGenerator();
		NameGenerator roomNames = new NameGenerator();
		String[] roomNouns = new String[]{"Salão","Cozinha","Piscina","Igreja","Caverna","PC com Windows"};
		String[] roomAdjectives = new String[]{"Grande","Pequeno(a)","Escuro(a)","Glorioso(a)","Não tão glorioso(a)","Cheio(a) de vírus"};
		String[] nouns = 
			new String[]{"Faustão","Henrizes","Chokito","Shogun","Alexis","Hazael","Elefante","Mauro","Truylio","Dracula","Pão","Passainho"};
		String[] adjectives = new String[]{"Bobo","Feio","Tosco","Nojento","Gigante","Colossal","Maravilhoso","Fabuloso","Buffado","Glorioso"};
		for(int i = 0; i < nouns.length; i++){
			ng.addNoun(nouns[i]);
		}
		for(int i = 0; i < adjectives.length; i++){
			ng.addAdjective(adjectives[i]);
		}
		for(int i = 0; i < roomNouns.length; i++){
			roomNames.addNoun(roomNouns[i]);
		}
		for(int i = 0; i < roomAdjectives.length; i++){
			roomNames.addAdjective(roomAdjectives[i]);
		}
		Scenario cena = new Scenario(roomNames);
		Room sala = cena.getRoom(1);
		String nomeSala = cena.getRoomName();
		Room.addGeneratedEvent(Monster.class,ng,2132);
		Skill buffDeStr = new BuffSkill("Buff de STR","STR",5);
		Skill curaGenerica = new HealSkill("Cura tosca",SkillTypes.HEALING,50);
		Skill danoMagico = new MagicDamageSkill("Fogo no rabo",SkillTypes.MAGICDAMAGE,20);
		Skill danoFisico = new PhysicalDamageSkill(35);
		p.addSkill(buffDeStr);
		p.addSkill(curaGenerica);
		p.addSkill(danoMagico);
		p.addSkill(danoFisico);
		GeneratedEvent m = sala.getEvent();
			//buffDeStr.dataDebug();
		if(m != null && m instanceof Monster){
			Console console = new Console();
			console.showMessage("You are in "+nomeSala);
			Combat c = new Combat(p,(Monster)m);
			c.fight();
		}

		
	}
}
