import java.util.*;

class NameGenerator{
	
	private List<String> nouns;
	private List<String> adjectives;

	
	public NameGenerator(){
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
	}

	public String getName(){
		int indNoun = Math.random() * nouns.size();
		int indAdjectives = Math.random() * adjectives.size();
		return noun.get(indNoun) + adjective.get(indAdjectives);
	}
	public void addNoun(String noun){
		nouns.add(noun);
	}
	public void removeNoun(String noun){
		nouns.remove(noun);
	}
	public void addAdjective(String adjective){
		adjectives.add(adjective);
	}
	public void removeAdjective(String adjective){
		adjectives.remove(adjective);
	}
}
