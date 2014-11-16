import java.util.Scanner;

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
		int action;
		while(true){
			System.out.println("What will "+player.getName()+" do?");
			System.out.println("1.Fight\n2.Skill\n3.Item\n4.Run");
			Scanner input = new Scanner(System.in);
			action = input.nextInt();
			if(action < 1 || action > 4){
				System.out.println("Invalid option");
			}
			else{
				break;
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
	}
	public void playerSkill(){
		//TODO
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
