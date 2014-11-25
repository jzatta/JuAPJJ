interface IOManager{
	String getActionCommand();
	int getCommand();
	void clearScreen();
	String getString(String title);
	void showMessage(String m);
	void waitInteraction();
}
