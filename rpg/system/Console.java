package rpg.system;

import java.util.Scanner;

public class Console {
	
	public static void showMessage(String message){
		System.out.println(message);
	}
	public static void battleEnded(){
		System.out.println("End of battle!");
	}
	public static int combatMenu(){
		Scanner input = new Scanner(System.in);
		System.out.println("É tempo de agir!\n1. Tretar \n2. Fugir\n3. Skill");
		int playerAction = input.nextInt();
		return playerAction;		
	}
	public static void showEnemyHP(int hp){
		System.out.println("O HP atual do inimigo é: "+hp);
	}
	public static void showPlayerHP(int hp){
		System.out.println("Seu HP é: "+hp);
	}
	public static void damageReport(String quem,int dano){
		System.out.println(quem+"recebeu "+dano+" de dano");
		//TODO: atualizar para informar o nome do player ou do mob
	}
	public static void announceDefeat(){
		System.out.println("Você caiu em batalha");
	}
	public static void announceVictory(){ 
		//TODO uma versão que informa a experiência ganha
		System.out.println("Você prevaleceu sobre o seu oponente!");
	}
	public static int skillMenu(String list){
		System.out.println("Which skill?");
		System.out.println(list);
		Scanner input = new Scanner(System.in);
		int skillSelected = input.nextInt()-1;
		return skillSelected;
	}

}
