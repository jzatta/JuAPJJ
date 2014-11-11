package rpg.system;
import java.util.*;

public class Combat {
	
	public Mob generateEnemy(int hp,int str,int agi, int dex, int vit, int luck, int intl){
		return new Mob(hp,str,agi,dex,vit,luck,intl);
	}
	public Mob generateRandomEnemy(int level){
		int hp =(int)((Math.random()*100)%10*(level+10));
		int str =(int)((Math.random()*100)%(level+10));
		int agi =(int)((Math.random()*100)%(level+10));
		int dex =(int)((Math.random()*100)%(level+10));
		int vit =(int)((Math.random()*100)%(level+10));
		int luck =(int)((Math.random()*100)%(level+10));
		int intl =(int)((Math.random()*100)%(level+10));
		return new Mob(hp,str,agi,dex,vit,luck,intl);
	}
	
	public void generateBattle(){
		
	}
	public void announceEndOfBattle(){
		Console.battleEnded();
	}
	
	public void fight(Player p, Mob m){
		
		boolean fighting =	true;
		int first = checkFirst(p.getAgi(),m.getAgi());
		while(fighting && p.getHp() != 0 && m.getHp() != 0){
			//IM IN YR LOOP
			if(first == 1){
				fighting = playerAction(p,m);
				first = 0;
			}
			if(m.getHp() != 0 && fighting){
				mobAction(p,m);
			}
			else{
				youWin();
			}
				
			if(p.getHp() != 0 && fighting){
				fighting = playerAction(p,m);	
			}
			else{
				youLose();
				fighting = false; //IM OUTTA YR LOOP
				break;
			}
			
		}
		Console.battleEnded();
			
		
	}
	public boolean playerAction(Player p, Mob m){
		//System.out.println("O player agiu!");		
		int action = Console.combatMenu();		
		if (action == 2){
			youLose();
			return false;
		}
		if (action == 1){
			playerAttack(p,m);
			if(m.getHp() == 0){
				return false;
			}
			
		}
		if (action == 3){
			List<Skill> skills = p.getSkills();
			int skillToBeUsed = Console.skillMenu(p.listSkills());
			useSkill(skills.get(skillToBeUsed),p);
		}
		return true;
	}
	public void mobAction(Player p, Mob m){
		Console.showMessage("O inimigo atacou!!!");
		mobAttack(p,m);
	}

	public int checkFirst(int pAgi,int mAgi){
		
		if(pAgi > mAgi){
			return 1; //player ataca primeiro
		}
		return 0; //mob ataca primeiro
	}
	public void youLose(){
		Console.announceDefeat();
	}
	public void youWin(){
		Console.announceVictory();
	}
	
	public void playerAttack(Player p, Mob m){
		Console.showEnemyHP(m.getHp());
		int absoluteDamage = (int)(((Math.pow(p.getStr(),3) / 32) + 32) * 16 / 16);
		int enemyDefense = (int)(((Math.pow(m.getVit() - 280.4 ,2)/110)+16));
		int finalDamage = (int)((absoluteDamage*enemyDefense/730)+Math.random()*5*p.getLuck());
		boolean crit = criticalTest(p);
		if(crit){
			finalDamage*=2;
			Console.showMessage("Critical hit!");
		}
		m.damage(finalDamage);
		Console.damageReport("O inimigo ",finalDamage);
		//TODO informar o nome do mob
		Console.showEnemyHP(m.getHp());
		
	}
	public void mobAttack(Player p, Mob m){
		System.out.println("O seu HP eh "+p.getHp());
		int absoluteDamage = (int)(((Math.pow(m.getStr(),3) / 32) + 32) * 16 / 16);
		int playerDefense = (int)(((Math.pow(p.getVit() - 280.4 ,2)/110)+16));
		int finalDamage = absoluteDamage*playerDefense/730;
		boolean crit = criticalTest(m);
		if(crit){
			finalDamage*=2;
			System.out.println("Critou");
		}
		p.damage(finalDamage);
		Console.damageReport("Você ",finalDamage);
		Console.showPlayerHP(p.getHp()); 
	}
	public boolean criticalTest(Mob m){
		int criticalChance = m.getLuck();
		int criticalTest = (int)(Math.random()*100);
		if(criticalTest <= criticalChance){
			return true;
		}
		return false;
	}
	public boolean criticalTest(Player p){
		int criticalChance = p.getLuck();
		int criticalTest = (int)(Math.random()*100);
		if(criticalTest <= criticalChance){
			return true;
		}
		return false;
	}
	public void useSkill(Skill s, Player p){
		if(s instanceof HealingSkill){
			p.heal(((HealingSkill) s).heal(20));
		}
		if(s.getCategory().equalsIgnoreCase("damage")){
			
		}
		if(s.getCategory().equalsIgnoreCase("buff"));
	}

}
