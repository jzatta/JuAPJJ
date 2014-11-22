import java.util.*;

class Context{
	private String plot;
	private List<String> eventNames;
	private List<Integer> evtPotentials;

	public String plot(){
		return this.plot;
	}

	public List<String> eventNames(){
		return this.eventNames;
	}

	public List<Integer> evtPotentials(){
		return this.evtPotentials;
	}
}
