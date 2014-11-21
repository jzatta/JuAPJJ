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
	public void showMessage(String message){
		System.out.println(message);
	}
	public String promptForString(String message){
		return input.nextLine();
	}
}
