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
		System.out.println(g.toJson(s));
	}
}
