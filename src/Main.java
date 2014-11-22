class Main{
	public static void main(String[] args){
		IOManager ioManager = new Console();
		if(args.length > 0 && args[0].equals("g")) {
			ioManager = new GUI();
		}
		new Master(ioManager).run();
	}
}
