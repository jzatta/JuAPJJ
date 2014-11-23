import java.util.*;

public class Combat{ //implements ActionListener (futuramente)
	private Player player;
	private Monster monster;

	public Combat(Player p, Monster m){
		player = p;
		monster = m;
	}
	public void fight(){
		Master.ioManager.showMessage(monster.getInteraction());
		boolean fighting = true;
		boolean playerFirst = checkFirst();
		while(fighting && player.isAlive() && monster.active()){
			Master.ioManager.showMessage("Your HP: "+player.getHP());
			Master.ioManager.showMessage("Enemy HP: "+monster.getHP());
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
		Master.ioManager.showMessage("End of battle"); //placeholder
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
			Master.ioManager.showMessage("What will "+player.getName()+" do?");
			Master.ioManager.showMessage("1.Fight\n2.Skill\n3.Item\n4.Run");
			
			try{
				action = Master.ioManager.getCommand();
			
				if(action < 1 || action > 4){
					Master.ioManager.showMessage("Invalid option");
				}
				else{
					break;
				} 				
				
			}catch(InputMismatchException e){
				Master.ioManager.showMessage("Eu pedi um inteiro mano");
			}
	
		}	
		return action;
	}
	public void playerAttack(){
		Master.ioManager.showMessage("Enemy HP: "+monster.getHP());
		int absoluteDamage = (int)(((Math.pow(player.getStr(),3) / 32) + 32) * 16 / 16);
		int enemyDefense = (int)(((Math.pow(monster.getVit() - 280.4 ,2)/110)+16));
		int finalDamage = (int)((absoluteDamage*enemyDefense/730)+Math.random()*5*player.getLuck());
		boolean crit = playerCritTest();
		if(crit){
			finalDamage*=2;
			Master.ioManager.showMessage("Critical hit!");
		}
		monster.damage(finalDamage);
		Master.ioManager.showMessage("Foe "+monster.getName()+" took "+finalDamage+" damage.");
		Master.ioManager.showMessage(monster.getName()+"'s hp is now "+monster.getHP());
	}
	public void playerSkill(){
		List<Skill> playerSkills = player.listSkills();
		String skillsList = "";
		for(int i = 0; i < playerSkills.size(); i++){
			skillsList += i+1+"."+playerSkills.get(i).skillName()+"\n";
		}
		Master.ioManager.showMessage("Which skill?\n"+skillsList);
		int skillToBeUsed = Master.ioManager.getCommand();
		receiveSkill(playerSkills.get(skillToBeUsed-1));
	}
	public void receiveSkill(Skill s){
		/*SkillTypes type = s.getSkillType();
		switch(type){
			case HEALING:
				s.heal(player);
				Master.ioManager.showMessage("Your HP is now "+player.getHP());
				break;
			case BUFFING:
				s.buff(player);
				break;
			case PHYSICALDAMAGE:
				s.physicalDamage(player,monster);
				Master.ioManager.showMessage("Foe "+monster.getName()+"'s HP is now "+monster.getHP());
				break;
			case MAGICDAMAGE:
				s.magicDamage(player,monster);
				Master.ioManager.showMessage("Enemy's HP: "+monster.getHP());
				break;

		}*/
		s.useSkill(player,monster); //Verificar onde mostrar mensagens de saida comentadas
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
			Master.ioManager.showMessage("You took "+finalDamage+" damage.");
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
