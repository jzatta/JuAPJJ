class Main{
	public static void main(String[] args){
		IOManager ioManager = new GUI();
		if(args.length > 0 && args[0].equals("c")) {
			ioManager = new Console();
		}
		new Master(ioManager).run();
	}
}
