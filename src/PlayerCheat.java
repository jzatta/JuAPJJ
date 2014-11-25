import java.util.*;

class PlayerCheat extends Player implements java.io.Serializable{
	
	public PlayerCheat(String name){
		super(name);
		for(int i = 0;i < 100; i++){
			increaseStats(Stats.VIT);
		}
	}

}
