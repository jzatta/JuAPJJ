import java.util.Scanner;

public class Console implements IOManager{
	private Scanner input;

	Console(){
		input = new Scanner(System.in);
	}
	public String getActionCommand(){
		String command = input.nextLine();
		return command.toLowerCase();
	}
	public int getCommand(){
		int command = input.nextInt();
		return command;
	}
	public String getString(String title){
		showMessage(title);
		return input.next();
	}
	public void showMessage(String message){
		System.out.println(message);
	}
	public String promptForString(String message){
		return input.nextLine();
	}
	public void clearScreen(){
		System.out.println("\033[H\033[2J");
	}
	public void waitInteraction(){
		input.nextLine();
		input.nextLine();
	}
}
