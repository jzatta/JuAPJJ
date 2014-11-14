import java.util.Scanner;

public class Combat{
	private Player player;
	private Monster monster;

	public Combat(Player p, Monster m){
		player = p;
		monster = m;
	}
	public void fight(){
		boolean fighting = true;
		boolean playerFirst = checkFirst();
		while(fighting && player.isAlive() && monster.active()){
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
		System.out.println("End of battle"); //placeholder
	}
	public boolean playerAction(){
		int actionCommand = getActionCommand();
		if(actionCommand == 1){
			playerAttack();
		}
		if(actionCommand == 2){
			playerSkill();
			}
		}
		if(actionCommand == 3){
			playerItem();
		}
		if(actionCommand == 4){
			return !tryRun();
		}
		if(!monster.active()){
			return false;
		}
		return true;
	}
	public int getActionCommand(){
		while(true){
			System.out.println("What will "+player.getName()+" do?");
			System.out.println("1.Fight\n2.Skill\n3.Item\n4.Run");
			Scanner input = new Scanner(System.in);
			int action = input.nextInt();
			if(action < 1 || action > 4){
				System.out.println("Invalid option");
			}
			else{
				return action;
			}
		}
	}
	public void playerAttack(){
		System.out.println("Enemy HP: "+monster.getHP());
		int absoluteDamage = (int)(((Math.pow(p.getStr(),3) / 32) + 32) * 16 / 16);
		int enemyDefense = (int)(((Math.pow(m.getVit() - 280.4 ,2)/110)+16));
		int finalDamage = (int)((absoluteDamage*enemyDefense/730)+Math.random()*5*p.getLuck());
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
		int runTest = Math.random()*100 - player.getLuck();
		if (runTest <= (monster.getLevel()*5){
			return true;
		}
		return false;
	}

} 
