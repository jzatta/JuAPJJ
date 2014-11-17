import java.util.*;
import java.io.IOException;

public class Combat{ //implements ActionListener (futuramente)
	private Player player;
	private Monster monster;

	public Combat(Player p, Monster m){
		player = p;
		monster = m;
	}
	public void fight(){
		System.out.println(monster.getInteraction());
		boolean fighting = true;
		boolean playerFirst = checkFirst();
		while(fighting && player.isAlive() && monster.active()){
			System.out.println("Your HP: "+player.getHP());
			System.out.println("Enemy HP: "+monster.getHP());
			if(playerFirst){
				fighting = playerAction();
				playerFirst = false;
			}
			if(monster.active() && fighting){
				fighting = monsterAction();
			} 
			if(player.isAlive() && fighting){
				fighting = playerAction();
			}			
		}
		player.resetStats(); //remove any buffs or debuffs the player has
		System.out.println("End of battle"); //placeholder
	}
	public boolean playerAction(){ // futuro actionPerformed quando tiver GUI. 
		int actionCommand = getAction();
		if(actionCommand == 1){
			playerAttack();
		}
		if(actionCommand == 2){
				playerSkill();
		}
		
		if(actionCommand == 4){
			return tryRun();
		}
		if(!monster.active()){
			return false;
		}
		return true;
	}
	public int getAction(){
		int action= 1;
		while(true){
			System.out.println("What will "+player.getName()+" do?");
			System.out.println("1.Fight\n2.Skill\n3.Item\n4.Run");
			Scanner input = new Scanner(System.in);
			try{
				action = input.nextInt();
			
				if(action < 1 || action > 4){
					System.out.println("Invalid option");
				}
				else{
					break;
				} 				
				
			}catch(InputMismatchException e){
				System.out.println("Eu pedi um inteiro mano");
			}
	
		}	
		return action;
	}
	public void playerAttack(){
		System.out.println("Enemy HP: "+monster.getHP());
		int absoluteDamage = (int)(((Math.pow(player.getStr(),3) / 32) + 32) * 16 / 16);
		int enemyDefense = (int)(((Math.pow(monster.getVit() - 280.4 ,2)/110)+16));
		int finalDamage = (int)((absoluteDamage*enemyDefense/730)+Math.random()*5*player.getLuck());
		boolean crit = playerCritTest();
		if(crit){
			finalDamage*=2;
			System.out.println("Critical hit!");
		}
		monster.damage(finalDamage);
		System.out.println("Foe "+monster.getName()+" took "+finalDamage+" damage.");
		System.out.println(monster.getName()+"'s hp is now "+monster.getHP());
	}
	public void playerSkill(){
		List<Skill> playerSkills = player.listSkills();
		String skillsList = "";
		for(int i = 0; i < playerSkills.size(); i++){
			skillsList += i+1+"."+playerSkills.get(i).getName()+"\n";
		}
		System.out.println("Which skill?\n"+skillsList);
		Scanner in = new Scanner(System.in);
		int skillToBeUsed = in.nextInt()-1;
		useSkill(playerSkills.get(skillToBeUsed));
	}
	public void useSkill(Skill s){
		SkillTypes type = s.getSkillType();
		switch(type){
			case HEALING:
				s.heal(player);
				System.out.println("Your HP is now "+player.getHP());
				break;
			case BUFFING:
				s.buff(player);
				break;
			case PHYSICALDAMAGE:
				s.physicalDamage(player,monster);
				System.out.println("Foe "+monster.getName()+"'s HP is now "+monster.getHP());
				break;
			case MAGICDAMAGE:
				s.magicDamage(player,monster);
				System.out.println("Enemy's HP: "+monster.getHP());
				break;

		}
	}
	public boolean tryRun(){
		int runTest = (int)(Math.random()*100 - player.getLuck());
		if (runTest <= (monster.getLevel()*5)){
			return true;
		}
		return false;
		}
	public boolean monsterAction(){
			int absoluteDamage = (int)((Math.pow(monster.getStr(),3)/32)+32);
			int enemyDefense = (int)((Math.pow(monster.getVit()-280.4,2)/110)+16);
			int finalDamage = (int)((absoluteDamage*enemyDefense/730)+Math.random()*5*player.getLuck());
			player.damage(finalDamage);
			System.out.println("You took "+finalDamage+" damage.");
			if(player.isAlive()){
				return true;
			}
			return false;
	}
	public boolean playerCritTest(){
		if(Math.random()*100 < player.getLuck()){
			return true;
		}
		return false;
	}
	public boolean checkFirst(){
		if(player.getAgi() > monster.getAgi())
			return true;
		return false;
	}

} 
