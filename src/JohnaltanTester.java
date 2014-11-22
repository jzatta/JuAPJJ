import com.google.gson.Gson;

class MyString{
	String aPropria;
	
	public MyString(String aPropria){
		this.aPropria = aPropria;
	}
}

class JohnaltanTester{
	public static void main(String[] args){
		MyString s = new MyString("Ola");
		Gson g = new Gson();
		NameGenerator n1 = null;
		NameGenerator n = g.fromJson("{nouns:[\"Nome1\",\"Nome2\"],adjectives:[\"Adj1\",\"Adj2\"]}",NameGenerator.class);
		try{
			Scenario scene = new Scenario(".");
			n1 = scene.namesListFor(Monster.class);
			System.out.println(n1.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(g.toJson(s));
		System.out.println(n.getName());
		GUI gui = new GUI();
		gui.showMessage(Integer.toString(gui.getCommand()));
		System.out.println("Ola");
	}
}
