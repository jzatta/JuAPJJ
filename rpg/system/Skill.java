package rpg.system;

import java.util.*;

public class Skill{
	
	private String skillName,category;
	private int mpCost;
	private int skillId;
	private String description;
	public static final String[] CATEGORIES 
		= new String[]{"damage","healing","buff"};
	
	public Skill(String name, int id, int cost, String cat){
		skillName = name;
		skillId = id;
		mpCost = cost;
		boolean valid = false;
		for(String c:CATEGORIES){
			if(cat.equals(c)){
				valid = true;
			}
		}
		if(valid){
			category = cat;
		}
		else{
			category = null;
		}
		description = "";

	}
	public String getSkillName(){ return skillName; }
	public int getMpCost(){ return mpCost; } 
	public int getSkillId(){ return skillId; } 
	public String getDescription(){ return description; }
	public String getCategory(){ return category; }
	
	public void setSkillName(String name){
		skillName = name;
	}
	public void setDescription(String desc){
		description = desc;
	}
	public void setMpCost(int cost){
		mpCost = cost;
	}
	public void setSkillId(int id){
		skillId = id;
	}

	
}