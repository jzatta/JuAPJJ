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
		NameGenerator n = g.fromJson("{nouns:[\"Nome1\",\"Nome2\"],adjectives:[\"Adj1\",\"Adj2\"]}",NameGenerator.class);
		System.out.println(g.toJson(s));
		System.out.println(n.getName());
	}
}
