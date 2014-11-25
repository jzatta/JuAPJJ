class Main{
	public static void main(String[] args){
		IOManager ioManager = null;
		if(args.length > 0 && args[0].equals("c")) {
			ioManager = new Console();
		}else{
			ioManager = new GUI();
		}
		new Master(ioManager).run();
	}
}
