package rpg.system;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Player {
	
	private int[] atributes;
	private int currentHp;
	private PlayerClass pClass;
	private String playerName;
	private String playerStory;
	private List<Skill> skills = new ArrayList<Skill>();
	
	public Player(){
		this.atributes = generateAttributes(0);
		this.currentHp = atributes[0];
		this.pClass = PlayerClass.Aprendiz;
		this.playerName = "Generic player";
		this.playerStory = "";
	}
	
	
	public String toString(){
		return Arrays.toString(atributes)+"\n"+pClass.toString()+
				"\n"+playerName+"\n"+playerStory;
	}
	
	
	
	public int[] generateAttributes(int id){
		int hp,mp,str,agi,dex,luck,vit, intl;
		switch(id){
		case 1: //guerreiro 
			str = 13;
			agi = 7;
			vit = 9;
			dex = 7;
			luck = 5;
			intl = 5;
			break;
		case 2: //mago
			str = 4;
			agi = 9;
			vit = 7;
			dex = 9;
			luck = 3;
			intl = 13;
			break;
		default: //aprendiz
			str = 10;
			agi = 10;
			vit = 15;
			dex = 10;
			luck = 8;
			intl = 5;
			break;
		}
		hp = 100+ 10*vit;
		mp = 10 + intl + intl%2;
		return new int[]{hp,mp,str,agi,dex,luck,vit,intl};
	
	}
	
	public int getHp(){
		return currentHp;
	}
	
	public int getLuck(){
		return atributes[5];
	}
	public int getStr(){
		return atributes[2];
	}
	public int getVit(){
		return atributes[6];
	}
	public void setHp(int hp){
		atributes[0] = hp;
		if(atributes[0] < 0){
			atributes[0] = 0;
		}
	}
	public void setLuck(int l){
		atributes[5] = l;
	}
	public int getAgi(){
		return atributes[3];
	}
	public void damage(int d){
		currentHp-=d;
	}
	public void addSkill(Skill s){
		skills.add(s);
	}
	public void removeSkill(Skill s){
		skills.remove(s);
	}
	public List<Skill> getSkills(){
		return skills;
	}
	public String listSkills(){
		String list = "";
		for (int i = 0; i < skills.size(); i++){
			list+=""+(i+1)+". "+skills.get(i).getSkillName()+"\n";
		}
		return list;
	}
	public void heal(int healing){
		currentHp+=healing;
		if(currentHp > atributes[0]){
			currentHp = atributes[0];
		}
	}

}
